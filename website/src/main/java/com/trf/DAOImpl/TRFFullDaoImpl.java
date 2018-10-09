package com.trf.DAOImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.trf.DAO.TRFFullDAO;
import com.trf.beans.TRFFull;
import com.trf.util.ConnFactory;

public class TRFFullDaoImpl implements TRFFullDAO{
	public static ConnFactory cf = ConnFactory.getInstance();

	public ArrayList<TRFFull> getTRFFullbyID_BC(String Level) {
		ArrayList<TRFFull> trf_list = new ArrayList<TRFFull>();
		if (Level.equals("B")) { // check benco, this is honestly redundant
			Connection conn = cf.getConnection();
			try {
				PreparedStatement prest = conn.prepareStatement(
						"SELECT * FROM TUITION_REIMBURSEMENT_FORM WHERE SUPERVISOR_APPROVAL_EXIST = 'Y' AND HEAD_APPROVAL_EXIST = 'Y' AND BC_APPROVAL = 'N' AND DENIED='N' ORDER BY TRF_ID");
				ResultSet rs = prest.executeQuery();
				while (rs.next()) {
					String event_type = "";
					switch (rs.getString(11)) {
					case "1":
						event_type = "University Courses";
						break;
					case "2":
						event_type = "Seminars";
						break;
					case "3":
						event_type = "Certification Preparation Classes";
						break;
					case "4":
						event_type = "Certification";
						break;
					case "5":
						event_type = "Technical Training";
						break;
					case "6":
						event_type = "Other";
						break;
					}
					String percentage = rs.getString(10);
					if (rs.getString(9).equals("Percentage")) {
						percentage = rs.getString(10) + "%";
					}
					String yesno="";
					if (rs.getString(13).equals("Y")) {
						yesno="Yes";
					}else {
						yesno="No";
					}
					
					trf_list.add(new TRFFull(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4),
							rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9),
							percentage, event_type, rs.getString(12), yesno, rs.getString(14),
							rs.getString(15), rs.getString(16), rs.getString(17), rs.getString(18), rs.getString(19),
							rs.getString(20), rs.getString(21)));
					
				}
				conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return trf_list;
	}

	public ArrayList<TRFFull> getTRFFullbyID_DS(int employeeid) {
		ArrayList<TRFFull> trf_list = new ArrayList<TRFFull>();
		Connection conn = cf.getConnection();
		try {
			PreparedStatement prest = conn.prepareStatement(
					"SELECT t.* FROM TUITION_REIMBURSEMENT_FORM t INNER JOIN EMPLOYEE ON (t.USER_ID=EMPLOYEE.USER_ID) WHERE REFERSTO=? AND SUPERVISOR_APPROVAL_EXIST = 'N' AND DENIED='N' ORDER BY TRF_ID");
			prest.setString(1, String.valueOf(employeeid));
			ResultSet rs = prest.executeQuery();
			while (rs.next()) {
				String event_type = "";
				switch (rs.getString(11)) {
				case "1":
					event_type = "University Courses";
					break;
				case "2":
					event_type = "Seminars";
					break;
				case "3":
					event_type = "Certification Preparation Classes";
					break;
				case "4":
					event_type = "Certification";
					break;
				case "5":
					event_type = "Technical Training";
					break;
				case "6":
					event_type = "Other";
					break;
				}
				String percentage = rs.getString(10);
				if (rs.getString(9).equals("Percentage")) {
					percentage = rs.getString(10) + "%";
				}
				String yesno="";
				if (rs.getString(13).equals("Y")) {
					yesno="Yes";
				}else {
					yesno="No";
				}
				trf_list.add(new TRFFull(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4),
						rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9), percentage,
						event_type, rs.getString(12), yesno, rs.getString(14), rs.getString(15),
						rs.getString(16), rs.getString(17), rs.getString(18), rs.getString(19), rs.getString(20),
						rs.getString(21)));
			}
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return trf_list;
	}

	public ArrayList<TRFFull> getTRFFullbyID_DH(int employeeid) {
		ArrayList<TRFFull> trf_list = new ArrayList<TRFFull>();
		Connection conn = cf.getConnection();
		try {
			PreparedStatement prest = conn.prepareStatement(
					"SELECT t.* FROM TUITION_REIMBURSEMENT_FORM t INNER JOIN EMPLOYEE ON (t.USER_ID=EMPLOYEE.USER_ID) WHERE REFERSTO=? AND HEAD_APPROVAL_EXIST='N' AND DENIED='N' ORDER BY TRF_ID");
			prest.setString(1, String.valueOf(employeeid));
			ResultSet rs = prest.executeQuery();
			while (rs.next()) {
				String event_type = "";
				switch (rs.getString(11)) {
				case "1":
					event_type = "University Courses";
					break;
				case "2":
					event_type = "Seminars";
					break;
				case "3":
					event_type = "Certification Preparation Classes";
					break;
				case "4":
					event_type = "Certification";
					break;
				case "5":
					event_type = "Technical Training";
					break;
				case "6":
					event_type = "Other";
					break;
				}
				String percentage = rs.getString(10);
				if (rs.getString(9).equals("Percentage")) {
					percentage = rs.getString(10) + "%";
				}
				String yesno="";
				if (rs.getString(13).equals("Y")) {
					yesno="Yes";
				}else {
					yesno="No";
				}
				trf_list.add(new TRFFull(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4),
						rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9), percentage,
						event_type, rs.getString(12), yesno, rs.getString(14), rs.getString(15),
						rs.getString(16), rs.getString(17), rs.getString(18), rs.getString(19), rs.getString(20),
						rs.getString(21)));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			PreparedStatement prest = conn.prepareStatement(
					"SELECT t.* FROM TUITION_REIMBURSEMENT_FORM t JOIN (SELECT c.user_id FROM EMPLOYEE a JOIN EMPLOYEE b ON (b.refersto = a.user_id) JOIN EMPLOYEE c ON (c.refersto = b.user_id) where a.user_id=?) emp ON t.user_id=emp.user_id where HEAD_APPROVAL_EXIST='N' AND SUPERVISOR_APPROVAL_EXIST='Y' AND DENIED='N' order by trf_id");
			prest.setString(1, String.valueOf(employeeid));
			ResultSet rs = prest.executeQuery();
			while (rs.next()) {
				String event_type = "";
				switch (rs.getString(11)) {
				case "1":
					event_type = "University Courses";
					break;
				case "2":
					event_type = "Seminars";
					break;
				case "3":
					event_type = "Certification Preparation Classes";
					break;
				case "4":
					event_type = "Certification";
					break;
				case "5":
					event_type = "Technical Training";
					break;
				case "6":
					event_type = "Other";
					break;
				}
				String percentage = rs.getString(10);
				if (rs.getString(9).equals("Percentage")) {
					percentage = rs.getString(10) + "%";
				}
				String yesno="";
				if (rs.getString(13).equals("Y")) {
					yesno="Yes";
				}else {
					yesno="No";
				}
				trf_list.add(new TRFFull(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4),
						rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9), percentage,
						event_type, rs.getString(12), yesno, rs.getString(14), rs.getString(15),
						rs.getString(16), rs.getString(17), rs.getString(18), rs.getString(19), rs.getString(20),
						rs.getString(21)));
			}
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return trf_list;
	}

}
