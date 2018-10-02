package com.revature.daoimpl;

import java.lang.reflect.Field;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

import com.revature.beans.Account;
import com.revature.beans.User;
import com.revature.interfaces.Dao;
import com.revature.util.ConnectionFactory;
/*This class is responsible for getting user data
 * from the database.
 */

public class UserDaoImpl implements Dao<User>{
	
	public static ConnectionFactory cf = ConnectionFactory.getInstance();
	private AccountDaoImpl acimpl = new AccountDaoImpl();
	
	@SuppressWarnings("unchecked")
	@Override
	public User get(int id) {
		User s = new User();
		Connection conn = ConnectionFactory.getConnection();
		ResultSet rs;
		String query = "SELECT A.USER_ID,A.FIRSTNAME,A.LASTNAME,A.SOCIAL,A.BIRTHDATE,A.USER_LAST_LOGIN," + 
				"A.PHONE,C.ROLE_TYPE,B.LOGIN_ID, B.LOGIN_USERNAME, B.LOGIN_PASSWORD " + 
				"FROM BANK_USERS A " + 
				"INNER JOIN LOGININFO B ON A.USER_LOGIN_ID = B.LOGIN_ID " + 
				"INNER JOIN ROLETYPE_LU C ON A.USER_ROLE_TYPE_ID = c.role_type_id " + 
				"WHERE  A.USER_ID = ?";
		try (PreparedStatement ps = conn.prepareStatement(query)) {
			ps.setInt(1, id);
			rs = ps.executeQuery();
			while(rs.next()) {
				s.setId(rs.getInt("USER_ID"));
				s.setFirst(rs.getString("FIRSTNAME"));
				s.setLast(rs.getString("LASTNAME"));
				s.setSocial(rs.getString("SOCIAL"));
				s.setBirthDate(rs.getDate("BIRTHDATE"));
				s.setPhone(rs.getString("PHONE"));
				s.setLoginId(rs.getInt("LOGIN_ID"));
				s.setRoleTypeName(rs.getString("ROLE_TYPE"));
				s.setLastLogin(rs.getDate("USER_LAST_LOGIN"));
				s.setUsername(rs.getString("LOGIN_USERNAME"));
				s.setPassword(rs.getString("LOGIN_PASSWORD"));
				s.setAccounts(acimpl.getAccountsByUser(rs.getInt("USER_ID")));
			}
			rs.close();
			ps.close();
			conn.close();
			return s;
		} catch (SQLException e) {
			e.printStackTrace();
		} catch(NullPointerException e) {
			e.printStackTrace();
			return s ;
		}
		return s;	
	}
	
	public User getBySSN(String social){
		User s = null;
		Connection conn = ConnectionFactory.getConnection();
		ResultSet rs;
		String query = "SELECT * FROM TABLE(F_GETBYSSN(?))";
		try (PreparedStatement ps = conn.prepareStatement(query)) {
			ps.setString(1, social);
			rs = ps.executeQuery();
			while(rs.next()) {
				s = new User();
				s.setId(rs.getInt("USERID"));
				s.setFirst(rs.getString("FNAME"));
				s.setLast(rs.getString("LNAME"));
				s.setSocial(rs.getString("SSN"));
				s.setBirthDate(rs.getDate("BIRTHDATE"));
				s.setPhone(rs.getString("USERPHONE"));
				s.setRoleTypeName(rs.getString("UROLE"));
				s.setLoginId(rs.getInt("LOGINID"));
				s.setLastLogin(rs.getDate("LASTLOGIN"));
				s.setUsername(rs.getString("UNAME"));
				s.setPassword(rs.getString("UPASS"));
				s.setAccounts(acimpl.getAccountsByUser(rs.getInt("USERID")));
			}
			rs.close();
			ps.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch(NullPointerException e) {
			e.printStackTrace();
		}
		return s;
	}
	
	public User getByUsn(String username) {
		User s = null;
		Connection conn = ConnectionFactory.getConnection();
		ResultSet rs;
		String query = "SELECT * FROM TABLE(F_GETBYUSN(?))";
		
		try (PreparedStatement ps = conn.prepareStatement(query)) {
			ps.setString(1, username);
			rs = ps.executeQuery();
			while(rs.next()) {
				s = new User();
				s.setId(rs.getInt("USERID"));
				s.setFirst(rs.getString("FNAME"));
				s.setLast(rs.getString("LNAME"));
				s.setSocial(rs.getString("SSN"));
				s.setBirthDate(rs.getDate("BIRTHDATE"));
				s.setPhone(rs.getString("USERPHONE"));
				s.setLoginId(rs.getInt("LOGINID"));
				s.setRoleTypeName(rs.getString("UROLE"));
				s.setLastLogin(rs.getDate("LASTLOGIN"));
				s.setUsername(rs.getString("UNAME"));
				s.setPassword(rs.getString("UPASS"));
				s.setAccounts(acimpl.getAccountsByUser(rs.getInt("USERID")));
			}
			rs.close();
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch(NullPointerException e) {
			e.printStackTrace();
		}
		return s;
	}
	
	/*Gets List Of Users*/
	@Override
	public List<User> getAll() {
		List<User> userList = new ArrayList<User>();
		Connection conn = ConnectionFactory.getConnection();
		try (PreparedStatement ps = conn.prepareStatement("SELECT * FROM V_USERINFO_LOGININFO")){
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				User s = new User();
				s.setId(rs.getInt("USER_ID"));
				s.setFirst(rs.getString("FIRSTNAME"));
				s.setLast(rs.getString("LASTNAME"));
				s.setSocial(rs.getString("SOCIAL"));
				s.setBirthDate(rs.getDate("BIRTHDATE"));
				s.setPhone(rs.getString("PHONE"));
				//s.setLoginId(rs.getInt("LOGIN_ID")); /*Don't Need*/
				s.setRoleTypeId(rs.getInt("USER_ROLE_TYPE_ID"));
				s.setRoleTypeName(rs.getString("ROLE_TYPE"));
				s.setLoginId(rs.getInt("USER_LOGIN_ID"));
				s.setLastLogin(rs.getDate("USER_LAST_LOGIN"));
				s.setUsername(rs.getString("LOGIN_USERNAME"));
				s.setPassword(rs.getString("LOGIN_PASSWORD"));
				//s.setAccounts(getUserAccounts(rs.getInt("USER_ID"))); /*Making a query for each users accounts caused the application to slow down to much*/
				s.setAccounts(new ArrayList<Account>());
				userList.add(s);
			}
			rs.close();
			ps.close();
			conn.close();
			return userList;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return userList;
	}

	@Override
	public void create(User t) throws SQLException {
		Connection conn = ConnectionFactory.getConnection();
		String query = "call PR_INSERTNEWUSER(?, ?, ?, ?, ?, ?,?, ?)";
		CallableStatement caller = conn.prepareCall(query);
		caller.setString(1, t.getFirst());
		caller.setString(2, t.getLast());
		caller.setString(3, t.getSocial());
		caller.setDate(4, t.getBirthDate());
		caller.setString(5, t.getPhone());
		caller.setInt(6, t.getRoleTypeId());
		caller.setString(7, t.getUsername());
		caller.setString(8, t.getPassword());
		caller.execute();
		caller.close();
		conn.close();
	}

	@Override
	public void read(User t) throws SQLException {
		
	}
	@Override
	public void update(User t, HashMap<String, String> params) throws SQLException {
		Connection conn = ConnectionFactory.getConnection();
		if(params.containsKey("birthdate")) {
			try {
				@SuppressWarnings("unlikely-arg-type")
				Date date = Date.valueOf(params.get(Date.valueOf("birthdate")));
				t.setBirthDate(date);
			  } catch(IllegalArgumentException e) {
				  System.out.println("Date Format Is Incorrect.\n************************");
			  }
		} if(params.containsKey("social")) {
			t.setSocial(params.get("social"));
		} if(params.containsKey("last")) {
			t.setLast(params.get("last"));
		} if(params.containsKey("first")) {
			t.setFirst(params.get("first"));
		} if(params.containsKey("phone")) {
			t.setLast(params.get("phone"));
		} if(params.containsKey("username")) {
			t.setLast(params.get("username"));
		} if(params.containsKey("password")) {
			t.setLast(params.get("password"));
		} 
		String sql = "UPDATE BANK_USERS " + 
				"SET FIRSTNAME = ?, " + 
				"LASTNAME = ?, " + 
				"SOCIAL = ?, " + 
				"BIRTHDATE = ?, " + 
				"PHONE = ? "+
				"WHERE USER_ID = ?";
		String loginsql = "UPDATE LOGININFO "+
						  "SET LOGIN_USERNAME = ?, "+
				          "LOGIN_PASSWORD = ? "+
						  "WHERE LOGIN_ID = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, t.getFirst());
			ps.setString(2, t.getLast());
			ps.setString(3, t.getSocial());
			ps.setDate(4, t.getBirthDate());
			ps.setString(5, t.getPhone());
			ps.setInt(6, t.getId());
			PreparedStatement ps2 = conn.prepareStatement(loginsql);
			ps2.setString(1, t.getUsername());
			ps2.setString(2, t.getPassword());
			ps2.setInt(3, t.getLoginId());
			ps.executeQuery();
			ps2.executeQuery();
			ps.close();
			ps2.close();
			conn.close();
	}
	public HashMap<String,String> chooseUpdateFields(User toedit) {
		@SuppressWarnings("resource")
		Scanner scan = new Scanner(System.in);
		boolean exit = false;
		int x = 0;
		List<String> fields = new ArrayList<String>();
		HashMap<String,String> params = new HashMap<String,String>();
		for (Field field : toedit.getClass().getDeclaredFields()) {
			x++;
    	    field.setAccessible(true); // You might want to set modifier to public first.
    	    System.out.println(x+") "+field.getName());
    	    fields.add(field.getName());
			} 
		while(!exit) {
			System.out.println("Type a field name listed above that you would like to update.");
			String column = scan.nextLine();
			if(!fields.contains(column) || column.equals("id") || column.equals("accounts")|| 
					column.equals("loginId")||column.equals("roleTypeId")||column.equals("roleTypeName") || column.equals("lastLogin")) {
				System.out.println("Not a valid option. Updating an id is not allowed. Updating accounts must be done through a seperate process.");
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
	@Override
	public void delete(User t) throws SQLException {
		Connection conn = ConnectionFactory.getConnection();
		String query = "call PR_DELETEUSER(?, ?)";
		CallableStatement caller = conn.prepareCall(query);
		caller.setInt(1, t.getId());
		caller.setInt(2, t.getLoginId());
		caller.execute();
		caller.close();
		conn.close();
		
	}

	@Override
	public boolean checkExistence(String col, String value) {
		Connection conn = ConnectionFactory.getConnection();
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
	
	public List<StringBuilder> getUserTransactions(int id){
		List<StringBuilder> tranList = new ArrayList<StringBuilder>();
		
		ResultSet rs;
		Connection conn = ConnectionFactory.getConnection();
		String query = "Select DATED,MESSAGE from TRANSACTION_LOGS WHERE USER_ID = ?";
		try (PreparedStatement ps = conn.prepareStatement(query)){
			ps.setLong(1, id);
			rs = ps.executeQuery();
			while(rs.next()) {
				StringBuilder trans = new StringBuilder();
				trans.append(rs.getDate(1));
				trans.append(" - ");
				trans.append(rs.getString(2));
				tranList.add(trans);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return tranList;
	}

}
