package com.revature.DAOImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.revature.DAO.PowersDAO;
import com.revature.util.ConnFactory;

public class PowersDAOImpl implements PowersDAO{
	public static ConnFactory cf = ConnFactory.getInstance();
	
	public void createPower(String powerName) throws SQLException {
		Connection conn= cf.getConnection();
		String [] primaryKeys =new String[1];
		primaryKeys[0]= "PowersId";
		String sql = "INSERT INTO POWERS VALUES (POWSEQ.NEXTVAL, ?)";
		
		PreparedStatement ps = 
				conn.prepareStatement(sql,primaryKeys);
		ps.setString(1, powerName);
		ps.executeUpdate();
		
	}

}