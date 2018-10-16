package com.revature.controller;

import javax.servlet.http.HttpServletRequest;

import com.revature.daoimpl.UserDAOImpl;
import com.revature.models.User;

public class RegisterController {

	public static String Register(HttpServletRequest request) {
		if (request.getMethod().equals("GET")) {
			return "/html/Login.html";
		}

		String uname = request.getParameter("uname");
		String upassword = request.getParameter("upassword");
		String fname = request.getParameter("fname");
		String lname = request.getParameter("lname");
		String street = request.getParameter("street");
		String city = request.getParameter("city");
		String state = request.getParameter("state");
		String country = request.getParameter("country");
		int zipcode = Integer.parseInt(request.getParameter("zipcode"));
		String favcolor = request.getParameter("color");
		String favanimal = request.getParameter("animal");

		UserDAOImpl udi = new UserDAOImpl();
		User user = new User();
		
		user.setUsername(uname);
		user.setPassword(upassword);
		user.setFirstname(fname);
		user.setLastname(lname);
		user.setStreet(street);
		user.setCity(city);
		user.setState(state);
		user.setCountry(country);
		user.setZipcode(zipcode);
		user.setFavcolor(favcolor);
		user.setFavanimal(favanimal);
		
		udi.createUser(user);
		
		return "/html/Login.html";
	}
}