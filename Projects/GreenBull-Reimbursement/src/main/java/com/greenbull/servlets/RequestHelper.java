package com.greenbull.servlets;


import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.greenbull.controller.FormController;
import com.greenbull.controller.LoginController;
import com.greenbull.controller.LogoutController;
import com.greenbull.controller.MenuController;
import com.greenbull.controller.RegisterController;
import com.greenbull.controller.ViewController;


/**
 * Servlet implementation class RequestHelper
 */
public class RequestHelper  {
	public static String process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
		
		System.out.println("Showing the URI: " + request.getRequestURI());
		//switch case for discerning which servlet to call,
		//based on the current page
		switch(request.getRequestURI()) {
			
			case "/GreenBull-Reimbursement/html/Login.do":
				return LoginController.Login(request);
			
			case "/GreenBull-Reimbursement/html/Register.do":
                return RegisterController.Register(request);
                
			case "/GreenBull-Reimbursement/html/Logout.do":
				return LogoutController.Logout(request, response);
			
			case "/GreenBull-Reimbursement/html/Back.do":
				return LogoutController.Back(request, response);
				
			case "/GreenBull-Reimbursement/html/MenuJSON.do":
				return MenuController.MenuJSON(request, response);
				
			case "/GreenBull-Reimbursement/html/Employee.do":
				return MenuController.Employee(request);
		
			case "/GreenBull-Reimbursement/html/MenuReimbursements.do":
				return MenuController.MenuReimbursements(request, response);
				
			case "/GreenBull-Reimbursement/html/Viewform.do":
				return ViewController.OpenForm(request);
				
			case "/GreenBull-Reimbursement/html/FillForm.do":
				return ViewController.FormJSON(request, response);
				
			case "/GreenBull-Reimbursement/html/UserFormData.do":
				return ViewController.UserFormData(request, response);
			
			case "/GreenBull-Reimbursement/html/ApproveForm.do":
				return ViewController.ApproveForm(request);
				
			case "/GreenBull-Reimbursement/html/DenyForm.do":
				return ViewController.DenyForm(request);
				
			case "/GreenBull-Reimbursement/html/Form.do":
				return FormController.Form(request);
			
			
			/*
			case "/PetsExample/html/Register.do":
				return RegisterController.Register(request);
			*/
			default:
				return "/html/login.html";
		}
	}
}
