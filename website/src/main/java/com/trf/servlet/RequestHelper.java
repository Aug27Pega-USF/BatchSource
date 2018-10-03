package com.trf.servlet;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.trf.controller.LoginController;
import com.trf.controller.TRFController;

public class RequestHelper {
	public static String process(HttpServletRequest request,HttpServletResponse response) {
	switch(request.getRequestURI()) {
	case "/website/html/Login.do":
		return LoginController.Login(request);
	case "/website/html/Home.do":
		return null;
	case "/website/html/TRF.do":
		return TRFController.submitTRF(request);
	default:
		return "/html/Login.html";
	}
}
}
