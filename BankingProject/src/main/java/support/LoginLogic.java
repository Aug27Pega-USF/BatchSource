package support;

import java.util.Scanner;

public class LoginLogic {
	//Scanner scan = new Scanner(System.in);
	/*
	 * register method will only be used to register new Customers
	 * user type will be automatically set to "Customer" 
	 */
	public User register() {
		Scanner scan = new Scanner(System.in);
		System.out.println("Creating new Account...");
		User newUser = new User();
		System.out.println("Please Enter Your First Name:");
		//newUser.setFname("Lois");
		String fname = scan.next();
		newUser.setFname(fname);
		System.out.println("Please Enter Your Last Name:");
		//newUser.setLname("Pewterschmidt");
		String lname = scan.next();
		newUser.setLname(lname);
		System.out.println("Please Enter Your Username:");
		//newUser.setUname("LooseLoisKiss79");
		String uname = scan.next();
		newUser.setUname(uname);
		System.out.println("Please enter a password:");
		//newUser.setPw("password3");
		String pw = scan.next();
		newUser.setPw(pw);
		System.out.println("Lastly, please enter a starting balance:");
		//newUser.setC_acct(5035.75);
		double cacct = scan.nextDouble();
		newUser.setC_acct(cacct);
		newUser.setType("Customer");
		scan.close();
		return newUser;
	}
}
