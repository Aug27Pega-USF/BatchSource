package jdbc.bank.DAOIMPL;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import Jbdc.dao.UsersDAO;
import jdbc.bank.App.ConnFactory;

public class UsersDAOimpl implements UsersDAO{
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
		String sql = "SELECT USERNAME,PSSWORD FROM JDBC_BANK WHERE USERNAME=? AND PSSWORD=?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, userName);
		ps.setString(2, password);
		ps.executeQuery();
		
	}






	
	
		


}




