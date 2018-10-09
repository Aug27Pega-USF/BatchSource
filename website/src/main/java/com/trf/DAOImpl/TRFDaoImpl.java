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
			PreparedStatement ps = conn.prepareStatement("INSERT INTO TUITION_REIMBURSEMENT_FORM (TRF_ID, FIRST_NAME, LAST_NAME, BASIC_INFO_PLACEHOLDER, EVENT_DATETIME, EVENT_LOCATION, EVENT_DESCRIPTION, EVENT_COST, GRADING_FORMAT, PASSING_GRADE, EVENT_TYPE_ID, WORK_RELATED_JUSTIFICATION, OPTIONAL_ATTACHMENTS_EXIST, SUPERVISOR_APPROVAL_EXIST, HEAD_APPROVAL_EXIST, WORK_TIME_MISSED, PROJECTED_REIMBURSEMENT, USER_ID)VALUES(?,?,?,?,TO_DATE(?,'YYYY-MM-DD hh24:mi'),?,?,?,?,?,?,?,?,?,?,?,?,?)");
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
			ps.setString(18, t.getEmployee_id());
			ps.executeUpdate();
			conn.close();
			return 1;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}
	
	public void updateTRFExceed(String exceedreason, int trf_id) {
		Connection conn= cf.getConnection();
		try {
			PreparedStatement ps = conn.prepareStatement("UPDATE TUITION_REIMBURSEMENT_FORM SET EXCEEDREASON=? WHERE TRF_ID=?");
			ps.setString(1, exceedreason);
			ps.setInt(2, trf_id);
			ps.executeUpdate();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	public void updateTRFRei(float projected_rei, int trf_id) {
		Connection conn= cf.getConnection();
		try {
			PreparedStatement ps = conn.prepareStatement("UPDATE TUITION_REIMBURSEMENT_FORM SET PROJECTED_REIMBURSEMENT=? WHERE TRF_ID=?");
			ps.setFloat(1, projected_rei);
			ps.setInt(2, trf_id);
			ps.executeUpdate();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void submitPresentation(int trf_id) {
		Connection conn= cf.getConnection();
		try {
			PreparedStatement ps = conn.prepareStatement("UPDATE TUITION_REIMBURSEMENT_FORM SET SUPERVISOR_APPROVAL_EXIST='A' WHERE TRF_ID=?");
			ps.setInt(1, trf_id);
			ps.executeUpdate();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void submitGrade(int trf_id) {
		Connection conn= cf.getConnection();
		try {
			PreparedStatement ps = conn.prepareStatement("UPDATE TUITION_REIMBURSEMENT_FORM SET BC_APPROVAL='A' WHERE TRF_ID=?");
			ps.setInt(1, trf_id);
			ps.executeUpdate();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
}
