package com.example.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.example.model.Pet;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class HomeController {
	

	public static String Home(HttpServletRequest request) {
		if (request.getMethod().equals("GET")) {
			return "/html/Home.html";
		}
		
		
		return null;


}


	public static String PetJSON(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("in PetJSON method");
		Pet pet =(Pet)request.getSession().getAttribute("Pet");
		try {
			response.getWriter().write(new ObjectMapper().writeValueAsString(pet));
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
}
