package com.revature.controller;

import javax.servlet.http.HttpServletRequest;

import com.revature.daoimpl.UserDAOImpl;
import com.revature.models.User;

public class UpdateController {
	
	public static String Update(HttpServletRequest request) {
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

		user = udi.selectUser(uname, upassword);

		user.setFirstname(fname);
		user.setLastname(lname);
		user.setStreet(street);
		user.setCity(city);
		user.setState(state);
		user.setCountry(country);
		user.setZipcode(zipcode);
		user.setFavcolor(favcolor);
		user.setFavanimal(favanimal);
		
		udi.updateUserInfo(user);
		udi.updateUserFavs(user);

		if(uname.equals(user.getUsername()) && upassword.equals(user.getPassword())) {
			request.getSession().setAttribute("User", user);
			return "/html/Home.html";
		} else {
			return "/html/Update.html";
		}
	}
}
