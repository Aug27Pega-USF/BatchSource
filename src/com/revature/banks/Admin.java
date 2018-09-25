package com.revature.banks;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Properties;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Stream;

class Admin {  
	
	//Add to Database
	static Connection conn = getConnection();
	static Statement stmt;
	static ResultSet rs = null;
	static PreparedStatement ps;
	
	public static Connection getConnection() {
		Properties prop = new Properties();
		try {
			prop.load(new FileReader("database.properties"));
			Class.forName(prop.getProperty("driver"));
			conn = DriverManager.getConnection
					(prop.getProperty("url"),
					 prop.getProperty("usr"), 
					 prop.getProperty("password"));
			
		} catch (SQLException e){
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			
		} return conn;
	}
	public static void main(String arg[]) {
		// Test to see if it's connected to database
		try {
            stmt = conn.createStatement();
            rs = stmt.executeQuery("SELECT * FROM EMPLOYEE");
            
            String s = "SELECT * FROM EMPLOYEE";
            PreparedStatement ps = conn.prepareStatement(s);
            ps = conn.prepareStatement(s);
            ps.executeQuery(s);
            while (rs.next()) {
                System.out.println("TEST QUERY: " + rs.getString("FirstName"));
            }
                
        } catch (SQLException e) {
            e.printStackTrace();
        }
		
		
		Scanner RR=new Scanner(System.in);
		
		//Main Menu
		System.out.println("--------------------------------------------");
		System.out.println("Wakanda Bank");
		System.out.println("Welcome Admin!");
		
		//Add Accounts
				System.out.println("--------------------------------------------");
				System.out.println("How Many Customers do you want Sir: ");
					int n=RR.nextInt();
					Bank  C[]=new Bank[n];
					for(int i=0;i<C.length;i++) {   
						C[i]=new Bank();
						C[i].openAccount();
		}
		
		//run loop until #6 is pressed
		int ch;
		do {
			System.out.println("--------------------------------------------");
			System.out.println("Main Menu\n"
					+ "1.Display All\n"
					+ "2.Search By Account\n"
					+ "3.Deposit\n"
					+ "4.Withdrawal\n"
					+ "5.Delete\n"
					+ "6.Exit");
			System.out.println("The Choice is Yours:");
			ch=RR.nextInt();
			switch(ch) { 
				case 1:
					for(int i=0;i<C.length;i++) {
						C[i].showAccount();
					}
					break;

				case 2:
					System.out.print("Enter Account No. You Want to Search...: ");
					String acn=RR.next();
					boolean found=false;
					for(int i=0;i<C.length;i++) {  
						found=C[i].search(acn);
						if(found) {
							break;
						}
					}
					if(!found) {
						System.out.println("Search Failed..Account doesn't Exist..");
					}
					break;

				case 3:
					System.out.print("Enter Account No. : ");
					acn=RR.next();
					found=false;
					for(int i=0;i<C.length;i++)
					{  
						found=C[i].search(acn);
						if(found)
						{
							C[i].deposit();
							break;
						}
					}
					if(!found)
					{
						System.out.println("Search Failed...Account doesn't Exist..");
					}
					break;

				case 4:
					System.out.print("Enter Account No. : ");
					acn=RR.next();
					found=false;
					for(int i=0;i<C.length;i++)
					{  
						found=C[i].search(acn);
						if(found)
						{
							C[i].withdrawal();
							break;
						}
					}
					if(!found) {
						System.out.println("Search Failed...Account doesn't Exist..");
					}
					break;
				
				case 5:
					System.out.println("If you delete one, you'll delete all! IS THAT OK? If so just exit the database.");
					break;

				case 6:
					System.out.println("This bank will self destruct in 5..4..3..2..1.. GoodBye Sir.. KABOOM!");
					break;
			}
		}
		while(ch!=6);
	}
}