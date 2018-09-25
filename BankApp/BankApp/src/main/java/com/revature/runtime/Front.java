
/*
	 * =====MENU:=====
	 * 1-LOGIN
	 * 2-REGIGISTER
	 * 3-CHECK BALANCE
	 * 4-DEPOSIT
	 * 5-WITHDRAWAL
	 * 6-EXI/LOGOUT
	 */
package com.revature.runtime;

import java.sql.SQLException;
import java.util.Scanner;

import com.revature.beans.User_Info;
import com.revature.dao.User_Info_Dao;
import com.revature.daoImpl.User_Info_DAOImpl;
import com.revature.util.ConnFactory;

public class Front {
	
	private User_Info usd;
	public boolean isAuthenticated;
	
	
	
	public Front() {}
	
	
	public Front(User_Info usd, boolean isAuthenticated) {
		super();
		this.usd = usd;
		isAuthenticated = false;
	}

	public void process() throws SQLException {
		while(!isAuthenticated) {
			/*while(!isAuthenticated) {
				verifyUser();
			}*/
			//register();
			Scanner scan = new Scanner(System.in);
			System.out.println("Enter your username");
			String user=scan.nextLine();
			System.out.println("Enter your password");
			String pwd = scan.nextLine();
			usd = new User_Info();
			usd.setUsername(user);
			usd.setPassword(pwd);
			System.out.println(usd.getUsername());//print object
			User_Info_DAOImpl usidi = new User_Info_DAOImpl();
			System.out.println(usidi.getUserByUsername("username"));//print null
			if(user.isEmpty() && pwd.isEmpty() && 
					(!(usidi.getUserByUsername(usd.getUsername()).equals(user))) && 
					(!(usidi.getUserByPassword(usd.getPassword()).equals(pwd)))) 
			{
				//logged error message
				System.out.println("fail to login");
				//prompt user to register
				register();
			}else {
				isAuthenticated=true;
				//logged success message
				System.out.println("login success");
				// direct user to menu choice
				displayMenu();
			}
		}
		}
	
	
	/*public void performTransaction() {
		Transaction current;
		boolean isLogout = false;
		
		while(!isLogout) {
			int selection = displayMenu();
			switch(selection)
			{
			case 1: viewBalance();
			case 2;make a deposit();
			case 3: make a withdrawal();
			current = createTransaction(selection);
			
			}
		}
	}
*/
//creating user
	public void register() {
		
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter your username");
		String uname=scan.nextLine();
		System.out.println("Enter your password");
		String pwd = scan.nextLine();
		System.out.println("Enter your  first name");
		String fN=scan.nextLine();
		System.out.println("Enter your last name");
		String lN = scan.nextLine();
		
		User_Info_DAOImpl usidi = new User_Info_DAOImpl();
		try {
			usidi.createUser(uname, pwd, fN, lN);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	


	public int displayMenu(){
	
	System.out.println(" Welcome, what would you like to do today");
	Scanner sc = new Scanner(System.in);
	//System.out.println("Main Menu: ");
	System.out.println(" 1- View Balance");
	System.out.println(" 2- Make a Deposit");
	System.out.println(" 3- Make a Withdrawal");
	System.out.println(" 4- Create a Bank Account");
	System.out.println(" 5- Logout");
	int input = sc.nextInt();
	
	return input;
	
	}
	
	

}
