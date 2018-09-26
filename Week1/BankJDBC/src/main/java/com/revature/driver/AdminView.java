package com.revature.driver;

import java.sql.SQLException;
import java.util.Scanner;

import com.revature.accounts.Users;
import com.revature.daoimpl.AdminDAOImpl;
import com.revature.daoimpl.UsersDAOImpl;

public class AdminView {

	Scanner s = new Scanner(System.in);
	UsersDAOImpl user= new UsersDAOImpl();
	AdminDAOImpl admin= new AdminDAOImpl();
		public void Admin_Choices()
		{
			
			Driver m= new Driver();
			
			boolean isExit=false;
			System.out.println("Welcome Admin");
			while(!isExit)
			{
				System.out.println("Choices:");
				System.out.println("(1) View User");
				System.out.println("(2) Create User");
				System.out.println("(3) Update User");
				System.out.println("(4) Delete User");
				System.out.println("(5) Logout");
				int choice= s.nextInt();
				try {
						switch(choice)
						{
						case 1:
							System.out.println(admin.getUser());
							break;
						case 2:
							m.bankRegister();
							break;
						case 3:
							adminUpdate();
							break;
						case 4:
							System.out.println(admin.getUser());
							System.out.print("Which User to Delete:");
							int d_id= s.nextInt();
							admin.deleteUser(d_id);
							break;
						case 5:
							isExit=true;
							break;
							default:
								System.out.println("Please Choose one of the choices.");
						}
				}
				catch(SQLException e)
				{
					e.printStackTrace();
				}
				
			}
		}
	
		public void adminUpdate()
		{	
			Scanner p= new Scanner(System.in);
			System.out.println();
			System.out.println("Type Id of User to Update: ");
			int u_id= s.nextInt();
			Users u=null;
			try {
				u = user.getUser(u_id);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(u!=null)
				{
				System.out.println("Enter First Name: ");
				String fn= p.nextLine();
				String chk= fn.replaceAll("\\D+","");
					if(fn.equals(null) || fn.trim().equals("") || !chk.equals(""))
					{
						fn=u.getFname();
					}
				
				System.out.println("Enter Last Name: ");
				String ln= p.nextLine();
					chk= ln.replaceAll("\\D+","");
					if(ln.equals(null) || ln.trim().equals("")|| !chk.equals(""))
					{
						ln=u.getLname();
					}
				
				System.out.println("Enter Username: ");
				String un= p.nextLine();
					if(un.equals(null) || un.trim().equals(""))
					{
						un=u.getUsername();
					}
				
				System.out.println("Enter password: ");
				String pswrd= p.nextLine();
					if(pswrd.equals(null) || pswrd.trim().equals(""))
					{
						pswrd=u.getPassword();
					}				
				System.out.println("First Name: "+fn+" | Last Name: "+ln+" | Username: "+un+" | Password: "+pswrd);				
				try {
					admin.updateUser(u_id, fn, ln, un, pswrd);
					System.out.println("Updated User");
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			else
				System.out.println("Not a user!");
		}
		
}
