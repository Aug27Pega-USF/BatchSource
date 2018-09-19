package com.revature.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.revature.beans.Powers;
import com.revature.dao.PowersDAO;
import com.revature.util.ConnFactory;

public class PowersDAOImpl implements PowersDAO {
	
	public static ConnFactory cf=  ConnFactory.getInstance();

	public void createPower(String powerName) throws SQLException {
		Connection conn= cf.getConnection();
		String[] primaryKeys= new String[1];
		primaryKeys[0]= "PowerId";
		String sql= "INSERT INTO POWERS VALUES (POWSEQ.NEXTVAL, ?)";
		
		try {
		PreparedStatement ps = conn.prepareStatement(sql, primaryKeys);
		ps.setString(1, powerName);
		ps.executeUpdate();
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		
	}
	
	public List<Powers> getPowersList() throws SQLException {
		List<Powers> powersList= new ArrayList<Powers>();
		Connection conn= cf.getConnection();
		Statement stmt= conn.createStatement();
		ResultSet rs= stmt.executeQuery("SELECT * FROM POWERS");
		Powers s =null;
		while(rs.next())
		{
			s = new Powers(rs.getInt(1), rs.getString(2));
			powersList.add(s);
		}
		return powersList;
	}

}
