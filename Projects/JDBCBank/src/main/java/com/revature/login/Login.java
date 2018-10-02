package com.revature.login;

import java.sql.Date;
import java.sql.SQLException;
import java.util.Scanner;

import com.revature.BankDriver;
import com.revature.beans.User;
import com.revature.daoimpl.LoginInfoDaoImpl;
import com.revature.daoimpl.UserDaoImpl;
import com.revature.exceptions.IncorrectPasswordException;
import com.revature.exceptions.NameFormatException;
import com.revature.exceptions.SocialException;
import com.revature.exceptions.UserNotFoundException;
import com.revature.util.DAOFactory;
/**
* @author Kevin Medara
* @since 09-04-2018
* @Version 2.0
* 
* Holds methods for logging in and creating a user
*/


public class Login {
 
	static Scanner keyboard = new Scanner(System.in);
	
  public User run() {
	  int count = 0;
	LoginInfoDaoImpl loginDao = DAOFactory.getLoginDAO();
	UserDaoImpl userDao = DAOFactory.getUserDAO();
	User currentUser = null;
    boolean found = false;
    String username="";
    String password="";
    System.out.println("LOGIN PAGE:");
    while(!found) {
    	try {
    		System.out.println("Enter Username: ");
    	     username = keyboard.nextLine();
    	     found = loginDao.checkExistence("LOGIN_USERNAME", username);
    	     if(!found) {
    	    	 throw new UserNotFoundException("That username does not exist in the system.\n*************************************\"");
    	     } else {
    	    	 currentUser = userDao.getByUsn(username);
    	     }
    	     System.out.println("Enter Password: ");
    	     password = keyboard.nextLine();
    	     if(!password.equals(currentUser.getPassword()))throw new IncorrectPasswordException("Incorrect Password.");   	      	
    	} catch (IncorrectPasswordException e){
    		e.getMessage();
    		Validation.checkAttemptCount(count);
    		return null;
    	} catch (UserNotFoundException e) {
    		 e.getMessage();
    	}
    }
    return currentUser;
  }
  
  /*Create An Account*/
  public void createAccount() {
    int count=0;
    boolean validNames=false,validSocial=false,validPassword=false, validPhone=false,validDOB=false,validUsn=false;
    String fName ="",lName="",phone="",social="",username="", password = "",confirmPassword="";
	String birthdate="";
    
    System.out.println("CREATION PAGE:");
    
    /*Loop To Validate Name*/
    while(!validNames) {
    	try {
    		System.out.println("First Name: ");
        	fName = keyboard.nextLine();
        	System.out.println("Last Name: ");
        	lName = keyboard.nextLine();
        	validNames = Validation.validateNames(fName,lName);
        	count++;
        	if(!validNames) throw new NameFormatException("Name Must Only Contain Letters And [-']\n"
        			+ "***************************************");
    	} catch (NameFormatException e) {
    		System.out.println( e.getClass()+" "+ e.getMessage());
    		Validation.checkAttemptCount(count);	  	
    	}			
    }
    /*Loop To Validate Social*/
    count =0;
    while(!validSocial) {
    	try {
    		System.out.println("Enter SSN (XXX-XX-XXXX)");
    		social = keyboard.nextLine();
    		validSocial = Validation.validateSocial(social);
    		count++;
    		if(!validSocial) throw new SocialException("Social security number is not valid.\n"
    			+ "***************************************");
    		if(Validation.userExists(social)) throw new SocialException("You already have an account with us.\n"
    				+ "************************************");
    	} catch (SocialException e) {
        		System.out.println(e.getMessage());
        		Validation.checkAttemptCount(count);
        		return;
        			  	
    	}
    }
    /*Loop To Validate DOB*/
    count=0;
    while(!validDOB) {
    	System.out.println("Enter your date of birth. (YYYY-MM-DD)\n************************");
    	birthdate= keyboard.nextLine();
    	validDOB = Validation.validateBirth(birthdate);
    	count++;
    	Validation.checkAttemptCount(count);	  	
    }
    /*Loop To Validate Phone*/
    count=0;
    while(!validPhone) {
    	System.out.println("Enter your main phone number. (XXX)XXX-XXXX\n**********************************************");
    	phone = keyboard.nextLine();
    	validPhone = Validation.validatePhone(phone);
    	count++;
    	Validation.checkAttemptCount(count);	  	
    }
    /*Loop To Validate Username*/
    count=0;
    while(!validUsn) {
    	System.out.println("Enter a new username for your account.\n "
    			+ "Must be between 8 and 20 characters\n "
    			+ "Can contain letters, numbers, hyphens, and underscores\n "
    			+ "Not contain any special characters (?=.*[!@#$%^&+=])\n"
    			+ "*******************************************************");
    	username = keyboard.nextLine();
    	try {
			validUsn = Validation.validateUsn(username);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
    	count++;
    	Validation.checkAttemptCount(count);	  	
    }
    count=0;
    /*Loop To Validate Password*/
    while(!validPassword) {
    	System.out.println("Enter your new pssword. Must contain at least one of the following\n "
    			+ "Lowercase letter\n Uppercase letter\n digit\n one special character (?=.*[@#$%!])\n "
    			+ "No whitespace\n at least 8 characters\n**********************");
    	password = keyboard.nextLine();
    	System.out.println("Please confirm your password.");
    	confirmPassword = keyboard.nextLine();
    	validPassword = Validation.validatePassword(password, confirmPassword);
    	count++;
    	Validation.checkAttemptCount(count);
    }
    Date date = Date.valueOf(birthdate);
    User newUser = new User(fName,lName, social, date, phone,3, username,password);
    UserDaoImpl userdao = DAOFactory.getUserDAO();
    try {
		userdao.create(newUser);
		System.out.println("Your account has been created successfully.\n******************************************");
	} catch (SQLException e) {
		System.out.println("Something happened. Your account was not created.\n*************************************************");
		e.printStackTrace();
		return;
	}
  }
  
  /*Static Nested Class For Validation Methods*/
  public static class Validation {
	  
		 /*Validate First And Last Name Input*/
	  private static boolean validateNames(String first, String last) {
			  if(first.matches("[a-zA-z]+([ '-][a-zA-Z]+)*") 
					  && last.matches("[a-zA-z]+([ '-][a-zA-Z]+)*") 
					  && first.length()!=0 
					  && last.length()!=0){
			        return true;
			      } 
			  return false;
		  }
		/*Validate Social Security Input*/
		private static boolean validateSocial(String social) {
			  if(social.matches("^(?!(000|666|9))\\d{3}-(?!00)\\d{2}-(?!0000)\\d{4}$")){
				return true;  
			  } 
			  return false;
		  }
		 /*Validate Phone Number Input*/
		  private static boolean validatePhone(String phone) {
			  if(phone.matches("\\(\\d{3}\\)\\d{3}-\\d{4}")){
					return true;  
				  }
			return false;  
		  }
		  /*Validate Birthdate Input*/
		  private static boolean validateBirth(String birthdate) {
			  try {
				  @SuppressWarnings("unused")
				Date date = Date.valueOf(birthdate);
					return true;
			  } catch(IllegalArgumentException e) {
				  System.out.println("Date Format Is Incorrect.\n************************");
				  return false;
			  }
			}
		  
		  /*Validate New Username Input*/
		  private static boolean validateUsn(String username) throws SQLException{
			  LoginInfoDaoImpl login = DAOFactory.getLoginDAO();
			  if (username.matches("[\\w-_]+") && username.length() > 8 && !login.checkExistence("LOGIN_USERNAME",username)){
				  return true;
			  } else if(login.checkExistence("LOGIN_USERNAME",username)) {
				  System.out.println("Username Is Already Taken.\n"
				  		+ "*************************");
				  return false; 
			  } else if(!username.matches("[\\w-_]+") || username.length() < 8) {
				  System.out.println("Username Is Invalid.\n********************");
				  return false;
			  }
			  return false;
		  }
		  /*Validates Password Input*/
		  private static boolean validatePassword(String password, String confirmPassword) {
			  if(password.matches("((?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%!]).{6,20})") && password.equals(confirmPassword)){
				  return true;	  
			  }
			return false;  
		  }
		  
		  /*Check if User Exists based on SSN*/
		  private static boolean userExists(String social) {
			  UserDaoImpl userImpl = DAOFactory.getUserDAO();
			return userImpl.checkExistence("SOCIAL", social);
		  }
		  
		  /*Check if max attempts were reached per validation loop*/
		  private static void checkAttemptCount(int count) {
			  if(count == 3) {
					System.out.println("You've Reached The Maximum Number Of Attempts.\n"
							+ "**********************************************");
					BankDriver.Initialize();
					}
		  }
	}
}