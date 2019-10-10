package com.example.servlet;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.example.controller.HomeController;
import com.example.controller.LoginController;
import com.example.controller.RegisterController;

public class RequestHelper {
	public static String process(HttpServletRequest request, HttpServletResponse response) {
		switch(request.getRequestURI()) {
		case "/PetsExample/html/Login.do":
			return LoginController.Login(request);
		case "/PetsExample/html/PetJSON.do":
			return HomeController.PetJSON(request,response);
		case "/PetsExample/html/Register.do":
			System.out.println("In Register.do case");
			return RegisterController.Register(request);
		default:
			return "html/Login.html";
		}
	}
}
