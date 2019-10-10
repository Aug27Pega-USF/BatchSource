package com.example.controller;

import javax.servlet.http.HttpServletRequest;

import com.example.daoimpl.PetDAOImpl;
import com.example.model.Pet;

public class RegisterController {
	public static String Register(HttpServletRequest request) {
		if (request.getMethod().equals("GET")) {
			return "/html/Login.html";
		}
		String name = request.getParameter("name");
		String type = request.getParameter("type");
		System.out.println(name);
		PetDAOImpl pdi = new PetDAOImpl();
		Pet pet = new Pet();

		pet.setName(name);
		pet.setType(type);

		pdi.insertPet(pet);
		System.out.println(pet);
		return "/html/Login.html";
	}
}
