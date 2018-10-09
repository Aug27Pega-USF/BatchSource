package com.runtime.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.runtime.bean.User;
import com.runtime.controller.RequestHelper;

public class MasterServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("dO get MASTER SERVET");	
		String jsonStuff = RequestHelper.process(request, response); 

	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("dO POST MASTER SERVET");
		String targetURL = RequestHelper.process(request,response);
		request.getRequestDispatcher(targetURL).forward(request, response);
	}

}