package com.greenbull.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.greenbull.WorkerPages;
import com.greenbull.dao.ReimbDAOImpl;
import com.greenbull.users.Reimbursements;
import com.greenbull.users.User;

public class ViewController {

	//taking us to the view form page while holding onto the form id for reference
	public static String OpenForm(HttpServletRequest request) {

		System.out.println("we got to OpenForm()");
		
        if (request.getMethod().equals("GET")) {
            //CHANGE LATER
            return "/html/Employee.html";
        }
        
        //get the parameter value 
        int form_id = Integer.parseInt(request.getParameter("form_id"));

        System.out.println("form_id: " + form_id);
        
        //pass the form value into our user object for reference purposes
        HttpSession session=request.getSession(); 
		User user = (User)session.getAttribute("User");
		user.setCurrent_form_id(form_id);
		session.setAttribute("User", user);
   
        //System.out.println("form_id via session: " + request.getSession().getAttribute("Form Id"));
        return "/html/viewform.html";
    }
	
	//get the form data for our needs and purposes
	public static String FormJSON(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("This is FormJSON");

		HttpSession session=request.getSession(); 
		User user = (User)session.getAttribute("User");
		System.out.println("user get test: " + user.toString());
		
		//get the parameter value 
        int form_id = user.getCurrent_form_id();

        System.out.println("form_id get test: " + form_id);
		//get the reimbursement objects for this user
		ReimbDAOImpl reimbDaoImpl = new ReimbDAOImpl();
		Reimbursements reimb = new Reimbursements();
		reimb = reimbDaoImpl.readReimbursementID(form_id);
		
		try {
			//store the reimb objects in the session
			session.setAttribute("User", reimb);
			
			response.getWriter().write(new ObjectMapper().writeValueAsString(reimb));
			
			//store the user object in the session
			session.setAttribute("User", user);
			
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	//for exiting the form back to the menu
	public static String CloseForm(HttpServletRequest request) {
		System.out.println("we got to ViewForm()");

		if(request.getMethod().equals("GET")) {
			return "/html/viewform.html";
		}

		String button = request.getParameter("button");

		if(button.equals("CloseButton")) {
			return "/html/Employee.html";
		}else {
			return "/html/viewform.html";
		}
	}
	
	
	public static String UserFormData(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("This is UserFormData");
		
		HttpSession session=request.getSession(); 
		User user = (User)session.getAttribute("User");
		System.out.println(user.toString());

		try {
			//getting the json data and wrapping it as an object for Java to work with it
			response.getWriter().write(new ObjectMapper().writeValueAsString(user));
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	//
	public static String ApproveForm(HttpServletRequest request) {
		System.out.println("we got to ApproveForm()");

		if(request.getMethod().equals("GET")) {
			return "/html/viewform.html";
		}

		HttpSession session=request.getSession(); 
		User user = (User)session.getAttribute("User");
		System.out.println(user.toString());
		int current_form = user.getCurrent_form_id();
		int type_of = user.getType_of_id();
		
		ReimbDAOImpl reimbDaoImpl = new ReimbDAOImpl();
		
		//status is set based on who just approved of it
		reimbDaoImpl.updateFormById(current_form, "STATUS", type_of);
		switch(type_of) {
			//direct supervisor
			case 1:
				reimbDaoImpl.updateFormById(current_form, "APPROVED_SUPERVISOR", user.getId());
				break;
			//department manager
			case 2:
				reimbDaoImpl.updateFormById(current_form, "APPROVED_DEPTHEAD", user.getId());
				break;
			//benco
			case 3:
				reimbDaoImpl.updateFormById(current_form, "APPROVED_BENCO", user.getId());
				break;
			//benco supervisor
			case 4:
				reimbDaoImpl.updateFormById(current_form, "APPROVED_BENCOSUPERVISOR", user.getId());
				break;
		}

		//set us to the next page based on user type
		return WorkerPages.getWorkerPage(type_of);
	}
	
	public static String DenyForm(HttpServletRequest request) {
		System.out.println("we got to DenyForm()");

		if(request.getMethod().equals("GET")) {
			return "/html/viewform.html";
		}

		HttpSession session=request.getSession(); 
		User user = (User)session.getAttribute("User");
		System.out.println(user.toString());
		int current_form = user.getCurrent_form_id();
		int type_of = user.getType_of_id();
		
		ReimbDAOImpl reimbDaoImpl = new ReimbDAOImpl();
		
		//status is set to -1 to indicate denial
		reimbDaoImpl.updateFormById(current_form, "STATUS", -1);

		//set us to the next page based on user type
		return WorkerPages.getWorkerPage(type_of);
	}
}
