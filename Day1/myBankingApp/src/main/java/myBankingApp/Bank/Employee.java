package myBankingApp.Bank;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Scanner;

public class Employee implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 9209514409853278599L;
	
	private String firstName;
	private String lastName;
	private String fullName;
	private String username;
	private String password;
	// perhaps implement a employeeID number...?
	
	// CONSTRUCTOR
	public Employee(String firstName, String lastName, String username, String password) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.fullName = firstName + ":" + lastName;
		this.username = username;
		this.password = password;
	}

	
	// OTHER METHODS
	public boolean viewCustomerInfo(Scanner SC, ArrayList<Customer>customerList) {
		// Find customer in list
		System.out.println("You are trying to view customer information. Let's find the customer!");
		System.out.println("Please enter the first name of the customer. ");
		String fN = SC.nextLine();
		System.out.println("Please enter the last name of the customer. ");
		String lN = SC.nextLine();
		
		Customer customer = getCustomer(fN,lN,customerList);
		if(customer == null)
			return false;
		
		System.out.println(customer.toString());
		return true;
	}
	
	public boolean manageOpenAppsForAccounts(Scanner SC, ArrayList<Account>openApps) {
		
		if(openApps.isEmpty()) {
			System.out.println("There are no applications to approve or deny.\n ");
			return false;
		}
		System.out.println("You are now approving or denying open applications for accounts.");
		
		for(Account A: openApps) {
			System.out.println(A + "\n");
			System.out.println("Please enter: \n '1' to APPROVE\n '2' to DENY\n 'Q' to QUIT");
			String x = SC.nextLine();
			if(x.length() == 1) {
				if(x.equals("Q")) {
					return false;
				}
				try {
					int X = Integer.valueOf(x);
					switch(X) {
					case 1:
						// Maybe there is a need to go to every account holder's object and change the status manually
						// just in case people have applied for joint accounts and the references to the account have
						// not been updated.
						A.changeStatusToACTIVE();
						System.out.println("The following account has been successfully ACTIVATED:\n" + A);
						//openApps.remove(A);
						break;
					case 2:
						// Maybe there is a need to go to every account holder's object and change the status manually
						// just in case people have applied for joint accounts and the references to the account have
						// not been updated.
						A.changeStatusToCLOSED();
						System.out.println("The following account has been successfully CLOSED:\n" + A);
						//openApps.remove(A);
						break;
					default:
						System.out.println("ERROR - Your input was invalid. Please try again");
						System.out.println();
						break;
					}
				} catch(NumberFormatException e){
					System.out.println("ERROR - Your input was invalid. Please try again");
					System.out.println();
				}
			}
			else {
				System.out.println("ERROR - Your input was invalid. Please try again");
				System.out.println();
			}
		}
		return true;
	}
	
	
	
	
	
	
	
	
	// SEARCH METHODS
	public Customer getCustomer(String fName, String lName, int customerID, ArrayList<Customer>customerList) {
		for(Customer C:customerList) {
			if(C.getFirstName().equals(fName) && C.getLastName().equals(lName) && C.getCustomerID() == customerID)
				return C;
		}
		System.out.println("ERROR - Customer with name: " + fName + " " + lName + " customerID: "+ customerID +" CANNOT be found.");
		return null;
	}
	public Customer getCustomer(String fName, String lName, ArrayList<Customer>customerList) {
		for(Customer C:customerList) {
			if(C.getFirstName().equals(fName) && C.getLastName().equals(lName) )
				return C;
		}
		System.out.println("ERROR - Customer with name: " + fName + " " + lName + " CANNOT be found.");
		return null;
	}
	public Customer getCustomer(int customerID, ArrayList<Customer>customerList) {
		for(Customer C:customerList) {
			if(C.getCustomerID() == customerID )
				return C;
		}
		System.out.println("ERROR - Customer with customerID: " + customerID +" CANNOT be found.");
		return null;
	}
	
	
	// GETTERS AND SETTERS
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "Employee [firstName=" + firstName + ", lastName=" + lastName + ", username=" + username + ", password="
				+ password + "]";
	}
	

	
	
	
}
