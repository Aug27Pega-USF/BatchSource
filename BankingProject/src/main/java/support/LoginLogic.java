package support;

public class LoginLogic {
	//Scanner scan = new Scanner(System.in);
	public static User register() {
		System.out.println("Creating new Account...");
		User newUser = new User();
		System.out.println("Please Enter Your First Name:");
		newUser.setFname("Lois");
		System.out.println("Please Enter Your Last Name:");
		newUser.setLname("Pewterschmidt");
		System.out.println("Please Enter Your Username:");
		newUser.setUname("LooseLoisKiss79");
		System.out.println("Please enter a password:");
		newUser.setPw("password3");
		System.out.println("Lastly, please enter a starting balance:");
		newUser.setC_acct(5035.75);
		
		return newUser;
	}
}
