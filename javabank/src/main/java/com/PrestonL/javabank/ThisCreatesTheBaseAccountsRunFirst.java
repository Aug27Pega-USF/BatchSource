package com.PrestonL.javabank;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Scanner;

public class ThisCreatesTheBaseAccountsRunFirst 
{
	static Scanner scanner;
    public static void main( String[] args )
    {
    	scanner = new Scanner(System.in);
    	ArrayList<User> userList = new ArrayList<User>();
    	ArrayList<Customer> customerList = new ArrayList<Customer>();
    	ArrayList<Employee> employeeList = new ArrayList<Employee>();
    	ArrayList<Admin> adminList = new ArrayList<Admin>();
        ArrayList<BankAccount> bankaccountList = new ArrayList<BankAccount>();
        ArrayList<Integer> bankaccountidList = new ArrayList<Integer>();
        ArrayList<Application> applicationList = new ArrayList<Application>();
        
        
    	String filename = "Bank.txt";
    	
        bankaccountList.add(new BankAccount("Joe Schmoe", 12345));
        bankaccountList.add(new BankAccount("Jane Schmee", 12346));
        ArrayList<String> nameList = new ArrayList<String>();
        nameList.add("Joe Schmoe");
        nameList.add("Jane Schmee");
        bankaccountList.add(new BankAccount(nameList, 12348));
    	Customer customer1= new Customer("Joe4", "password", "Joe Schmoe");
    	ArrayList<Integer> customer1BankAccountList= new ArrayList<Integer>();
    	customer1BankAccountList.add(12345);
    	customer1BankAccountList.add(12348);
    	customer1.addAccountList(customer1BankAccountList);
    	ArrayList<Integer> customer2BankAccountList= new ArrayList<Integer>();
    	Customer customer2=	new Customer("Jane5", "pa$$word", "Jane Schmee");
    	customer2BankAccountList.add(12346);
    	customer2BankAccountList.add(12348);
    	customer2.addAccountList(customer2BankAccountList);
    	userList.add(customer1);
    	userList.add(customer2);
    	userList.add(new Employee("Employee1","Employeepassword", "Cist Heffer"));
    	userList.add(new Employee("Employee2","Employeepassword", "Stefan Job"));
    	userList.add(new Employee("Employee3","Employeepassword", "Bob Kemp"));
    	userList.add(new Admin("AdamOverlord", "Adminpassword", "Adam Hawk"));
    	userList.add(new Admin("SeanB", "v3nd%^f2!SYd", "Sean Bishop"));
    	
    	for (int i=0;i!=bankaccountList.size();i++) {
    		bankaccountidList.add(bankaccountList.get(i).getAccountid());
    	}
    	
        for (int i=0; i!=userList.size();i++) {
        	switch(userList.get(i).returnClass()){
        		case "Employee":
        			employeeList.add((Employee) userList.get(i));
        			break;
        		case "Customer":
        			customerList.add((Customer) userList.get(i));
        			break;
        		case "Admin":
        			adminList.add((Admin) userList.get(i));
        			break;
        		default:    		
        	}
        }   	

        //testing here
        
        
        adminList.get(0).delete(12346, customerList, bankaccountList);
        customerList.get(0).apply(bankaccountList, applicationList);
        adminList.get(0).approve(applicationList.get(0).getAccountid(), applicationList, customerList, bankaccountList);
        customerList.get(1).applyjoint(12345, bankaccountList, applicationList);
        customerList.get(0).apply(bankaccountList, applicationList);
        customerList.get(1).applicationjoint(customerList.get(0).getPending().get(0), bankaccountList, applicationList);
        
        
        // Serialization
        try {
 
            // Saving of object in a file
            FileOutputStream file = new FileOutputStream
                                           (filename);
            ObjectOutputStream out = new ObjectOutputStream
                                           (file);
 
            // Method for serialization of object
            out.writeObject(userList);
 
            out.close();
            file.close();
 
            System.out.println("Object has been serialized\n"
                              + "Data before Deserialization.");
            
            System.out.println("Users:");
            for (int i=0; i!=userList.size();i++) {
            System.out.println(userList.get(i).toString());
            }
            System.out.println("Customers:");
            for (int i=0; i!=customerList.size();i++) {
            System.out.println(customerList.get(i).toString());
            }
            System.out.println("Employees:");
            for (int i=0; i!=employeeList.size();i++) {
            System.out.println(employeeList.get(i).toString());
            }
            System.out.println("Admin:");
            for (int i=0; i!=adminList.size();i++) {
            System.out.println(adminList.get(i).toString());
            }
            
        }
 
        catch (IOException ex) {
            System.out.println("IOException is caught");
        }
        try {
        	 
            // Saving of object in a file
            FileOutputStream file = new FileOutputStream
                                           ("Bankaccount.txt");
            ObjectOutputStream out = new ObjectOutputStream
                                           (file);
 
            // Method for serialization of object
            out.writeObject(bankaccountList);
 
            out.close();
            file.close();
            
            file = new FileOutputStream
                    ("Application.txt");
            out = new ObjectOutputStream
                    (file);

            // Method for serialization of object
            out.writeObject(applicationList);

            out.close();
            file.close();            
            
            System.out.println("Bank Account:");
            for (int i=0; i!=bankaccountList.size();i++) {
            System.out.println(bankaccountList.get(i).toString());
            }
            System.out.println("Application:");
            for (int i=0; i!=applicationList.size();i++) {
            System.out.println(applicationList.get(i).toString());
            }
            
        }
 
        catch (IOException ex) {
            System.out.println("IOException is caught");
        }
 
        userList = null;
        employeeList.clear();
        customerList.clear();
        adminList.clear();
        applicationList.clear();
        bankaccountList.clear();
        bankaccountidList.clear();
        
        // Deserialization
        try {
 
            // Reading the object from a file
            FileInputStream file = new FileInputStream
                                         (filename);
            ObjectInputStream in = new ObjectInputStream
                                         (file);
 
            // Method for deserialization of object
            userList = (ArrayList<User>)in.readObject();
 
            in.close();
            file.close();
            
            for (int i=0; i!=userList.size();i++) {
            	switch(userList.get(i).returnClass()){
            		case "Employee":
            			employeeList.add((Employee) userList.get(i));
            			break;
            		case "Customer":
            			customerList.add((Customer) userList.get(i));
            			break;
            		case "Admin":
            			adminList.add((Admin) userList.get(i));
            			break;
            		default:    		
            	}
            }   
            file = new FileInputStream
                    ("Bankaccount.txt");
            in = new ObjectInputStream
                    (file);           
            
            bankaccountList=(ArrayList<BankAccount>)in.readObject();
            in.close();
            file.close();
        	for (int i=0;i!=bankaccountList.size();i++) {
        		bankaccountidList.add(bankaccountList.get(i).getAccountid());
        	}
        	
            file = new FileInputStream
                    ("Application.txt");
            in = new ObjectInputStream
                    (file);           
            
            applicationList=(ArrayList<Application>)in.readObject();
            in.close();
            file.close();
            
            System.out.println("Object has been deserialized\n"
                                + "Data after Deserialization.");
           
            System.out.println("Users:");
            for (int i=0; i!=userList.size();i++) {
            System.out.println(userList.get(i).toString());
            }
            System.out.println("Customers:");
            for (int i=0; i!=customerList.size();i++) {
            System.out.println(customerList.get(i).toString());
            }
            System.out.println("Employees:");
            for (int i=0; i!=employeeList.size();i++) {
            System.out.println(employeeList.get(i).toString());
            }
            
            System.out.println("Admin:");
            for (int i=0; i!=adminList.size();i++) {
            System.out.println(adminList.get(i).toString());
            }
            System.out.println("Bank Account:");
            for (int i=0; i!=bankaccountList.size();i++) {
            System.out.println(bankaccountList.get(i).toString()+" "+ bankaccountidList.get(i).toString());
            }
            System.out.println("Application:");
            for (int i=0; i!=applicationList.size();i++) {
            System.out.println(applicationList.get(i).toString());
            }

            System.out.println(customerList.get(0).customerInfo(bankaccountList));
            System.out.println(employeeList.get(0).viewcustomerinfo(customerList.get(1).getUsername(), customerList, bankaccountList));


        }
 
        catch (IOException ex) {
            System.out.println("IOException is caught");
        }
 
        catch (ClassNotFoundException ex) {
            System.out.println("ClassNotFoundException" +
                                " is caught");
        }
    }
    
}
