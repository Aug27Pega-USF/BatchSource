package com.revature.daoimpl;

import java.lang.reflect.Field;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;
import com.revature.beans.Account;
import com.revature.beans.CheckingAccount;
import com.revature.beans.SavingsAccount;
import com.revature.interfaces.Dao;
import com.revature.util.ConnectionFactory;

public class AccountDaoImpl implements Dao<Account>{
		
	public static ConnectionFactory cf = ConnectionFactory.getInstance();


	@Override
	public void read(Account t) throws SQLException {
		// TODO Auto-generated method stub
		
	}
	@SuppressWarnings("unchecked")
	@Override
	public Account get(int id) {
		Account account = null;
		Connection conn = cf.getConnection();
		ResultSet rs;
		String query = "SELECT A.ACCOUNT_ID,A.ACCOUNT_STATUS_ID, A.ACCOUNT_BALANCE," + 
				"A.ACCOUNT_DATE_CREATED, B.ACCOUNT_TYPE, C.STATUS_TYPE " + 
				"FROM ACCOUNTS A " + 
				"JOIN ACCOUNTTYPE_LU B ON B.ACCOUNT_TYPE_ID = A.ACCOUNT_TYPE_ID " + 
				"JOIN STATUSTYPE_LU C ON C.STATUS_TYPE_ID = A.ACCOUNT_TYPE_ID " + 
				"WHERE A.ACCOUNT_ID = ?";
		try (PreparedStatement ps = conn.prepareStatement(query)) {
			ps.setInt(1, id);
			rs = ps.executeQuery();
			while(rs.next()) {
				if(rs.getString("ACCOUNT_TYPE").equalsIgnoreCase("CHECKING")) {
				     account = new CheckingAccount();
				} else {
					 account = new SavingsAccount();
				}
				account.setId(rs.getInt("ACCOUNT_ID"));
				account.setStatus(rs.getString("STATUS_TYPE"));
				account.setStatusID(rs.getInt("ACCOUNT_STATUS_ID"));
				account.setBalance(rs.getDouble("ACCOUNT_BALANCE"));
				account.setDateCreate(rs.getDate("ACCOUNT_DATE_CREATED"));
				account.setType(rs.getString("ACCOUNT_TYPE"));
				//account.setTypeID(rs.getInt("ACCOUNT_TYPE_ID"));
				account.setaccountHolders(getHolders(account.getId()));
			}
			rs.close();
			ps.close();
			conn.close();
			return account;
		} catch (SQLException e) {
			e.printStackTrace();
		} catch(NullPointerException e) {
			e.printStackTrace();
			return account ;
		}
		return account;	
	}

	@Override
	public List<Account> getAll() {
		List<Account> acList = new ArrayList<Account>();
		Connection conn = cf.getConnection();
		try (PreparedStatement ps = conn.prepareStatement("SELECT * FROM V_ACCOUNTINFO")) {
			ResultSet rs = ps.executeQuery();//Select from a view
			while(rs.next()) {
				Account s = null;;
				if(rs.getString("ACCOUNT_TYPE").equals("CHECKING"))
					s = new CheckingAccount();
				else if(rs.getString("ACCOUNT_TYPE").equals("SAVINGS"))
					s = new SavingsAccount();
				
				s.setId(rs.getInt("ACCOUNT_ID"));
				s.setStatusID(rs.getInt("ACCOUNT_STATUS_ID"));
				s.setStatus(rs.getString("STATUS_TYPE"));
				s.setBalance(rs.getDouble("ACCOUNT_BALANCE"));
				s.setDateCreate(rs.getDate("ACCOUNT_DATE_CREATED"));
				s.setType(rs.getString("ACCOUNT_TYPE"));
				s.setaccountHolders(getHolders(rs.getInt("ACCOUNT_ID")));
				acList.add(s);
			}
			rs.close();
			ps.close();
			conn.close();
			return acList;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return acList;
	}

	@Override
	public boolean checkExistence(String col, String value) throws SQLException {
		Connection conn = cf.getConnection();
		Long i = 0L;
		ResultSet rs;
		String query = "Select COUNT(*) from BANK_USERS where "+col+" = ?";
			try {
				PreparedStatement ps = conn.prepareStatement(query);
				ps.setString(1, value);
				rs = ps.executeQuery();
				rs.next();
				i = rs.getLong(1);
				rs.close();
				conn.close();
				return (i > 0)? true:false ;
			}  catch (SQLException e) {
				e.printStackTrace();
				return true;
			}
	}

	@Override
	public void create(Account t) throws SQLException {
		System.out.println(t.toString());
		Connection conn = cf.getConnection();
		String query = "call PR_INSERTNEWACCOUNT( ?, ?, ?,?)";
		CallableStatement caller = conn.prepareCall(query);
		caller.setInt(1, t.getStatusID());
		caller.setInt(2, t.getTypeID());
		caller.setDouble(3, t.getBalance());
		caller.setInt(4, (int) t.getaccountHolders().get(0));
		//caller.setDate(5, t.getDateCreate());
		caller.execute();
		caller.close();
		conn.close();
		
	}
	
	@Override
	public void update(Account t, HashMap<String,String> params) throws SQLException {
		Connection conn = cf.getConnection();
	try {
		if(params.containsKey("balance")) {
			t.setBalance(Double.parseDouble(params.get("balance")));
		} else if(params.containsKey("status") && (params.get("status").equals("OPEN")||params.get("status").equals("CLOSED")||params.get("status").equals("PENDING"))) {
			t.setStatus(params.get("status"));
		} else if(params.containsKey("statusID") && (params.get("statusID").equals("1")|| params.get("statusID").equals("2")|| params.get("statusID").equals("3"))) {
			t.setStatusID(Integer.parseInt(params.get("statusID")));
		} else if(params.containsKey("typeID") && (params.get("typeID").equals("1")||params.get("typeID").equals("2"))) {
			t.setTypeID(Integer.parseInt(params.get("typeID")));
		} else if(params.containsKey("type") && (params.get("type").equals("CHECKING")||params.get("type").equals("SAVINGS"))) {
			t.setType(params.get("type"));
		} 
	} catch(Exception e) {
		e.printStackTrace();
	}
		String sql = "UPDATE ACCOUNTS " + 
				"SET ACCOUNT_BALANCE = ?, " + 
				"ACCOUNT_STATUS_ID = ?, " + 
				"ACCOUNT_TYPE_ID = ? " + 
				"WHERE ACCOUNT_ID = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setDouble(1, t.getBalance());
			ps.setInt(2, t.getStatusID());
			ps.setInt(3, t.getTypeID());
			ps.setInt(4, t.getId());
			ps.executeQuery();
			ps.close();
			conn.close();
	}

	@Override
	public void delete(Account t) throws SQLException {
		Connection conn = cf.getConnection();
		String query = "call PR_DELETEACCOUNT(?)";
		CallableStatement caller = conn.prepareCall(query);
		caller.setInt(1, t.getId());
		caller.execute();
		caller.close();
		conn.close();
	}
	
	public List<Account> getAccountsByUser(int id){
		Account account;
		//AccountDaoImpl ac = new AccountDaoImpl();
		List<Account> userAccounts = new ArrayList<Account>();
		Connection conn = cf.getConnection();
		ResultSet rs;
		try {
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM TABLE (F_GETUSERACCOUNTS(?))");
			ps.setInt(1, id);
			rs = ps.executeQuery();
			while(rs.next()) {
				if(rs.getString("ATYPE").equalsIgnoreCase("CHECKING")) {
				     account = new CheckingAccount();
				} else {
					 account = new SavingsAccount();
				}
				account.setId(rs.getInt("ACCOUNTID"));
				account.setStatus(rs.getString("STATUS"));
				account.setBalance(rs.getDouble("BALANCE"));
				account.setDateCreate(rs.getDate("DATECREATE"));
				account.setaccountHolders(getHolders(account.getId()));
				userAccounts.add(account);
			}
			rs.close();
			ps.close();
			conn.close();
			return userAccounts;
		}  catch (SQLException e) {
			e.printStackTrace();
			return userAccounts;				
		}		
	}
	/*Choose fields to update with reflection*/
	public HashMap<String, String> chooseUpdateFields(Account edit) {
		HashMap<String,String> params = new HashMap<String,String>();
		if(edit.getType().equalsIgnoreCase("CHECKING"))
			edit = (CheckingAccount)edit;
		else
			edit = (SavingsAccount)edit;
		@SuppressWarnings("resource")
		Scanner scan = new Scanner(System.in);
		boolean exit = false;
		int x = 0;
		List<String> fields = new ArrayList<String>();		
		for (Field field : edit.getClass().getSuperclass().getDeclaredFields()) {
			x++;
    	    field.setAccessible(true); // You might want to set modifier to public first.
    	    System.out.println(x+") "+field.getName());
    	    fields.add(field.getName());
			} 
		while(!exit) {
			System.out.println("Type a field name listed above that you would like to update.");
			String column = scan.nextLine();
				
			if(!fields.contains(column) || column.equals("logger") || column.equals("id")|| 
					column.equals("dateCreate")|| column.equals("holders")) {
				System.out.println("Not a valid option.");
			} else {
				System.out.println("Enter a new value for this field.");
				String value = scan.nextLine();
				params.put(column,value);
				System.out.println("Would you like to update another field? Enter yes or no.");
				String yn = scan.nextLine();
				switch(yn) {
				case "yes":
					exit = false;
					break;
				case "no":
					exit = true;
					break;
					default:
						System.out.println("Invalid Input.\n**************");
						exit = false;
						break;
				}
			}	
		}
		return params;	
	}
	public List<?> getHolders(int id){
		List<String> userList = new ArrayList<String>();
		String s;
		Connection conn = cf.getConnection();
		String query = "SELECT USER_ID " + 
				"FROM BANK_USERS " + 
				"WHERE user_id " + 
				"IN (SELECT ACCOUNT_OWNER_ID FROM ACCOUNT_CUSTOMER_MAP WHERE ACCOUNT_ID = ?)";
		try(PreparedStatement ps = conn.prepareStatement(query)) {
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				s = rs.getString("USER_ID"); 
				userList.add(s);
			}
			rs.close();
			ps.close();
			return userList;
		} catch (SQLException e) {
			e.printStackTrace();
			return userList;
		}			
	}
	/*Deposit to account*/
	public void deposit(double amount, Account account) {
		Connection conn = cf.getConnection();
		String sql = "UPDATE ACCOUNTS " + 
				"SET ACCOUNT_BALANCE = ? " +  
				"WHERE ACCOUNT_ID = ?";
			try (PreparedStatement ps = conn.prepareStatement(sql)){
				ps.setDouble(1, (account.getBalance() + amount));
				ps.setInt(2, account.getId());
				ps.executeQuery();
				ps.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
	}

	public void withdraw(double amount, Account acc2) {
		Connection conn = cf.getConnection();
		String sql = "UPDATE ACCOUNTS " + 
				"SET ACCOUNT_BALANCE = ? " +  
				"WHERE ACCOUNT_ID = ?";
			try (PreparedStatement ps = conn.prepareStatement(sql)){
				ps.setDouble(1, (acc2.getBalance() - amount));
				ps.setInt(2, acc2.getId());
				ps.executeQuery();
				ps.close();
				conn.close();	
	        } catch (SQLException e) {
		      e.printStackTrace();
	        }
    }
}
