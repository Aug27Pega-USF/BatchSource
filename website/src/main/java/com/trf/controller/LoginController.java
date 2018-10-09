package com.trf.controller;

import javax.servlet.http.HttpServletRequest;

import com.trf.DAOImpl.EmployeeDaoImpl;
import com.trf.beans.Employee;

public class LoginController {
	public static String Login(HttpServletRequest request) {
		if (request.getMethod().equals("GET")) {
			return "Login.html";
		}
		request.getSession().invalidate();
		String username= request.getParameter("username"); //this is from the html page.
		String password= request.getParameter("password");
		EmployeeDaoImpl employeeDaoImpl = new EmployeeDaoImpl();
		employeeDaoImpl.auto_approve();
		int employeeid=employeeDaoImpl.login(username,password);
		if (employeeid!=0) {
			Employee emp= employeeDaoImpl.getEmployeebyId(employeeid);
			request.getSession().setAttribute("Employee", emp);
			System.out.println(request.getSession().getAttribute("Employee"));
			request.getSession().setAttribute("EmployeeID", employeeid);
			request.getSession().setAttribute("Level", employeeDaoImpl.getLevel(employeeid));
			if(String.valueOf(request.getSession().getAttribute("Level")).equals("B")) {
				return "/html/BenCoHome.html";
			}else {
				return "/html/EmployeeHome.html";
			}
		}else {
			return "/html/LoginF.html";
		}
		
	}
}
