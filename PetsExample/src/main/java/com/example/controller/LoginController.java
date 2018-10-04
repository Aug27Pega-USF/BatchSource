package com.example.controller;

import javax.servlet.http.HttpServletRequest;

import com.example.dao.PetDaoImpl;
import com.example.model.Pet;

public class LoginController {
	
	public static String Login(HttpServletRequest request) {
		if (request.getMethod().equals("GET")) {
			return "/html/Login.html";
		}
		
		String name = request.getParameter("name");
		String type = request.getParameter("type");
		
		PetDaoImpl petDaoImpl = new PetDaoImpl();
		Pet pet = new Pet();
		
		pet = petDaoImpl.selectPetByName(name);
		
		if(name.equals(pet.getName()) && type.equals(pet.getType())) {
			request.getSession().setAttribute("Pet", pet);
			return "/html/Home.html";
		}
		else {
			return "/html/Login.html";
		}
		
		
	}

}
