package com.driver.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;

import com.driver.accounts.Admin;
import com.driver.accounts.Customer;
import com.driver.accounts.Employee;


public class IO {
	//file we are reading and writing to/from

	private static final String CustomerFile = "Customers.txt";
	private static final String EmployeeFile = "Employee.txt";
	private static final String AdminFile = "Admin.txt";
	
	static public ArrayList<Customer> customerList = new ArrayList<Customer>();
	static public ArrayList<Employee> employeeList = new ArrayList<Employee>();
	static public ArrayList<Admin> adminList = new ArrayList<Admin>();
	
	
	public static void writeFile(String contents, String IDFile) {
		OutputStream os = null;
		File file = new File(IDFile);
		file.delete();
		
		try {
			file.createNewFile();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		
		if(file.exists()) {
			//exception for file not being found, so we need these
			try {
				os = new FileOutputStream(file, true);
				os.write(contents.getBytes()); //another exception for the io stream
				
			} catch (FileNotFoundException e) {
				e.printStackTrace();
				
			} catch (IOException e) {
				e.printStackTrace();
			}
			
			//have to close it now!
			if(os != null) {
				try {
					os.close();
				}
				catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	public static String readFile(String IDFile) {
		
		//get the file
		InputStream is = null;
		File file = new File(IDFile);
		StringBuilder s = new StringBuilder();
		
		try {
			is = new FileInputStream(file); //typed this, gave us a try/catch error, imported that
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		
		//part that reads the file saving it to the StringBuilder
		int b = 0;
		if(is != null) {
			try {
				while(( b=is.read()) != -1) {
					char c = (char)b;
					s.append(c); //put it at the end of the StringBuilder
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		//Close the file
		if(is != null) {
			try {
				is.close(); //typed this, gave us a try/catch error, imported that
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		//if nothing is there, append a 0
		if(is == null) 
			s.append('0');
		//Return the string we just read
		
		return s.toString();
	}
	
	public static void writeCustomerFile(ArrayList<Customer> customerList) {
		try {
			ObjectOutputStream objectOut =
				new ObjectOutputStream(new FileOutputStream(CustomerFile));
			objectOut.writeObject(customerList);
			objectOut.close();
		} catch (FileNotFoundException e){
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void writeEmployeeFile(ArrayList<Employee> employeeList) {
		try {
			ObjectOutputStream objectOut =
				new ObjectOutputStream(new FileOutputStream(EmployeeFile));
			objectOut.writeObject(employeeList);
			objectOut.close();
		} catch (FileNotFoundException e){
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void writeAdminFile(ArrayList<Admin> adminList) {
		try {
			ObjectOutputStream objectOut =
				new ObjectOutputStream(new FileOutputStream(AdminFile));
			objectOut.writeObject(adminList);
			objectOut.close();
		} catch (FileNotFoundException e){
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static ArrayList<Customer> readCustomerFile() {
		try {
			ObjectInputStream objectIn;
			objectIn = new ObjectInputStream( new FileInputStream(CustomerFile));
			customerList = (ArrayList<Customer>)objectIn.readObject();
			objectIn.close();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return customerList;
	}
	
	public static ArrayList<Employee> readEmployeeFile() {
		try {
			//open the stream
			ObjectInputStream objectIn;
			objectIn = new ObjectInputStream( new FileInputStream(EmployeeFile));
			//cast into the array
			employeeList = (ArrayList<Employee>)objectIn.readObject();
			objectIn.close();
		//error catches	
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		//return array info
		return employeeList;
	}
	
	public static ArrayList<Admin> readAdminFile() {
		try {
			ObjectInputStream objectIn;
			objectIn = new ObjectInputStream( new FileInputStream(AdminFile));
			adminList = (ArrayList<Admin>)objectIn.readObject();
			objectIn.close();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return adminList;
	}

}