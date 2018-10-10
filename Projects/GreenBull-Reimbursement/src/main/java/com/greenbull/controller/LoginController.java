package com.greenbull.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.greenbull.WorkerPages;
import com.greenbull.dao.UserDAOImpl;
import com.greenbull.users.User;

/*
 * What does this need to do?
 * This class acts as a controller called by a servlet
 * It takes the current request and gets information pertaining to a login in request
 * if it matches, go to the menu page with their username, password, and id
 * if not, go to the login page
 */
public class LoginController {

	public static String Login(HttpServletRequest request) {
		if (request.getMethod().equals("GET")) {
			//CHANGE LATER
			return "/html/login.html";
		}
		
		//get out input data
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String button = request.getParameter("button");
		
		System.out.println("user " + username);
		//prepare object for accessing the database
		UserDAOImpl userDaoImpl = new UserDAOImpl();
		//prep for a new user object
		User user = new User();
		//return user by accessing it's info from the database
		
		boolean check_if_username = false;

		if(button != null)
            return "/html/register.html";
        
		else if(!username.equals("")) {
			user = userDaoImpl.readUserByUsername(username);
			
			if(user != null) {
				if (username.equals(user.getUsername()) && password.equals(user.getPassword()))
					check_if_username = true;
			}
		}
		//if our name and password equals the one in the DB,
		//	make a session and go to Menu
		if( check_if_username ) {

			HttpSession session=request.getSession(); 
			//User user = (User)session.getAttribute("User");
			//store the user object in the session
			session.setAttribute("User", user);
			
			//set which page we go to based on the type of user logging in
			int type_of = user.getType_of_id();
			
			//set us to the next page based on user type
			return WorkerPages.getWorkerPage(type_of);
		}
		//otherwise, reload login
		else {
			//CHANGE LATER
			return "/html/login.html";
		}
	}

}
