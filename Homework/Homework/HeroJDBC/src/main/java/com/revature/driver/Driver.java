package com.revature.driver;

import java.sql.SQLException;
import java.util.*;
import com.revature.daoimpl.UserAccountDAOImpl;

public class Driver {

	private static String uName;
	private static String upasw;
	private static int  Adminf;

	public static void main(String[] args) {
		/*********************************
		 * Admin flags
		 ********************************/
		Adminf = 0;

		Scanner scanner = new Scanner(System.in);
		/*********************************
		 * User login check
		 * and prompting user
		 ********************************/
		
		System.out.println("Press 1 to login");
		System.out.println("Press 2 to create a user");
		System.out.println("Press 3 to exit");
        while (true) {
        int login = scanner.nextInt();
        switch (login) {
            case 1://Customer
            	if(login == 1) {
                	Login();
            	}
                break;
            case 2://Employee
            	if(login == 2) {
                	Create();
            	}
                break;
            case 3:
            	if(login == 3) {
            		System.exit(1);
            	}
            }break;
        }
    }
		public static void Login() {
			Scanner scanner = new Scanner(System.in);
			
			System.out.println("Enter user name");
			String userName = scanner.nextLine();
			
			System.out.println("Enter user password");
			String userPasw = scanner.nextLine();
				CustomerLog(userName, userPasw);
			System.out.println("hi");
		}
		
		public static void Create() {
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Create your user name");
		String uName = scanner.nextLine();
		
		System.out.println("Create your user password");
		String uPasw = scanner.nextLine();
		 			
					RegisterCustomer( uName, uPasw, Adminf);
		}
		public static void RegisterCustomer( String uName, String uPasw, int Adminf) {
			UserAccountDAOImpl shd = new UserAccountDAOImpl();
			try {
				shd.createUserAccount( uName, uPasw, Adminf);
				System.out.println(shd.getUserAccountList().toString());
				System.out.println("Your ID is: ");
				shd.getID(uName, uPasw);
			}catch (SQLException e) {
				e.printStackTrace();
			}
		}
		public static void CustomerLog(String uName, String upasw) {
			UserAccountDAOImpl shdi = new UserAccountDAOImpl();
			try {
				shdi.getPassword(uName, upasw);
				
				System.out.println(shdi.getUserAccountList().toString());
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
