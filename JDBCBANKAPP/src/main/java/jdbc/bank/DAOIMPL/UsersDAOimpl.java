package jdbc.bank.DAOIMPL;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import Jbdc.dao.UsersDAO;
import jdbc.bank.App.ConnFactory;

public class UsersDAOimpl implements UsersDAO{
	static int selector;
	public static ConnFactory cf = ConnFactory.getInstance();
	


	public void createNewUser( String newUser, String newPwd) throws SQLException {

		Connection conn = cf.getConnection();
		String sql = "INSERT INTO JDBC_BANK(username,pssword) VALUES (?,?)";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, newUser);
		ps.setString(2, newPwd);
		ps.executeQuery();
		
		
		
	}


	public void userLogin( String userName, String password) throws SQLException {
		Connection conn =cf.getConnection();
		String sql = "SELECT MEMBER_ID,USERNAME,PSSWORD FROM JDBC_BANK WHERE USERNAME=? AND PSSWORD=?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, userName);
		ps.setString(2, password);
		ps.executeQuery();
		ResultSet rs = ps.executeQuery();
		while(rs.next()) {
			if(rs.getInt("MEMBER_ID")==81) {
				System.out.println("ADMIN USER");
				adminMenu(selector);
			}else {System.out.println("CUSTOMER");
		}
			
		}
	}


	public void adminMenu(Integer selector) {
		
		switch (selector) {
		case 1:
			System.out.println("EDIT ACCOUNT");
			break;
		case 2:
			System.out.println("DELETE ACCOUNT");
			break;
		case 3:
			System.out.println("ADD/REMOVE FUNDS");
			break;
		case 4:
			System.out.println("SIGN OUT");
			break;
		}
		// TODO Auto-generated method stub
		
	}
}
		
		
	






	
	
		







