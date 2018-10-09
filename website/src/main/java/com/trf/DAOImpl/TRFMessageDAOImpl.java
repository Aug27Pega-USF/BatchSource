package com.trf.DAOImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.trf.DAO.TRFMessageDAO;
import com.trf.beans.TRFMessage;
import com.trf.util.ConnFactory;

public class TRFMessageDAOImpl implements TRFMessageDAO {
	public static ConnFactory cf = ConnFactory.getInstance();

	@Override
	public ArrayList<TRFMessage> getMessageById(int id) {
		ArrayList<TRFMessage> msg_list = new ArrayList<TRFMessage>();
		String sql = "SELECT * FROM MESSAGES WHERE USER_ID = ? ORDER BY MESSAGE_DATE DESC";
		Connection conn = cf.getConnection();
		try {
			PreparedStatement prest = conn.prepareStatement(sql);
			prest.setString(1, Integer.toString(id));
			ResultSet rs = prest.executeQuery();
			while (rs.next()) {
				msg_list.add(
						new TRFMessage(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getString(4), rs.getString(5)));
			}
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return msg_list;
	}

	
	public String getpassinggrade(int trf_id) {
		String sql = "SELECT PASSING_GRADE FROM TUITION_REIMBURSEMENT_FORM WHERE TRF_ID=?";
		Connection conn = cf.getConnection();
		String r="";
		try {
			PreparedStatement prest = conn.prepareStatement(sql);
			prest.setString(1, Integer.toString(trf_id));
			ResultSet rs = prest.executeQuery();
			while (rs.next()) {
				 r=rs.getString(1);
			}
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if (r.equals("")) {
			return r;
		}else {
			r=" Passing Grade was " + r + ".";
		}
		return r;
	}
	
	public void denyGrade(int trf_id) {
		Connection conn= cf.getConnection();
		try {
			PreparedStatement ps = conn.prepareStatement("UPDATE MESSAGES SET FLAG='GD' WHERE TRF_ID=? AND FLAG='GC'");
			ps.setInt(1, trf_id);
			ps.executeUpdate();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	public void approveGrade(int trf_id) {
		Connection conn= cf.getConnection();
		try {
			PreparedStatement ps = conn.prepareStatement("UPDATE MESSAGES SET FLAG='GA' WHERE TRF_ID=? AND FLAG='GC'");
			ps.setInt(1, trf_id);
			ps.executeUpdate();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	public void denyPresentation(int trf_id) {
		Connection conn= cf.getConnection();
		try {
			PreparedStatement ps = conn.prepareStatement("UPDATE MESSAGES SET FLAG='PD' WHERE TRF_ID=? AND FLAG='PR'");
			ps.setInt(1, trf_id);
			ps.executeUpdate();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	public void approvePresentation(int trf_id) {
		Connection conn= cf.getConnection();
		try {
			PreparedStatement ps = conn.prepareStatement("UPDATE MESSAGES SET FLAG='PA' WHERE TRF_ID=? AND FLAG='PR'");
			ps.setInt(1, trf_id);
			ps.executeUpdate();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	public void addMessage(int uid, int tid, String flag) {
		Connection conn = cf.getConnection();
		if (uid == 0) {
			String sql = "SELECT USER_ID FROM TUITION_REIMBURSEMENT_FORM WHERE TRF_ID=?";
			try {
				PreparedStatement ps1 = conn.prepareStatement(sql);
				ps1.setInt(1, tid);
				ResultSet rs = ps1.executeQuery();
				rs.next();
				uid = rs.getInt(1);
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		String msg = "";
		String sql = "INSERT INTO MESSAGES(USER_ID,MESSAGE,TRF_ID,FLAG) VALUES(?,?,?,?)";
		try {
			System.out.println("Flag Check:" + flag);
			switch (flag) {
			case "SA":
				msg = "TRF Approved by Supervisor.";
				break;
			case "DA":
				msg = "TRF Approved by Department Head.";
				break;
			case "BA":
				msg = "TRF Approved by Benefits Coordinator.";
				break;
			case "SD":
				msg = "TRF Denied by Supervisor.";
				break;
			case "DD":
				msg = "TRF Denied by Department Head.";
				break;
			case "BD":
				msg = "TRF Denied by Benefits Coordinator.";
				break;
			case "RI":
				msg = "Requesting More Information.";
				break;
			case "AA":
				msg = "BenCo has adjusted amount down.";
				break;
			case "UP":
				msg = "TRF has been provided additional information.";
				break;
			case "PR":
				msg = "Employee has provided proof of presentation.";
				break;
			case "GC":
				msg = "Employee has provided proof of grade." + getpassinggrade(tid);
				break;
			case "BG":
				msg = "BenCo has denied your TRF on basis of Grade.";
				break;
			case "MA":
				msg = "Your TRF has been accepted. Reimbursement has been awarded.";
				break;
			case "PY":
				msg = "Supervisor has denied your TRF on basis of Presentation.";
				break;
			}
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, uid);
			ps.setString(2, msg);
			ps.setInt(3, tid);
			ps.setString(4, flag);
			ps.executeUpdate();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void addMessage(int uid, int tid, String flag, String add_message) {
		Connection conn = cf.getConnection();
		if (uid == 0) {
			String sql = "SELECT USER_ID FROM TUITION_REIMBURSEMENT_FORM WHERE TRF_ID=?";
			try {
				PreparedStatement ps1 = conn.prepareStatement(sql);
				ps1.setInt(1, tid);
				ResultSet rs = ps1.executeQuery();
				rs.next();
				uid = rs.getInt(1);
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		String msg = "";
		String sql = "INSERT INTO MESSAGES(USER_ID,MESSAGE,TRF_ID,FLAG) VALUES(?,?,?,?)";
		try {
			System.out.println("Flag Check:" + flag);
			switch (flag) {
			case "SA":
				msg = "TRF Approved by Supervisor.";
				break;
			case "DA":
				msg = "TRF Approved by Department Head.";
				break;
			case "BA":
				msg = "TRF Approved by Benefits Coordinator.";
				break;
			case "SD":
				msg = "TRF Denied by Supervisor.";
				break;
			case "DD":
				msg = "TRF Denied by Department Head.";
				break;
			case "BD":
				msg = "TRF Denied by Benefits Coordinator.";
				break;
			case "RI":
				msg = "Requesting More Information.";
				break;
			case "AA":
				msg = "BenCo has adjusted amount down.";
				break;
			case "UP":
				msg = "TRF has been provided additional information.";
				break;
			case "PR":
				msg = "Employee has provided proof of presentation.";
				break;
			case "GC":
				msg = "Employee has provided proof of grade." + getpassinggrade(tid);
				break;
			case "BG":
				msg = "BenCo has denied your TRF on basis of Grade.";
				break;
			case "MA":
				msg = "Your TRF has been accepted. Reimbursement has been awarded.";
				break;
			case "PY":
				msg = "Supervisor has denied your TRF on basis of Presentation.";
				break;
			}
			msg+= " Deny Reason: "+ add_message;
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, uid);
			ps.setString(2, msg);
			ps.setInt(3, tid);
			ps.setString(4, flag);
			ps.executeUpdate();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}






}