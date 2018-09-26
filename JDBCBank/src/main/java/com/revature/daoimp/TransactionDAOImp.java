package com.revature.daoimp;

import java.io.IOException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

import com.revature.bean.Transaction;
import com.revature.dao.TransactionDAO;
import com.revature.util.ConnFactory;

public class TransactionDAOImp implements TransactionDAO{
	public static ConnFactory cf = ConnFactory.getInstance();
	
	//This method is primarily called in other methods to go off as soon as any type of money transaction is done
	public void createTransaction(int accountID, double transactionAmount,int typeID, double endingBalance)
			throws SQLException {
		Connection conn = cf.getConnection();
		String sql = "INSERT INTO TRANSACTIONS VALUES (SQ_TRANS_ID.NEXTVAL,?,?,?,?)";
		CallableStatement call = conn.prepareCall(sql);
		//call.setInt(1,+"Sq");
		call.setInt (1,accountID);
		call.setInt(2, typeID);
		call.setDouble (3,transactionAmount);		
		call.setDouble(4, endingBalance);
		call.executeUpdate();
		
	}

	//Used to get transaction list of a certain account number
	public void getTransactionList(int accountID) throws SQLException {
		Connection conn = cf.getConnection();
		PreparedStatement stmt = conn.prepareStatement("SELECT TRANSACTIONS.TRANSACTIONID, TRANSACTIONS.ACCOUNTID AS ACCOUNT_NUM,"
													+"TRANS_TYPE.TYPEDESC AS DEPOSIT_WITHDRAWL,TRANSACTIONS.TRANSACTIONVALUE,"
													+"TRANSACTIONS.ENDINGBALANCE FROM TRANSACTIONS INNER JOIN TRANS_TYPE ON "
													+ "TRANSACTIONS.TYPEID= TRANS_TYPE.TYPEID WHERE TRANSACTIONS.ACCOUNTID=? ORDER BY TRANSACTIONS.TRANSACTIONID ASC");
		stmt.setInt(1,accountID);
		ResultSet rs = stmt.executeQuery();	
		   ResultSetMetaData rsmd = rs.getMetaData();
		   System.out.println("The Transaction information you requested is:");
		   int columnsNumber = rsmd.getColumnCount();
		while (rs.next()){
			for (int i = 1; i <= columnsNumber; i++)
			{
		        if (i > 1) System.out.print(",  ");
		        String columnValue = rs.getString(i);
		        System.out.print( rsmd.getColumnName(i)+ " " + columnValue);
		    }
			System.out.println();		
		}
		System.out.println("Hit any key to continue");
		try {
			System.in.read();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		System.out.println();

		
	}

}
