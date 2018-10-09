package com.runtime.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.runtime.bean.User;

public class ProfileController {

	public static String Profile(HttpServletRequest request) {
		if (request.getMethod().equals("GET")) {
			return "/html/Profile.html";
		}

		return null;
	}

	public static String UserJSON(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("in UserJSON method");
		User user = (User) request.getSession().getAttribute("User");
		System.out.println(user);
		try {
			response.getWriter().write(new ObjectMapper().writeValueAsString(user));
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

}
