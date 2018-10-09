package com.runtime.controller;

import java.io.FileReader;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Iterator;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.JSONObject;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.runtime.bean.Transaction;
import com.runtime.bean.User;
import com.runtime.dao.TransactionDaoImpl;


public class TransactionController {

	public static String TransJSON(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("in TransJSON method");
		//User user = new User();
		HttpSession session = request.getSession(true);
		User user1 = (User)session.getAttribute("User");
		int user2 = user1.getUserId();
		System.out.println(user2);
		TransactionDaoImpl transactionDaoImpl = new TransactionDaoImpl();
		Transaction trans = transactionDaoImpl.getTransList(user2);
		//Transaction trans = (Transaction) request.getSession().getAttribute("Trans");
		System.out.println(trans);
		try {
			response.getWriter().write(new ObjectMapper().writeValueAsString(trans));
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	
	}

//	public static String getTrans(HttpServletRequest request) {
//		if (request.getMethod().equals("POST")) {
//			return "/html/TransactionHistoryE.html";
//		}
		
//		String name = request.getParameter("name");
//		String type = request.getParameter("type");
//		User user = new User();
//		user = request.getSession().getAttribute("User");
//		System.out.println(user);
//		System.out.println("User Above");
//		HttpSession session = request.getSession(true);
//		User user1 = (User)session.getAttribute("User");
//		int user2 = user1.getUserId();
//		System.out.println(user2);
//		TransactionDaoImpl transactionDaoImpl = new TransactionDaoImpl();
//		Transaction trans = (Transaction)transactionDaoImpl.getTransList(user2);
//		try {
//			trans = transactionDaoImpl.getTransList(user2);
//
//
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}

//		if (trans != null) {
//
//			request.getSession().setAttribute("Trans", trans);
//			return "/TransactionHistoryE.html";
//		} else {
//			return "/html/TransactionHistoryE.html";
//		}
//	}

}
