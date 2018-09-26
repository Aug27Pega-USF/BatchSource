package com.revature.driver;

import java.sql.SQLException;
import java.util.InputMismatchException;
import java.util.Scanner;

import com.revature.accounts.Users;
import com.revature.daoimpl.AdminDAOImpl;
import com.revature.daoimpl.UserAccountsDAOImpl;
import com.revature.daoimpl.UsersDAOImpl;

public class Driver {
	
	static AdminDAOImpl admin= new AdminDAOImpl();
	static UsersDAOImpl user = new UsersDAOImpl();
	static UserAccountsDAOImpl uact= new UserAccountsDAOImpl();
	static Scanner s = new Scanner(System.in);
	
	public static void main(String[] args) 
	{
		boolean isTrue= false;
		int currentID;
		boolean isExit=false;
		System.out.println("Welcome to the Bank App!");
		AdminView ad= new AdminView();
		UserView uv= new UserView();
		
		while(!isExit)
		{
			System.out.println("Please make a selection: ");
			System.out.println("(1) Register");
			System.out.println("(2) Login");
			System.out.println("(3) Exit");
			int choice1=s.nextInt();
			switch(choice1)
			{
			case 1:
				bankRegister();
				break;
			case 2:
					System.out.println("Sign in as User(1) or Admin(2)?");
					
					int choice2=s.nextInt();
					switch(choice2)
						{
						case 1:
							currentID=bankLogin();
						//System.out.println(c_id);
						if(currentID!=0)
						{
							try 
								{
								System.out.println(user.getUser(currentID));
								uv.User_Choices(currentID);
								} 
							catch (SQLException e) 
								{
								e.printStackTrace();
								}
						}
						 break;
						 
						case 2:
							currentID=bankLoginAdmin();
							System.out.println(currentID);
							if(currentID!=0)
							{
								ad.Admin_Choices();
							}
							break;
							default:
								System.out.println("Use a proper variable");
						}
					break;
			case 3:
				isExit=true;
				break;
			default:
				System.out.println("Please make a proper choice.");
				
			}
		}
		
		
	}
	
	public static String getName(int id)
	{
		String name="No name found";
		try {
			for(int i=0; i<admin.getUser().size();i++)
			{
				if(admin.getUser().get(i).getId()==id)
				{
					name=admin.getUser().get(i).getFname()+" "+admin.getUser().get(i).getLname();
				}
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return name;
		
	}
	
	/*isTrue=admin.checkAdminLogin(uname, pswrd);
	if(isTrue==true)
	{
		System.out.println("Login Success");
		u_id=user.getUserID(uname);
	}*/
	
	//Login 
	public static int bankLogin()
	{
		Scanner p= new Scanner(System.in);
		String uname;
		String pswrd;
		boolean isTrue=false;
		int u_id=0;
		//boolean isLogin=false;
		//Loop to ensure Login is true
		while(!isTrue)
			{
		System.out.println("Login(1) or Main Menu(2)?");
		int op= s.nextInt();
				switch(op)
				{
		
				case 1:
						//User Input
						System.out.println("Username: ");
						uname=p.nextLine();
						System.out.println("Password: ");
						pswrd= p.nextLine();
						//Check to see if Login was successful. If not they can try again.
							try {
								isTrue=user.checkUserLogin(uname, pswrd);
								if(isTrue==true)
								{
									System.out.println("Login Success");
									u_id=user.getUserID(uname);
								}
								else
								{
									System.out.println("Login Failed. Please check your Username and Password.");
								}
							} catch (SQLException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
							break;
				case 2:
					isTrue=true;
					break;
					
					default:
						System.out.println("Please use one of the variables given above");
				}
		}
		
		return u_id;
	}
	
	
	public static int bankLoginAdmin()
	{
		String uname;
		String pswrd;
		boolean isTrue=false;
		int u_id=0;
		Scanner p= new Scanner(System.in);
		//boolean isLogin=false;
		//Loop to ensure Login is true
		/*try {
			System.out.println(admin.getAdmin());
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}*/
		while(!isTrue)
			{
		System.out.println("Login(1) or Main Menu(2)?");
		try {
		int op= s.nextInt();
		
				switch(op)
				{
		
				case 1:
						//User Input
						System.out.println("Username: ");
						uname=p.nextLine();
						System.out.println("Password: ");
						pswrd= p.nextLine();
						//Check to see if Login was successful. If not they can try again.
							try {
								isTrue=admin.checkAdminLogin(uname, pswrd);
								if(isTrue==true)
								{
									System.out.println("Login Success");
									u_id=admin.getAdminID(uname);
								}
								else
								{
									System.out.println("Login Failed. Please check your Username and Password.");
								}
							} catch (SQLException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
							break;
				case 2:
					isTrue=true;
					break;
					
					default:
						System.out.println("Please use one of the variables given above");
				}
		}
				catch(InputMismatchException e)
				{
					System.out.println("Please use a Number for menu choice.");
				}
		}
		
		return u_id;
	}
	
	//Register User into DataBase
	public static void bankRegister()
	{
		Scanner p= new Scanner(System.in);
		String uname;
		String pswrd;
		String fname;
		String lname;
		boolean isRegistered=false;
		//Checks to see if Register went through correctly
		while(!isRegistered)
		{
		//User Input
		System.out.println("Username: ");
		uname=p.nextLine();
		System.out.println("Password: ");
		pswrd= p.nextLine();
		System.out.println("First Name: ");
		fname=p.nextLine();
		String chkf= fname.replaceAll("\\D+", "");
		System.out.println("Last Name: ");
		lname= p.nextLine();
		String chkl= fname.replaceAll("\\D+", "");
		
		//checks to see if Username is already in database. If true then requests they make another user name.
			try {
				if(user.checkName(uname)==true)
				{
					System.out.println("That Username is already used.");
				}
				else if(!chkf.equals(""))
				{
					System.out.println("Please no numbers. In your First Name.");
				}
				else if(!chkl.equals(""))
				{
					System.out.println("Please no numbers. In your Last Name.");
				}
				else
				{
				user.createUser(fname, lname, uname, pswrd);
				
				isRegistered=true;
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	
}

