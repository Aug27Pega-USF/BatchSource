package com.revature.servlet;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.controller.HomeController;
import com.revature.controller.LoginController;
import com.revature.controller.RegisterController;
import com.revature.controller.UpdateController;

public class RequestHelper {
	public static String process(HttpServletRequest request, HttpServletResponse response) {
		switch (request.getRequestURI()) {
		case "/MiniFullStackProject/html/Login.do":
			return LoginController.Login(request);
		case "/MiniFullStackProject/html/UserJSON.do":
			return HomeController.UserJSON(request, response);
		case "/MiniFullStackProject/html/Register.do":
			return RegisterController.Register(request);
		case "/MiniFullStackProject/html/Update.do":
			return UpdateController.Update(request);
		default:
			return "/html/Login.html";
		}
	}
}
