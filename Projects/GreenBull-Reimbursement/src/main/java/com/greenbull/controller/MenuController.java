package com.greenbull.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.greenbull.dao.ReimbDAOImpl;
import com.greenbull.dao.UserDAOImpl;
import com.greenbull.users.Reimbursements;
import com.greenbull.users.User;

/*
 * What does this do?
 * We check if there's a valid session with the proper user info within
 * If so, we want
 */
public class MenuController {

	public static String Menu(HttpServletRequest request) {
		System.out.println("This is Menu GET");
		if(request.getMethod().equals("GET")) {
			return "/html/Employee.html";
		}
		return null;
	}
	
	public static String MenuJSON(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("This is MenuJSON");
		
		HttpSession session=request.getSession(); 
		
		User user = (User)session.getAttribute("User");

		System.out.println(user.toString());

		try {
			//getting the json data and wrapping it as an object for Java to work with it
			response.getWriter().write(new ObjectMapper().writeValueAsString(user));
			//response.getWriter().write(new ObjectMapper().writeValueAsString(reimb_list));
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	
	public static String MenuReimbursements(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("This is MenuReimbursements");
		
		HttpSession session=request.getSession(); 
		
		User user = (User)session.getAttribute("User");
			
		//get the reimbursement objects for this user
		ReimbDAOImpl reimbDaoImpl = new ReimbDAOImpl();
		ArrayList<Reimbursements> reimb_list = new ArrayList<Reimbursements>();
		
		//for employees, get list by id
		if(user.getType_of_id() < 1)
			reimb_list = reimbDaoImpl.readReimbursementsByValue(user.getId(), "USER_ID");
		//for admins, get list by status
		else
			reimb_list = reimbDaoImpl.readReimbursementsByValue(user.getType_of_id()-1, "STATUS");
		
		try {
			//getting the json data and wrapping it as an object for Java to work with it
			//store the reimb objects in the session
			session.setAttribute("User", reimb_list);
			
			response.getWriter().write(new ObjectMapper().writeValueAsString(reimb_list));
			
			//store the user object in the session
			session.setAttribute("User", user);
			
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	
	public static String Employee(HttpServletRequest request) {

		System.out.println("we got to Employee()");
		
        if (request.getMethod().equals("GET")) {
            //CHANGE LATER
            return "/html/Employee.html";
        }
        String username = request.getParameter("name");
        String newf = request.getParameter("nf");

        System.out.println("newf: " + newf);

        

        if(newf.equals("New Reimbursement")) {
            //request.getSession().setAttribute("User", user);
            
            return "/html/form.html";
        }

        else if(newf.equals("Logout")) {
        	HttpSession session=request.getSession();  
    		session.invalidate();  
            return "/html/login.html";
        }
        else 
            return "/html/Employee.html";
        
    }
	
	
}
