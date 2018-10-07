package com.runtime.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RequestHelper {

	public static String process(HttpServletRequest request, HttpServletResponse response) {
		System.out.println(request.getRequestURI());
		switch (request.getRequestURI()) {

		case "/Trms/html/Login.do":
			System.out.println("in Login.do case");
			return LoginController.Login(request);

		case "/Trms/html/Profile.do":
			System.out.println("in Home.do case");
			return ProfileController.Profile(request);

		case "/Trms/html/Register.do":
			System.out.println("in Register.do");
			return RegisterController.Register(request);
			
		case "/Trms/html/TransactionHistoryE.do":
			System.out.println("in TransactionHistoryE.do");
			return TransactionController.getTrans(request);
			

		case "/Trms/html/UserJSON.do":
			return ProfileController.UserJSON(request, response);
			
		case"/Trms/html/TransJSON":
			TransactionController.getTrans(request);
			return TransactionController.TransJSON(request, response);

		default:
			return "/html/Login.html";
		}
	}

}
