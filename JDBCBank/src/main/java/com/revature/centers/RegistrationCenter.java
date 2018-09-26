package com.revature.centers;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Scanner;

import com.revature.daoimp.UserDAOImp;

public class RegistrationCenter {

	public static void registration() {
		//Registration center will ask questions related to Database to create a new User
		Scanner input = new Scanner (System.in);		
		System.out.println("Welcome to the Regristration Center");
		System.out.println("You will be asked a series of questions in order to register you");
		System.out.println("Be careful in your typing before pressing enter to make sure you entered correct information");
		System.out.println("If you are ready to begin hit any key");
		try {
			System.in.read();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		
		System.out.println("create a username");		
		String userName = input.nextLine();
		System.out.println("create a password");
		String password = input.nextLine();
		System.out.println("Type in first name");
		String firstName = input.nextLine();
		System.out.println("Type in last name");
		String lastName = input.nextLine();
		System.out.println("Type in street address");
		String address = input.nextLine();
		System.out.println("Type in City");
		String city = input.nextLine();
		System.out.println("Type in State's 2 Digit code");
		String state = input.nextLine();
		System.out.println("Type in Zip code");
		int zip = input.nextInt();
		
		
		UserDAOImp usim = new UserDAOImp();
		try {
			//CreateUser will run then afterwards getNewUser which will grab the last user entered into the Database
			usim.createUser(userName, password, firstName, lastName, address, city, state, zip);
			usim.getNewUserList();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		

	}
	

}
