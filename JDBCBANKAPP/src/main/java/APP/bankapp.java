package APP;

import java.sql.SQLException;
import java.util.Scanner;

import jdbc.bank.DAOIMPL.AccountsDAOimpl;
import jdbc.bank.DAOIMPL.UsersDAOimpl;
import jdbc.bank.DAOIMPL.transactionsDAOimpl;

public class bankapp implements bankMain{
	static int selector;
	public static Scanner sc = new Scanner(System.in);	
	public void newUser() throws SQLException {
	
		
		UsersDAOimpl udi = new UsersDAOimpl();
		String newUser;
		String newPwd;
		
		System.out.println("Enter new username:");
		newUser= sc.next();
		System.out.println("Enter new password");
		newPwd = sc.next();
		try {
			udi.createNewUser(newUser,newPwd);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("NOW LOGIN");
	}
	public void Login() throws SQLException {
		String userName;
		String password;
		UsersDAOimpl udl = new UsersDAOimpl();
		System.out.println("USERNAME:");
		userName = sc.next();
		System.out.println("PASSWORD:");
		password = sc.next();
		udl.userLogin( userName, password);
		AccountsDAOimpl adm = new AccountsDAOimpl();
		System.out.println("MEMBER: "+ userName);
		adm.getAccounts(userName);
		
	}
	
	
	public void AccountUpdateW() throws SQLException {
		String username;
		int account_id;
		double balance;
		double amount;
		System.out.println("SECURITY CHECK");
		System.out.println("ENTER YOUR USERNAME:");
		username = sc.next();
		System.out.println("ENTER YOUR ACCOUNT#");
		account_id=sc.nextInt();
		System.out.println("AMOUNT YOU WISH TO WITHDRAW");
		amount = sc.nextDouble();
		System.out.println("YOUR NEW BALANCE IS:");
		transactionsDAOimpl tw = new transactionsDAOimpl();
		tw.doWithdraw(account_id, amount, username);
		AccountsDAOimpl ai = new AccountsDAOimpl();
		ai.getInfo(username)
		;
	}
	public void AccountUpdateD() throws SQLException {
		String username;
		int account_id;
		double balance;
		double amount;
		System.out.println("SECURITY CHECK");
		System.out.println("ENTER YOUR USERNAME:");
		username = sc.next();
		System.out.println("ENTER YOUR ACCOUNT#");
		account_id=sc.nextInt();
		System.out.println("AMOUNT YOU WISH TO DEPOSIT");
		amount = sc.nextDouble();
		System.out.println("YOUR NEW BALANCE IS:");
		transactionsDAOimpl tw = new transactionsDAOimpl();
		tw.doDeposit(account_id, amount, username);
		AccountsDAOimpl ai = new AccountsDAOimpl();
		ai.getInfo(username)
		;
	}
	
		
	}
		
	

	
	


