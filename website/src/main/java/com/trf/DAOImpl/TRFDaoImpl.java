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
		Connection conn= cf.getConnection();
		try {
			System.out.println(conn);
			PreparedStatement ps = conn.prepareStatement("INSERT INTO TUITION_REIMBURSEMENT_FORM VALUES(?,?,?,?,TO_DATE(?,'YYYY-MM-DD hh24:mi'),?,?,?,?,?,?,?,?,?,?,?,?)");
			ps.setString(1, "0");
			ps.setString(2, t.getFirst_name());
			ps.setString(3, t.getLast_name());
			ps.setString(4, t.getBasic_info_placeholder());
			ps.setString(5, t.getDatetime());
			ps.setString(6, t.getLocation());
			ps.setString(7, t.getDescription());
			ps.setString(8, t.getCost());
			ps.setString(9, t.getGrading_format());
			ps.setString(10, t.getPassing_grade());
			ps.setString(11, t.getEvent_type_id());
			ps.setString(12, t.getJustification());
			ps.setString(13, t.getOptional_attachments_exist());
			ps.setString(14, t.getSupervisor_approval_exist());
			ps.setString(15, t.getHead_approval_exist());
			ps.setString(16, t.getWork_time_missed());
			ps.setString(17, t.getProjected_reimbursement());
			return ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}
	
}
