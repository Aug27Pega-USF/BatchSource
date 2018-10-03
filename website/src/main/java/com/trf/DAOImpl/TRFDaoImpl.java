package com.trf.DAOImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.trf.DAO.TRFDao;
import com.trf.beans.TRF;
import com.trf.util.ConnFactory;

public class TRFDaoImpl implements TRFDao{
	public static ConnFactory cf = ConnFactory.getInstance();
	@Override
	public int insertTRF(TRF t) {
		
		try (Connection conn= cf.getConnection();) {

			PreparedStatement ps = conn.prepareStatement("INSERT INTO TUITION_REIMBURSEMENT_FORM VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
			ps.setString(1, "0");
			ps.setString(2, t.getFirst_name());
			ps.setString(3, t.getLast_name());
			ps.setString(4, t.get);
			return ps.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}
	
}
