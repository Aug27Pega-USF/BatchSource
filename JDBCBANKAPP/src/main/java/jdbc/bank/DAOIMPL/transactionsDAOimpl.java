package jdbc.bank.DAOIMPL;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Jbdc.dao.transactionsDAO;
import jdbc.bank.App.ConnFactory;

public class transactionsDAOimpl implements transactionsDAO {
	public static ConnFactory cf = ConnFactory.getInstance();

	public void doWithdraw(double withdraw) throws SQLException {
		Connection conn = cf.getConnection();
		String sql = "SELECT FROM ACCOUNTS WHERE USERNAME = USERNAME";
		PreparedStatement ps = conn.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		while(rs.next()) {
			System.out.println("" + rs.getInt("MEMBER_ID"));
		}
		
		
		
		
	}

	public void doDeposit(double deposit) throws SQLException {
	
		Connection conn = cf.getConnection();
	}

}
