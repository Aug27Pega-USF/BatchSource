package jdbc.bank.DAOIMPL;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Jbdc.dao.accountsDAO;
import jdbc.bank.App.ConnFactory;
import jdbc.bank.beans.ACCOUNT;


public class AccountsDAOimpl implements accountsDAO  {
	public static ConnFactory cf = ConnFactory.getInstance();



	public void getAccounts(String userName) throws SQLException {
		// TODO Auto-generated method stub
			Connection conn = cf.getConnection();
		String sql = "SELECT* FROM ACCOUNTS WHERE USERNAME =? ";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1,userName);
		ResultSet rs = ps.executeQuery();
		while(rs.next()) {
			System.out.println("ACCOUNT: " + rs.getInt("ACCOUNT_ID"));
			System.out.println("BALANCE: " + rs.getInt("BALANCE"));
	};
		
		
		
	}



}