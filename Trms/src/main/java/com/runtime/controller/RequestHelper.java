package com.runtime.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RequestHelper {

	public static String process(HttpServletRequest request, HttpServletResponse response) {
		System.out.println(request.getRequestURI());
		switch (request.getRequestURI()) {

		case "/PetsExample/html/Login.do":
			System.out.println("in Login.do case");
			return LoginController.Login(request);

		case "/PetsExample/html/Profile.do":
			System.out.println("in Home.do case");
			return ProfileController.Profile(request);

		case "/PetsExample/html/Register.do":
			System.out.println("in Register.do");
			return RegisterController.Register(request);

		case "/PetsExample/html/PetJSON.do":
			return ProfileController.UserJSON(request, response);

		default:
			return "/html/Login.html";
		}
	}

}
