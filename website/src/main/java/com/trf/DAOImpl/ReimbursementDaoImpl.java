package com.trf.DAOImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.trf.DAO.ReimbursementDao;
import com.trf.util.ConnFactory;

public class ReimbursementDaoImpl implements ReimbursementDao{
	public static ConnFactory cf = ConnFactory.getInstance();
	public String getTRFReimbursementbyID(int trf_id) {
		Connection conn = cf.getConnection();
		try {
			PreparedStatement prest = conn.prepareStatement("SELECT PROJECTED_REIMBURSEMENT FROM TUITION_REIMBURSEMENT_FORM WHERE TRF_ID=?");
			prest.setString(1, Integer.toString(trf_id));
			ResultSet rs = prest.executeQuery();
			rs.next();
			String id= rs.getString(1);
			conn.close();
			return id;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return "";
	}
	public String getAvailableReimbursement(int trf_id) {
		Connection conn = cf.getConnection();
		try {
			PreparedStatement prest = conn.prepareStatement("SELECT AVAILABLE_REIMBURSEMENT FROM EMPLOYEE E JOIN TUITION_REIMBURSEMENT_FORM t ON (E.USER_ID=T.USER_ID) WHERE TRF_ID=?");
			prest.setString(1, Integer.toString(trf_id));
			ResultSet rs = prest.executeQuery();
			rs.next();
			String id= rs.getString(1);
			conn.close();
			return id;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return "";
	}
}
