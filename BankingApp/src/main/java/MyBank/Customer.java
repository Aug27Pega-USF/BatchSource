package MyBank;

import java.util.Scanner;

public class Customer

{

	public static String userName;
	public static String password;
	int userChoice;
	boolean quit = false;
	Scanner in = new Scanner(System.in);

	
    //make an instance of the account 
	Account one = new Account();
	
	public Customer (String userName, String password)
	{
		this.userName = userName;
		this.password = password;
	}
	
	void displayInfo()
	{
		System.out.println("Account User: " + userName);
		System.out.println("Account Number: " + one.acc_num);
		System.out.println("Account Balance: " + one.acc_balance);
	}
	void CustomerOptions()
	{
		System.out.println("1. Create Account");
		System.out.println("2. Desposit money");
		System.out.println("3. Withdraw money");
		System.out.println("4. Check Balance");
		System.out.println("5. Display Account Details");
		System.out.println("0. to quit \n");
		System.out.println("Enter your Choice: ");
		userChoice = in.nextInt();
		
	
		switch (userChoice) 
		{
			case 1: 
				System.out.println("Create a UserName: ");
				userName = in.nextLine();
			
				System.out.println("Create a Password: ");
				password = in.nextLine();
		
				one.createAcc();
                break;
                
			case 2: // deposit
				
             System.out.print("Enter Amount Of Money : ");
             int amount = in.nextInt();
             one.deposit(amount);
             System.out.println("\t Successfully Deposited.");	
                       
                break;
                  
			 case 3: // withdraw money                      
                   
                if(one.acc_balance==0)
                System.out.print("Your Account is Empty.");
                         
                     
                System.out.print("Enter Amout Of Money : ");   
                int withd = in.nextInt();  
                        
				if(withd>one.acc_balance)
				{
                   System.out.print("Enter Valid Amout of Money : ");
                   withd=in.nextInt();
				}
                        
                 one.withdraw(withd);  
                
			 case 4: // check balance 
                  one.checkBal();                       
                  break;    
                 
			 case 5: //display all bank info
				 one.display();
				 break;
				 
			 case 0:
				 quit = true;
				 break;
				 
			default: 
				System.out.println("Wrong Choice, Try again.");
				break;
		
			}
			
		}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
