package com.example.controller;

import javax.servlet.http.HttpServletRequest;

import com.example.dao.PetDaoImpl;
import com.example.model.Pet;


public class RegisterController {

	public static String Register(HttpServletRequest request) {
		if (request.getMethod().equals("GET")) {
			return "/html/Login.html";
		}
		
		String name = request.getParameter("name");
		String type = request.getParameter("type");
		
		Pet pet = new Pet();
		
		pet.setName(name);
		pet.setType(type);
		
		PetDaoImpl petDaoImpl = new PetDaoImpl();
		petDaoImpl.insertPet(pet);
		return "/html/Login.html";
	}


}


