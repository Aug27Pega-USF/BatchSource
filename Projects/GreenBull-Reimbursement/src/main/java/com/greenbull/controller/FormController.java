package com.greenbull.controller;



import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.greenbull.dao.ReimbDAOImpl;
import com.greenbull.dao.UserDAOImpl;
import com.greenbull.users.User;

public class FormController {

	private double RemainingReimbursement(double cost) {

		return cost;
	}
	
	public static String Form (HttpServletRequest request) throws ServletException, IOException, SQLException {
		if (request.getMethod().equals("GET")) {
			//CHANGE LATER
			return "/html/form.html";
		}

		HttpSession session=request.getSession();

        User user = (User)session.getAttribute("User");
        System.out.println("User Session info: " + user.toString());
        
        String url = "jdbc:oracle:thin:@reimbursemant-database.c79flqc2drgd.us-east-2.rds.amazonaws.com:1521:ORCL";
		String uname = "greenbull";
		String password = "zackattack";
		//Connection conn = DriverManager.getConnection(url, uname, password);

		System.out.println("You are inside FromController.Form");

		//System.out.println("User Session info: " + user.toString());

		ReimbDAOImpl reimbDao = new ReimbDAOImpl();
		reimbDao.FormInsert(request);

		UserDAOImpl userDao = new UserDAOImpl();
		
		try ( Connection conn = DriverManager.getConnection(url, uname, password)){
				PreparedStatement stmt = conn.prepareStatement("SELECT PENDING_REIMBURSEMENTS FROM REIMB_WORKERS WHERE USER_ID = " + user.getId());
			/*
			 * University Courses 80%, Seminars 60%, Certification Preparation Classes 75%,
			 * Certification 100%, Technical Training 90%, Other 30%.
			 */

			ResultSet rs = stmt.executeQuery();
			float temp = 0f;

			while (rs.next()) {
				temp = rs.getFloat("PENDING_REIMBURSEMENTS");
			}
			float pendingReimb = temp;

			String temp2 = request.getParameter("Cost");
			float cost = Float.parseFloat(temp2);
			
			String appMethodSelection = request.getParameter("application_method");
			
			
			switch (appMethodSelection) {
			
			case "University Course": 
				System.out.println("Inside switch University Course");
				cost = (float) (cost * 0.8);
				System.out.println("cost is: " + cost);
				float totalReimb= cost + pendingReimb;
				System.out.println("totalReimb is: " + totalReimb);
				System.out.println("Inside switch University Course1");
				if (totalReimb <= 1000) {
					System.out.println("Inside switch University Course2");
					System.out.println("Username: " + user.getUsername());
					userDao.updateUserByUsername(user.getUsername(), "PENDING_REIMBURSEMENTS", (float) totalReimb);
					System.out.println("Inside switch University Course3");
					} else if ((pendingReimb - (totalReimb-1000)) <= 1000){
						System.out.println("math : " + (pendingReimb - (totalReimb-1000)));
						System.out.println("Inside switch University Course4");
						userDao.updateUserByUsername(user.getUsername(), "PENDING_REIMBURSEMENTS", (pendingReimb - (totalReimb-1000)));
						System.out.println("Inside switch University Course5");
					} else {
						//Display somewhere in browser
						System.out.println("Inside switch University Course6");
						System.out.println("No more funds available");
					}
				System.out.println("University course coverage: " + cost);
				break;
			case "Seminar":
				cost = (float) (cost * 0.6);
				double totalReimb2= cost + pendingReimb;
				if (totalReimb2 <= 1000) {
					userDao.updateUserByUsername(user.getUsername(), "PENDING_REIMBURSEMENTS", (float) totalReimb2);
					} else if ((totalReimb2-1000) > 0){
						userDao.updateUserByUsername(user.getUsername(), "PENDING_REIMBURSEMENTS", (float) totalReimb2);
					} else {
						//Display somewhere in browser
						System.out.println("No more funds available");
					}
				System.out.println("Seminar coverage: " + cost);
				break;
			case "Certification Preparation Class":
				cost = (float) (cost * 0.75);
				double totalReimb3= cost + pendingReimb;
				if (totalReimb3 <= 1000) {
					userDao.updateUserByUsername(user.getUsername(), "PENDING_REIMBURSEMENTS", (float) totalReimb3);
					} else if ((totalReimb3-1000) > 0){
						userDao.updateUserByUsername(user.getUsername(), "PENDING_REIMBURSEMENTS", (float) totalReimb3);
					} else {
						//Display somewhere in browser
						System.out.println("No more funds available");
					}
				System.out.println("Certification Preparation Class coverage: " + cost);
				break;
			case "Certification":
				double totalReimb4= cost + pendingReimb;
				if (totalReimb4 <= 1000) {
					userDao.updateUserByUsername(user.getUsername(), "PENDING_REIMBURSEMENTS", (float) totalReimb4);
					} else if ((totalReimb4-1000) > 0){
						userDao.updateUserByUsername(user.getUsername(), "PENDING_REIMBURSEMENTS", (float) totalReimb4);
					} else {
						//Display somewhere in browser
						System.out.println("No more funds available");
					}
				System.out.println("Certification coverage: " + cost);
				break;
			case "Technical Training":
				cost = (float) (cost * 0.9);
				double totalReimb5= cost + pendingReimb;
				if (totalReimb5 <= 1000) {
					userDao.updateUserByUsername(user.getUsername(), "PENDING_REIMBURSEMENTS", (float) totalReimb5);
					} else if ((totalReimb5-1000) > 0){
						userDao.updateUserByUsername(user.getUsername(), "PENDING_REIMBURSEMENTS", (float) totalReimb5);
					} else {
						//Display somewhere in browser
						System.out.println("No more funds available");
					}
				System.out.println("Technical Training coverage: " + cost);
				break;
			case "Other":
				cost = (float) (cost * 0.3);
				double totalReimb6= cost + pendingReimb;
				if (totalReimb6 <= 1000) {
					userDao.updateUserByUsername(user.getUsername(), "PENDING_REIMBURSEMENTS", (float) totalReimb6);
					} else if ((totalReimb6-1000) > 0){
						userDao.updateUserByUsername(user.getUsername(), "PENDING_REIMBURSEMENTS", (float) totalReimb6);
					} else {
						//Display somewhere in browser
						System.out.println("No more funds available");
					}
				System.out.println("All other coverages: " + cost);
				break;

			}

		}
		

		//System.out.println("request? " + request);
		//response.setContentType("text/html");
		//request.getRequestDispatcher("form.html").include(request, response);
		//Everything is a string for now

		//Change to where ever we direct
		return "/html/Employee.html";
	}
}