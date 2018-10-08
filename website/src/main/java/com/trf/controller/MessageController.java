package com.trf.controller;
import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.trf.DAOImpl.TRFMessageDAOImpl;
import com.trf.beans.TRFMessage;

public class MessageController {

	public static String viewMSGJSON(HttpServletRequest request, HttpServletResponse response) {
		TRFMessageDAOImpl tmdi= new TRFMessageDAOImpl();
		int emp_id=-1;
		if (!String.valueOf(request.getSession().getAttribute("Level")).equals("B")) {
			emp_id = Integer.parseInt(String.valueOf(request.getSession().getAttribute("EmployeeID")));
		}
		ArrayList<TRFMessage> msg_list= tmdi.getMessageById(emp_id);
		try {
			response.getWriter().write(new ObjectMapper().writeValueAsString(msg_list));
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	
}
