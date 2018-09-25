package com.revature.daoimpl;

	import java.sql.CallableStatement;
	import java.sql.Connection;
	import java.sql.PreparedStatement;
	import java.sql.ResultSet;
	import java.sql.SQLException;
	import java.sql.Statement;
	import java.util.ArrayList;
	import java.util.List;
	
	import com.revature.beans.UserAccount;
	import com.revature.dao.UserAccountDAO;
	import com.revature.util.ConnFactory;

	public class UserAccountDAOImpl implements UserAccountDAO{
		
		public static ConnFactory cf = ConnFactory.getInstance();
		
		public void createUserAccount( String uName, String upasw, int Adminf) throws SQLException {
			Connection conn =cf.getConnection();
			String [] primaryKeys = new String[1];
			String sql = "EXECUTE CREATECUSTOMER (?,?,?)";
			PreparedStatement ps = conn.prepareStatement(sql );
			//ps.setInt(1, usID);
			ps.setString(1, uName);
			ps.setString(2, upasw);
			ps.setInt(3, Adminf);
			ps.executeUpdate();
		}
		public void getPassword(String uName, String upasw) throws SQLException {
			Connection conn = cf.getConnection();
			String result = "SELECT * FROM USERACCOUNT WHERE UPASW = ? AND UNAME = ?";
			CallableStatement call= conn.prepareCall(result);
			call.setString(1, uName);
			call.setString(2, upasw);
			call.executeUpdate();
		}
		public void getID(String uName, String upasw) throws SQLException {
			Connection conn = cf.getConnection();
			String result = "SELECT USID FROM USERACCOUNT WHERE UPASW = ? AND UNAME = ?";
			CallableStatement call= conn.prepareCall(result);
			call.setString(1, uName);
			call.setString(2, upasw);
			call.executeUpdate();
		}
		public List<UserAccount> getUserIDList() throws SQLException {
			List<UserAccount> userIDList = 
					new ArrayList<UserAccount>();
			Connection conn = cf.getConnection();
			PreparedStatement stmt = conn.prepareStatement("SELECT USID FROM USERACCOUNT WHERE UPASW = ? AND UNAME = ?");//conn.createStatement();
			ResultSet rs = stmt.executeQuery();
			UserAccount u = null;
			
			while(rs.next()) {
				u = new UserAccount(rs.getInt(1), rs.getString(2), rs.getString(3));
				userIDList.add(u);
			}
			return userIDList;
		}
		public List<UserAccount> getUserAccountList() throws SQLException {
			List<UserAccount> userAccountList = 
					new ArrayList<UserAccount>();
			Connection conn = cf.getConnection();
			PreparedStatement stmt = conn.prepareStatement("SELECT * FROM USERACCOUNT");//conn.createStatement();
			ResultSet rs = stmt.executeQuery();
			UserAccount u = null;
			
			while(rs.next()) {
				u = new UserAccount(rs.getInt(1), rs.getString(2), rs.getString(3));
				userAccountList.add(u);
			}
			return userAccountList;
		}
}
