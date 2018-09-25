package APP;

import java.sql.SQLException;
import java.util.Scanner;

import jdbc.bank.DAOIMPL.AccountsDAOimpl;
import jdbc.bank.DAOIMPL.UsersDAOimpl;

public class bankapp implements bankMain{
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
		System.out.println("MEMBER: ");
		System.out.println(userName);
		adm.getAccounts(userName);
		
	}
	public void AccountInfo() throws SQLException {
		
	
	
		
	}
		
	}

	
	


