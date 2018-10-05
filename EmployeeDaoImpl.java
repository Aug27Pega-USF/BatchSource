package com.revature.daoimpl;

import java.awt.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.revature.dao.EmployeeDao;

public class EmployeeDaoImpl implements EmployeeDao {
public static ConnFactory cf = ConnFactory.getInstance();

public void createEmployee1() throws SQLException {
	Connection conn = cf.getConnection();
	//String sql = "INSERT INTO USERS VALUES (MYSEQ.NEXTVAL,?,?)";  Fields will determine
	
	PreparedStatement ps = conn.prepareStatement(sql);
	
	//Determining type employee, supervisor etc. 
	/*ps.setString(1,x.getUSER_NAME());
	ps.setString(2, x.getUSER_PASSWORD());
	ps.execute(); */
	
}

public void getLoginList(AccountLogin y) throws SQLException {
	Connection conn = cf.getConnection();
	
	/*PreparedStatement stmt = conn.prepareStatement("SELECT COUNT(*) FROM USERS WHERE USER_NAME=? AND USER_PASSWORD=?"); 
	stmt.setString(1, y.getLoginUser());
	stmt.setString(2, y.getLoginPassword());
	ResultSet rs = stmt.executeQuery (); */

}

// Change name to whatever the name of the bean is. Might use another Dao for this method.
public List<AReimbursement> getAReimbursementList() throws SQLException{
	Connection conn = cf.getConnection();
	Statement stmt = conn.createStatement();
	
	/*ResultSet rs = stmt.executeQuery("SELECT * FROM USERS");
	USERS s = null; 
	while(rs.next()) {
		s = new USERS(rs.getString(1), rs.getString(2)); 
		USERSList.add(s);*/
	
	
	
}

public List<GradingScale> getGradingScaleList()throws SQLException{
	
	Connection conn = cf.getConnection();
	Statement stmt = conn.createStatement();
	
	//Fields in DB will determine body
	
	
	
}

public void createGrades() throws SQLException {
	Connection conn = cf.getConnection();
	//String sql = "INSERT INTO USERS VALUES (MYSEQ.NEXTVAL,?,?)"; Fields will determine
	
	PreparedStatement ps = conn.prepareStatement(sql);


	
	

	public void createEmployee() {
		// TODO Auto-generated method stub
		
	}

}
