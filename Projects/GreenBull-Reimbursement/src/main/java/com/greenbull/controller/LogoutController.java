package com.greenbull.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LogoutController {

	public static String Logout(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException{
		if (request.getMethod().equals("GET")) {
			//CHANGE LATER
			return "/html/login.html";
		}
		
		System.out.println("got to the controller");
		HttpSession session=request.getSession();  
		session.invalidate();  
		
		return "/html/login.html";
	}
	
	public static String Back(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException{
		if (request.getMethod().equals("GET")) {
			//CHANGE LATER
			return "/html/Employee.html";
		}
		
		System.out.println("got to the controller");
		
		return "/html/Employee.html";
	}

}
