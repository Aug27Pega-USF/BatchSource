package com.revature.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MyFirstServlet extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Override
	//doGet
	protected void doGet(HttpServletRequest req,HttpServletResponse resp) 
	throws ServletException,IOException{
	System.out.println("doGet Roll Tide");
	}
	@Override
	//doPost
	protected void doPost(HttpServletRequest req,HttpServletResponse resp) 
			throws ServletException,IOException{
			System.out.println("doPost We Lit-RIP HARAMZbh");
			}

}