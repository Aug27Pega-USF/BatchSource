package com.revature.daoimpl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Random;



import com.revature.dao.AccountDAO;
import com.revature.exceptions.*;
import com.revature.util.ConnFactory;

public class AccountDAOImpl implements AccountDAO{
	public static ConnFactory cf = ConnFactory.getInstance();
	@Override
	public boolean deposit(double amount, int account_id, int user_id)  throws SQLException, ImproperAmountException{
		try {
			if (checkAccount(account_id,user_id)) {
			if (amount >= 0) {
				Connection conn= cf.getConnection();
				String sql = "{ call DEPOSIT(?,?,?)";
				CallableStatement call= conn.prepareCall(sql);
				call.setDouble(1, amount);
				call.setInt(2, account_id);
				call.setInt(3, user_id);
				call.execute();
				System.out.println(("You have deposited "
						+ String.format("$%.2f to Account ",
								amount)
						+ account_id + "."));
				return true;
			}
			else {
				throw new ImproperAmountException("Amount given is negative.");
			}
			}
		} catch (Exception e) {
			System.out.println(e.getMessage()); 
			return false;
		}
		return false;
	}

	@Override
	public boolean withdraw(double amount, int account_id, int user_id)  throws SQLException, ImproperAmountException{
		try {
			if(checkAccount(account_id,user_id)) {
			if (amount >= 0) {
				Connection conn= cf.getConnection();
				String sql = "{ call Withdraw(?,?,?)";
				CallableStatement call= conn.prepareCall(sql);
				call.setDouble(1, amount);
				call.setInt(2, account_id);
				call.setInt(3, user_id);
				call.execute();
				System.out.println(("You have withdrew "
							+ String.format("$%.2f from Account ",
									amount)
							+ account_id + "."));
				return true;
			}
			else {
				throw new ImproperAmountException("Amount given is negative.");
			}
			}
		} catch(SQLException e) {
			System.out.println("You are attempting to overdraft your account.");
			return false;
		}
			catch (Exception e) {
			System.out.println(e.getMessage()); 
			return false;
		}
		return false;
		
	}

	@Override
	public void deleteAccount(int account_id, int user_id)  throws SQLException, NotEmptyException {
		try {
			if(checkAccount(account_id,user_id)) {
			Connection conn= cf.getConnection();
			String sql = "SELECT BALANCE FROM BANK_ACCOUNT WHERE BANK_ACCOUNT_ID=? AND USER_ID=?";
			PreparedStatement prest = conn.prepareStatement(sql);
			prest.setInt(1, account_id);
			prest.setInt(2, user_id);
			ResultSet rs= prest.executeQuery();
			if (rs.next() && rs.getDouble(1)==0) {
				String sql2 = "{ call DELETE_EMPTY_BANK_ACCOUNT(?,?)";
				CallableStatement call= conn.prepareCall(sql2);
				call.setInt(1, account_id);
				call.setInt(2, user_id);
				call.execute();	
				System.out.println("You have successfully deleted account " + account_id + ".");
			}else {
				throw new NotEmptyException("You cannot delete an account that still contains funds.");
			}
			}

		} catch (Exception e) {
			System.out.println(e.getMessage()); 
		}

	}

	@Override
	public void createAccount(int user_id) throws SQLException {
		Connection conn= cf.getConnection();
		Random ran = new Random();
		boolean check=false;
		int id = 0;
		do{
			try {
				check=true;
				id=100000+ran.nextInt(899999);
				String sql = "{ call INSERT_BANK_ACCOUNT(?,?)";
				CallableStatement call= conn.prepareCall(sql);
				call.setInt(1, user_id);
				call.setInt(2, id);
				call.execute();
			} catch (SQLException e) {
				check=false;
			}		
		}while(!check);
		System.out.println("Created account " + id);
	}

	public boolean checkAccount(int account_id, int user_id) throws UnassociatedException{
		try {
			Connection conn= cf.getConnection();
			String sql = "SELECT BALANCE FROM BANK_ACCOUNT WHERE BANK_ACCOUNT_ID=? AND USER_ID=?";
			PreparedStatement prest = conn.prepareStatement(sql);
			prest.setInt(1, account_id);
			prest.setInt(2, user_id);
			ResultSet rs= prest.executeQuery();
			if (rs.next()) {
				return true;
			}
			else {
				throw new UnassociatedException("You do not have an account with the given account id.");
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return false;
		}
	}
}
