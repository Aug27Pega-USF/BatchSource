package com.runtime.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.runtime.bean.Reimbursement;
import com.runtime.bean.User;
import com.runtime.dao.ReimbursementDaoImpl;

public class ReimbursementController {
	
	public static String ReimbursementJSON(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("in ReimbursementJSON method");
		//User user = new User();
		HttpSession session = request.getSession(true);
		User user1 = (User)session.getAttribute("User");
		int user2 = user1.getUserId();
		System.out.println(user2);
		ReimbursementDaoImpl reimbursementDaoImpl = new ReimbursementDaoImpl();
		List<Reimbursement> reimbursement = reimbursementDaoImpl.getReimbursementList(user2);
		//Transaction trans = (Transaction) request.getSession().getAttribute("Trans");
		System.out.println(reimbursement);
		try {
			response.getWriter().write(new ObjectMapper().writeValueAsString(reimbursement));
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	
	}

}
