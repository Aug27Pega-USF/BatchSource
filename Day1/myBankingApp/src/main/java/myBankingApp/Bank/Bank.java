package myBankingApp.Bank;

import java.io.Serializable;
import java.util.ArrayList;

public class Bank implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 2284291715413389107L;
	
	// FIELDS
	public ArrayList<Customer> customerList; 
	public ArrayList<Employee> employeeList;
	public ArrayList<BankAdmin> bankAdminList; 
	public ArrayList<Long> accountIDList;
	public ArrayList<Long> customerIDList;
	public ArrayList<Account> openAccountApplications;

	//	CONSTRUCTOR 
	public Bank() {
		customerList = new ArrayList<Customer>();
		employeeList = new ArrayList<Employee>();
		bankAdminList = new ArrayList<BankAdmin>();
		accountIDList = new ArrayList<Long>();
		customerIDList = new ArrayList<Long>();
		openAccountApplications= new ArrayList<Account>();
	}
	
	
	// OTHER METHODS
	public boolean updateOpenAccApps() {
		for(int i = 0; i < openAccountApplications.size(); i++) {
		Account A = openAccountApplications.get(i);
			if(A.getStat() == Status.ACTIVE || A.getStat() == Status.CLOSED) {
				openAccountApplications.remove(A);
				i = -1;
			}
		}
		return true;
	}
	
	
	// CUSTOMER LIST SEARCH METHODS
	// 'getCustomer' returns the customer object it was looking for
	public Customer getCustomer(String firstName, String lastName, int customerID) {
		for(Customer C:customerList) {
			if(C.getFirstName().equals(firstName) && C.getLastName().equals(lastName) && C.getCustomerID() == customerID)
				return C;
		}
		return null;
	}
	public Customer getCustomer(String username, String password) {
		for(Customer C:customerList) {
			if(C.getUsername().equals(username) && C.getPassword().equals(password) )
				return C;
		}
		return null;
	}
	public Customer getCustomer(String username) {
		for(Customer C:customerList) {
			if(C.getUsername().equals(username) )
				return C;
		}
		return null;
	}
	public Customer getCustomer(int customerID) {
		for(Customer C:customerList) {
			if(C.getCustomerID() == customerID )
				return C;
		}
		return null;
	}
	// EMPLOYEE LIST SEARCH METHODS
	public Employee getEmployee(String username, String password) {
		for(Employee E:employeeList) {
			if(E.getUsername().equals(username) && E.getPassword().equals(password))
				return E;
		}
		return null;
	}
	
	// Perhaps there is a need to include a list method that searches for the employeeID...?
	//	BANK ADMIN SEARCH METHODS
	public BankAdmin getBankAdmin(String username, String password) {
		for(BankAdmin BA:bankAdminList) {
			if(BA.getUsername().equals(username) && BA.getPassword().equals(password) )
				return BA;
		}
		return null;
	}	
}
