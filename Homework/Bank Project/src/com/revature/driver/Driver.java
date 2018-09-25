package com.revature.driver;

import java.sql.SQLException;

import com.revature.daoimpl.UserDAOImpl;
/* Add to the end of each try/catch group a finally of (to close connections safely):
 * } finally {
 * 	DbUtils.closeQuietly(rs);
 * 	DbUtils.closeQuietly(ps);
 * 	DbUtils.closeQuietly(conn);
 * }
 */


public class Driver {

	public static void main(String[] args) {
		UserDAOImpl udi = new UserDAOImpl();
		
//		try {
//			udi.deleteUser(7);
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
//		try {
//			udi.createUser("LoginName","PASSWORD","Tom","Smith");
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		try {
//			udi.promoteToAdmin(8);
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		try {
//			udi.deleteUser(7);
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		try {
			udi.viewUser(6);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}