package com.trf.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.trf.beans.Employee;
public class HomeController {
	

	public static String Home(HttpServletRequest request) {
		if (request.getMethod().equals("GET")) {
			return "/html/EmployeeHome.html";
		}
		return null;
}

	public static String EmployeeJSON(HttpServletRequest request, HttpServletResponse response) {
		Employee emp =(Employee)request.getSession().getAttribute("Employee");
		System.out.println(emp.toString());
		try {
			response.getWriter().write(new ObjectMapper().writeValueAsString(emp));
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
}