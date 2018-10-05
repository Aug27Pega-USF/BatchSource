package com.trf.servlet;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.trf.controller.HomeController;
import com.trf.controller.LoginController;
import com.trf.controller.TRFController;

public class RequestHelper {
	public static String process(HttpServletRequest request,HttpServletResponse response) {
		System.out.println(request.getRequestURI());
	switch(request.getRequestURI()) {
	case "/website/html/Login.do":
		System.out.println("in login do");
		return LoginController.Login(request);
	case "/website/html/EmpJSON.do":
		System.out.println("in empjson do");
		return HomeController.EmployeeJSON(request, response);
	case "/website/html/Home.do":
		return null;
	case "/website/html/TRF.do":
		System.out.println("in trf do");
		return TRFController.submitTRF(request);
	default:
		return "/html/Login.html";
	}
}
}
