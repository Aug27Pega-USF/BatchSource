package com.greenbull.controller;

import javax.servlet.http.HttpServletRequest;

import com.greenbull.dao.UserDAOImpl;

public class RegisterController {
	
	public static String Register(HttpServletRequest request) {
		if (request.getMethod().equals("GET")) {
			//CHANGE LATER
			return "/html/register.html";
		}
		
		System.out.println("the register!");
		String firstname = request.getParameter("fname");
		String lastname = request.getParameter("lname");
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String password2 = request.getParameter("repassword");
		String exit = request.getParameter("ExitButton");
		
		UserDAOImpl udi = new UserDAOImpl();
		
		if( firstname != null && lastname != null && username != null
				&& password != null && password2 != null) {
			if (password.equals(password2)) {
				System.out.println("made a new user?");
				udi.insertUser(firstname, lastname, username, password);
				return "/html/login.html";
			}
			else
				return "/html/register.html";
		}
		
		else if(exit != null)
			return "/html/login.html";
		
		else 
			return "/html/register.html";
		
	}
}