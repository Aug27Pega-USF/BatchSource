package com.greenbull.dao;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


import javax.servlet.http.HttpServletRequest;


import com.greenbull.users.Reimbursements;


public class ReimbDAOImpl implements ReimbDAO {

	static {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	//set up connection to the database
	private static String url = "jdbc:oracle:thin:@reimbursemant-database.c79flqc2drgd.us-east-2.rds.amazonaws.com:1521:ORCL";
	private static String uname = "greenbull";
	private static String password = "zackattack";

	@Override
	public ArrayList<Reimbursements> readReimbursementsByValue(int uid, String parameter) {

		System.out.println("in readReimbursementsByUserID");

		//prepping our data to store and send back later
		ArrayList<Reimbursements> reimb_list = new ArrayList<Reimbursements>();
		Reimbursements reimb = null;

		//connect to database
		try(Connection conn = DriverManager.getConnection(url, uname, password)){
			//SQL statement - should get one data entry
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM REIMBURSEMENTS WHERE " + parameter + " = ?");
			ps.setInt(1, uid);
			//get from database
			ResultSet rs = ps.executeQuery();

			//fill our instance with the db data
			while(rs.next()) {
				reimb = new Reimbursements(rs.getInt("REIMBURSEMENT_ID"), rs.getInt("STATUS"), rs.getInt("USER_ID"));
				reimb_list.add(reimb);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		//returns an instance of User class
		return reimb_list;
	}
	
	public Reimbursements readReimbursementID(int uid) {

		System.out.println("in readReimbursementID");

		//prepping our data to store and send back later
		Reimbursements reimb = null;

		//connect to database
		try(Connection conn = DriverManager.getConnection(url, uname, password)){
			//SQL statement - should get one data entry
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM REIMBURSEMENTS WHERE REIMBURSEMENT_ID = ?");
			ps.setInt(1, uid);
			//get from database
			ResultSet rs = ps.executeQuery();

			//fill our instance with the db data
			while(rs.next()) {
				reimb = new Reimbursements( rs.getInt("REIMBURSEMENT_ID"), rs.getInt("STATUS"), rs.getInt("USER_ID"), rs.getInt("AMOUNT"), rs.getInt("EVENT_TYPE_ID"), rs.getInt("APPROVED_SUPERVISOR"),
						rs.getInt("APPROVED_DEPTHEAD"), rs.getInt("APPROVED_BENCO"), rs.getInt("APPROVED_BENCOSUPERVISOR"), rs.getString("FNAME"), rs.getString("LNAME"), rs.getInt("DATE_MONTH"),
						rs.getInt("DATE_DAY"), rs.getInt("DATE_YEAR"), rs.getString("APPLICATION_METHOD"), rs.getString("ADDRESS"), rs.getString("CITY"), rs.getString("STATE"),
						rs.getString("ZIPCODE"), rs.getInt("COST"), rs.getString("WORKTIME_MISSED"), rs.getString("COURSE_NAME"), rs.getInt("GRADE"), rs.getString("APPROVAL_TYPE"),
						rs.getString("COURSE_LOCATION"), rs.getString("WORK_DESCRIPTION"));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		//returns an instance of User class
		return reimb;
	}
	
	//updating the reimbursement for by some parameter
	public void updateFormById(int fid, String parameter, int value) {
		// connect to database
		try (Connection conn = DriverManager.getConnection(url, uname, password)) {
			System.out.println("Inside updateUserByUsername");
			// SQL statement - should get one data entry
			PreparedStatement ps = conn.prepareStatement("UPDATE REIMBURSEMENTS SET " + parameter + " = ? WHERE REIMBURSEMENT_ID = ?");

			ps.setInt(1, value);
			ps.setInt(2, fid);
			ps.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}


	public void FormInsert(HttpServletRequest request) throws SQLException {
		//Add inserts
		try(Connection conn = DriverManager.getConnection(url, uname, password)) {
			String fname = request.getParameter("fname");
			String lname = request.getParameter("lname");
			String month = request.getParameter("Month");

			System.out.println("month is: " + month);
			System.out.println("Integer.valueOf(month): " + Integer.valueOf(month));
			String day = request.getParameter("Day");
			System.out.println("day is: " + day);

			String year = request.getParameter("Year");
			System.out.println("year is: " + year);
			String applicationMethod = request.getParameter("application_method");
			String courseName = request.getParameter("CourseName");
			String grade = request.getParameter("Grade");

			System.out.println("Grade is: " + grade);

			

			String streetAddress = request.getParameter("Street_Address");
			String city = request.getParameter("City");
			String state = request.getParameter("State");
			String zip = request.getParameter("ZipCode");

			//WorkDescription
			String workJustification = request.getParameter("WorkJustification");
			String cost = request.getParameter("Cost");
			String workTimeMissed = request.getParameter("WorkTimeMissed");

			//Approval type
			String typeOfApproval = request.getParameter("TypeOfApproval");

			//Not sure how attachments work here
			@SuppressWarnings("unused")
			String attachments = request.getParameter("Attachments");

			//Change to insert
			//PreparedStatement ps = conn.prepareStatement("SELECT * FROM REIMB_WORKERS WHERE USER_NAME = ?");
				try (PreparedStatement stmt2 = conn.prepareStatement("INSERT INTO Reimbursements "
						+ "(REIMBURSEMENT_ID, USER_ID, FNAME, LNAME, DATE_MONTH, DATE_DAY, DATE_YEAR, APPLICATION_METHOD,COURSE_NAME,GRADE, ADDRESS,"
						+ " CITY, STATE, ZIPCODE,WORK_DESCRIPTION, COST, WORKTIME_MISSED, APPROVAL_TYPE) "
						+ "VALUES (REIMBURSEMENTS_SEQ.NEXTVAL, 1, ?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)")) {
			        stmt2.setString(1, fname);
			        stmt2.setString(2, lname);
			        stmt2.setInt(3, Integer.valueOf(month));
			        stmt2.setInt(4, Integer.parseInt(day));
			        stmt2.setInt(5, Integer.parseInt(year));
			        stmt2.setString(6, applicationMethod);
			        stmt2.setString(7, courseName);
			        stmt2.setInt(8, Integer.parseInt(grade));
			        stmt2.setString(9, streetAddress);
			        stmt2.setString(10, city);
			        stmt2.setString(11, state);
			        stmt2.setString(12, zip);
			        stmt2.setString(13, workJustification);
			        stmt2.setString(14, cost);
			        stmt2.setString(15, workTimeMissed);
			        stmt2.setString(16, typeOfApproval);

			      
			        stmt2.executeUpdate();

		      }
		}
	}
}