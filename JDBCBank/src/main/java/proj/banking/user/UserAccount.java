package proj.banking.user;

import proj.banking.bean.UserAccountInfo;

public abstract class UserAccount extends Login{
	abstract UserAccount loggingIn();
	public abstract void userPage();
	
	public UserAccountInfo userAccInfo;
	int accountLevel;
	
	protected void headerPage() {
		System.out.println("================================================");
		System.out.println("=                    WELCOME                   =");
		System.out.println("=----------------------------------------------=");
		System.out.println("=          IQ Finanical Mobile Bank            =");
		System.out.println("=                   est. 2018                  =");
		System.out.println("================================================");
	}
	
	protected void bottomSelectMenu() {
		System.out.println("================================================");
		System.out.print(" Selection: ");
	}
}
