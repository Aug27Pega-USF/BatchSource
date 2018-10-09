package com.runtime.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.runtime.bean.Reimbursement;

public class ReimbursementDaoImpl implements ReimbursementDao {

	static {

		try {

			Class.forName("oracle.jdbc.driver.OracleDriver");

		} catch (ClassNotFoundException e) {

			e.printStackTrace();

		}

	}
	private static String url = "jdbc:oracle:thin:@aug27pega.c6dt4deskvoq.us-east-2.rds.amazonaws.com:1521:ORCL";
	private static String usr = "BenCoAdmin";
	private static String pss = "IaminTheMoney";

	@Override
	public int insertReimbursement(Reimbursement reimbursement) {
		// TODO Auto-generated method stub
		return 0;
	}

	@SuppressWarnings({ "unchecked", "null" })
	@Override
	public List<Reimbursement> getReimbursementList(int userId) {
		List<Reimbursement> reimbursement = new ArrayList<Reimbursement>();
		try (Connection conn = DriverManager.getConnection(url, usr, pss)) {
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM REIMBURSEMENTS WHERE EMPLOYEE_ID=?");
			ps.setInt(1, userId);
			Reimbursement s = null;
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				s = new Reimbursement(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getString(4), rs.getString(5),
						rs.getString(6), rs.getString(7), rs.getInt(8), rs.getString(9), rs.getDouble(10),
						rs.getDouble(11), rs.getDouble(12), rs.getString(13));
				reimbursement.add(s);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return reimbursement;
	}

	@SuppressWarnings({ "unchecked", "null" })
	@Override
	public List<Reimbursement> getReimbursementListByJobType(int jobType) {
		List<Reimbursement> reimbursement = new ArrayList<Reimbursement>();
		try (Connection conn = DriverManager.getConnection(url, usr, pss)) {
			System.out.println("Before checking");
			if (jobType == 4) {
				System.out.println("checking 4");
				PreparedStatement ps = conn.prepareStatement("SELECT * FROM REIMBURSEMENTS");
				//ps.setInt(1, JobType);
				Reimbursement s = null;
				ResultSet rs = ps.executeQuery();
				while (rs.next()) {
					s = new Reimbursement(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getString(4), rs.getString(5),
							rs.getString(6), rs.getString(7), rs.getInt(8), rs.getString(9), rs.getDouble(10),
							rs.getDouble(11), rs.getDouble(12), rs.getString(13));
					reimbursement.add(s);
				}
				return reimbursement;
			}
			else if (jobType == 3) {
				System.out.println("checking 3");
				PreparedStatement ps = conn.prepareStatement("SELECT * FROM REIMBURSEMENTS WHERE STATUS < ? ");
				ps.setInt(1, jobType);
				Reimbursement s = null;
				ResultSet rs = ps.executeQuery();
				while (rs.next()) {
					s = new Reimbursement(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getString(4), rs.getString(5),
							rs.getString(6), rs.getString(7), rs.getInt(8), rs.getString(9), rs.getDouble(10),
							rs.getDouble(11), rs.getDouble(12), rs.getString(13));
					reimbursement.add(s);
				}
				return reimbursement;
			}
			else if (jobType == 2) {
				System.out.println("checking 2");
				PreparedStatement ps = conn.prepareStatement("SELECT * FROM REIMBURSEMENTS WHERE STATUS < ?");
				ps.setInt(1, jobType);
				Reimbursement s = null;
				ResultSet rs = ps.executeQuery();
				while (rs.next()) {
					s = new Reimbursement(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getString(4), rs.getString(5),
							rs.getString(6), rs.getString(7), rs.getInt(8), rs.getString(9), rs.getDouble(10),
							rs.getDouble(11), rs.getDouble(12), rs.getString(13));
					reimbursement.add(s);
				}
				return reimbursement;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return reimbursement;
	}

	@Override
	public Reimbursement getReimbursementById(int userId) {
		Reimbursement reimbursement = null;
		try (Connection conn = DriverManager.getConnection(url, usr, pss)) {
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM REIMBURSEMENTS WHERE EMPLOYEE_ID=?");
			ps.setInt(1, userId);

			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				reimbursement = new Reimbursement(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getString(4),
						rs.getString(5), rs.getString(6), rs.getString(7), rs.getInt(8), rs.getString(9),
						rs.getDouble(10), rs.getDouble(11), rs.getDouble(12), rs.getString(13));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return reimbursement;
	}

	@Override
	public int updateReimbursementById(int reimbursementId) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteReimbursementById(int reimbursementId) {
		// TODO Auto-generated method stub
		return 0;
	}

}
