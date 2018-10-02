package jdbc.bank.DAOIMPL;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Jbdc.dao.transactionsDAO;
import jdbc.bank.App.ConnFactory;

public class transactionsDAOimpl implements transactionsDAO {
	public static ConnFactory cf = ConnFactory.getInstance();
	
	public void doWithdraw(int account_id, double amount, String userName) throws SQLException {
		Connection conn = cf.getConnection();
		String sql = "SELECT BALANCE FROM ACCOUNTS where ACCOUNT_ID = ? and USERNAME = ?";
		PreparedStatement stmt = conn.prepareStatement(sql);
		stmt.setInt(1,account_id);
		stmt.setString(2, userName);
		ResultSet rs = stmt.executeQuery();	
		if(rs.next()==false){ 
			System.out.println("YOUR ACCOUNT TRY AGAIN IS INVALID");
			
		}else {
			double balance = rs.getDouble(1);
			double newbal = balance - amount;
			String wsl = "UPDATE ACCOUNTS SET BALANCE= ? WHERE ACCOUNT_ID =? AND USERNAME=?";
			CallableStatement call = conn.prepareCall(wsl);
			call.setDouble(1, newbal);
			call.setInt(2, account_id);
			call.setString(3, userName);
			call.executeUpdate();
		}
	}
	public void doDeposit(int account_id, double amount, String userName) throws SQLException {
		Connection conn = cf.getConnection();
		String sql = "SELECT BALANCE FROM ACCOUNTS where ACCOUNT_ID = ? and USERNAME = ?";
		PreparedStatement stmt = conn.prepareStatement(sql);
		stmt.setInt(1,account_id);
		stmt.setString(2, userName);
		ResultSet rs = stmt.executeQuery();	
		if(rs.next()==false){ 
			System.out.println("YOU HAVE NO ACCOUNT TRY AGAIN");
			
		}else {
			double balance = rs.getDouble(1);
			double newbal = balance + amount;
			String wsl = "UPDATE ACCOUNTS SET BALANCE= ? WHERE ACCOUNT_ID =? AND USERNAME=?";
			CallableStatement call = conn.prepareCall(wsl);
			call.setDouble(1, newbal);
			call.setInt(2, account_id);
			call.setString(3, userName);
			call.executeUpdate();
	}


		
		
		
		
	}
}


