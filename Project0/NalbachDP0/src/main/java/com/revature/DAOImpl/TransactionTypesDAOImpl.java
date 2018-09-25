package com.revature.DAOImpl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.revature.Connection.ConnFactory;
import com.revature.dao.TransactionTypesDAO;
import com.revature.tables.TransactionTypes;

public class TransactionTypesDAOImpl implements TransactionTypesDAO{
	public static ConnFactory cf = ConnFactory.getInstance();
	public void createTransactionTypes(String transactionName) throws SQLException {
		Connection conn = cf.getConnection();
		String sql= "{call INSERTTRANSACTIONTYPES(?)";
		CallableStatement call= conn.prepareCall(sql);
		call.setString(1,transactionName);
		call.execute();
	}

	public List<TransactionTypes> getTransactionTypesList() throws SQLException {
		List<TransactionTypes> TransactionTypesList = 
				new ArrayList<TransactionTypes>();
		Connection conn = cf.getConnection();
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery("SELECT * FROM TRANSACTIONTYPES");
		TransactionTypes s = null;
		while(rs.next()) {
			s=new TransactionTypes(rs.getInt(1),rs.getString(2));
			TransactionTypesList.add(s);
		}
		return TransactionTypesList;
	}
}
