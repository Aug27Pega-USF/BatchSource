package com.revature.centers;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Scanner;

import com.revature.daoimp.UserDAOImp;

public class RegistrationCenter {

	public static void registration() {
		Scanner input = new Scanner (System.in);		
		System.out.println("Welcome to the Regristration Center");
		System.out.println("You will be asked a series of questions in order to register you");
		System.out.println("Be careful in your typing before pressing enter to make sure you entered correct information");
		System.out.println("If you are ready to begin hit any key");
		try {
			System.in.read();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		/*System.out.println("create a username");		
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
		System.out.println("Type in Area Code");
		int areaCode = input.nextInt();
		System.out.println("Type in phone number");
		int phone = input.nextInt();
		System.out.println("Type in SSN number");
		int ssn = input.nextInt();
		System.out.println("Type in Last Four of SSN");
		int lastfour = input.nextInt();*/
		
		
		UserDAOImp usim = new UserDAOImp();
		try {
			/*System.out.println(usim.getUserList());
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}*/
		
			usim.createUser("chrisavila", "password2", "chris", "avila", "550 buthead lane", "Orlando", "FL", 32819, 407,6151303, 523271400,1400);
			//usim.createUser(userName, password, firstName, lastName, address, city, state, zip, areaCode, phone, ssn, lastfour);
			usim.getNewUserList();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}
	public static int lastFour(int number)
	{
	     
	    String temp = Integer.toString(number);
	    int[] guess = new int[temp.length()];
	    int lastfour = guess[temp.length() - 6];

	    return lastfour;
	}

}
