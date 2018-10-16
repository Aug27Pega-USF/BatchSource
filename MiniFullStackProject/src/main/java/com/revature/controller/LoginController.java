package com.revature.controller;

import javax.servlet.http.HttpServletRequest;

import com.revature.daoimpl.UserDAOImpl;
import com.revature.models.User;

public class LoginController {

	public static String Login(HttpServletRequest request) {
		if(request.getMethod().equals("GET")) {
			return "/html/Login.html";
		}// check if POST or GET was used
		
		// save values passed in through POST
		String uname = request.getParameter("uname");
		String upassword = request.getParameter("upassword");
		
		// create new instance of Pet object to hold data retrieved from the db
		UserDAOImpl udi = new UserDAOImpl();
		User user = new User();
		
		// pull info from db to populate new pet object
		user = udi.selectUser(uname, upassword);
		
		// check if the given name and type passed through POST match info from db
		if(uname.equals(user.getUsername()) && upassword.equals(user.getPassword())) {
			request.getSession().setAttribute("User", user);
			return "/html/Home.html";// if they do, sign in to user home page
		} else {
			return "/html/Login.html";// if not, send back to login page
		}
	}
}
