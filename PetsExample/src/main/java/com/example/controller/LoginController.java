package com.example.controller;

import javax.servlet.http.HttpServletRequest;

import com.example.daoimpl.PetDAOImpl;
import com.example.model.Pet;

public class LoginController {
	public static String Login(HttpServletRequest request) {
		if(request.getMethod().equals("GET")) {
			return "/html/Login.html";
		}
		String name = request.getParameter("name");
		String type = request.getParameter("type");
		
		PetDAOImpl pdi = new PetDAOImpl();
		Pet pet = new Pet();
		
		pet = pdi.selectPetByName(name);
		
		if(name.equals(pet.getName()) && type.equals(pet.getType())) {
			request.getSession().setAttribute("Pet", pet);
			return "/html/Home.html";
		} else {
			return "/html/Login.html";
		}
	}
}
