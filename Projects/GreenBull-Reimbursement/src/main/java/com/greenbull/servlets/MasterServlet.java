package com.greenbull.servlets;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MasterServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {
		//for getting info to the XHR in javascript
		@SuppressWarnings("unused")
		String jsonStuff = "";
		try {
			jsonStuff = RequestHelper.process(request, response);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//test time
		System.out.println("GET on MasterServlet: " + jsonStuff);
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {
		
		//test time
		System.out.println("hello, masterservlet");
		//"anything I get from this, you are handling this"
		String targetURL = "";
		try {
			targetURL = RequestHelper.process(request, response);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		//test time
		System.out.println(targetURL);
				
		//redirect, forward, printwrite
		request.getRequestDispatcher(targetURL).forward(request, response);
	}
}
