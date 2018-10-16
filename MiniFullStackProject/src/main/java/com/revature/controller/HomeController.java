package com.revature.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.models.User;

public class HomeController {

	public static String Home(HttpServletRequest request) {
		if (request.getMethod().equals("GET")) {
			return "/html/Home.html";
		}
		
		return null;
	}
	
	public static String UserJSON(HttpServletRequest request, HttpServletResponse response) {
		User user = (User)request.getSession().getAttribute("User");
		
		try {
			response.getWriter().write(new ObjectMapper().writeValueAsString(user));
		} catch(JsonProcessingException e) {
			e.printStackTrace();
		} catch(IOException e) {
			e.printStackTrace();
		}
		return null;
	}

}
