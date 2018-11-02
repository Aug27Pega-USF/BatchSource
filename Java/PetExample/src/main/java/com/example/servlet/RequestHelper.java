package com.example.servlet;

public class RequestHelper {
	
	public static String process(HttpServletRequest request, HttpServletResponse response) {
		switch(request.getRequestURI()) {
		case "/PetExample/html/Login.do":
			return LoginController.Login(request);
		case "/PetExample/html/Home.do":
			//return HomeController.Login(request);
		case "PetExample/html/Register.do":
			return RegisterController.Register(request);
		default:
			return "/html/Login.html";
		}
	}
}
