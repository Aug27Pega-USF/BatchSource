package com.trf.DAOImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.trf.DAO.TRFPacketDao;
import com.trf.beans.TRFPacket;
import com.trf.util.ConnFactory;

public class TRFPacketDaoImpl implements TRFPacketDao{
	public static ConnFactory cf = ConnFactory.getInstance();
	public ArrayList<TRFPacket> getTRFPacketsbyID(int employeeID){
		ArrayList<TRFPacket> trf_list = new ArrayList<TRFPacket>();
		Connection conn = cf.getConnection();
		try {
			PreparedStatement prest = conn.prepareStatement("SELECT TRF_ID, EVENT_DATETIME, EVENT_LOCATION, EVENT_DESCRIPTION, GRADING_FORMAT, PASSING_GRADE, EVENT_TYPE_ID, WORK_RELATED_JUSTIFICATION, SUPERVISOR_APPROVAL_EXIST, HEAD_APPROVAL_EXIST, BC_APPROVAL, WORK_TIME_MISSED, PROJECTED_REIMBURSEMENT FROM TUITION_REIMBURSEMENT_FORM WHERE USER_ID=? AND DENIED='N'");
			prest.setString(1, String.valueOf(employeeID));
			ResultSet rs = prest.executeQuery();
			while(rs.next()) {
				trf_list.add(new TRFPacket(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9), rs.getString(10), rs.getString(11), rs.getString(12), rs.getString(13)));
			}
		} catch (Exception e){
			e.printStackTrace();
		}
		return trf_list;
		
	}
}
