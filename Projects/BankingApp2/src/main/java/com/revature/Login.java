package com.revature;
import java.io.File;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Map.Entry;
import com.revature.Serialize;
import com.revature.beans.Customer;
import com.revature.beans.Employee;
import com.revature.beans.User;
/**
* @author Kevin Medara
* @since 09-04-2018
* @Version 2.0
* 
* Holds methods for logging in and creating a user
*/


public class Login {
  
  private static Serialize serializer = new Serialize();//object used to call methods for serializing and deserializing
  private static File customerFile = new File("BankCustomers.txt");
  private static File employeeFile = new File("BankEmployees.txt");
  private static Scanner keyboard = new Scanner(System.in);
  private static User currentUser;
  
  /**
  * Checks Hashmap of users for login info
  * @return the current user
  */
  public static User run() {
    HashMap<Integer, Customer> customerMap = serializer.readFromFile(customerFile);
    HashMap<Integer, Employee> employeeMap = serializer.readFromFile(employeeFile);
    int attemptCount = 0;
    boolean found = false;
    String username="";
    String password="";
    System.out.println("LOGIN PAGE:");
    while(!found) {
      System.out.println("Enter Username: ");
      username = keyboard.nextLine();
      System.out.println("Enter Password: ");
      password = keyboard.nextLine();
      found = checkCredentials(username, password, customerMap, employeeMap);
      if(found) { 
        break;
      } else {
        attemptCount++;
        if(attemptCount == 3) {
          System.out.println("Too many login attempts. Returning to home page.\n"
          + "************************************************");
          Driver.Initialize(customerMap, employeeMap);
        }
      } 
    }
    return currentUser;
  }
  
  /**
  * 
  * Walks user through process of creating a new account
  * Asks for first name, last name, and social security number
  * validates and makes sure it does not contain digits
  * validates SSN with regex 
  * The first three digits are called the area number. The area number cannot be 000, 666, or between 900 and 999.
  * Digits four and five are called the group number and range from 01 to 99.
  * The last four digits are serial numbers from 0001 to 9999.
  * Then asks for a new password, asks a second time to confirm. checks they are equal and asks again if not
  * 
  * EXPLANATION OF REGEX for SSN: 
  * ^            # Assert position at the beginning of the string.
  * (?!000|666)  # Assert that neither "000" nor "666" can be matched here.
  * [0-8]        # Match a digit between 0 and 8.
  * [0-9]{2}     # Match a digit, exactly two times.
  * -            # Match a literal "-".
  * (?!00)       # Assert that "00" cannot be matched here.
  * [0-9]{2}     # Match a digit, exactly two times.
  * -            # Match a literal "-".
  * (?!0000)     # Assert that "0000" cannot be matched here
  * [0-9]{4}     # Match a digit, exactly four times.
  * $            # Assert position at the end of the string.
  */
  public static void createAccount(HashMap<Integer,Customer> customerMap, HashMap<Integer,Employee> employeeMap) {
    Customer newCustomer;
    String fName ="", lName="", social="", password = "", confirmPassword="";
    boolean passwordsMatch = false;
    boolean goodNames = false;
    System.out.println("CREATION PAGE:");
    while(!goodNames) {
      System.out.println("First Name: ");
      fName = keyboard.nextLine();
      System.out.println("Last Name: ");
      lName = keyboard.nextLine();
      if(!fName.matches(".*\\d+.*") && !lName.matches(".*\\d+.*") && fName.length()!=0 && lName.length()!=0){
        goodNames = true;
        break;
      }
      System.out.println("Name is invalid. Try Again\n"
      + "********************************");
    }
    System.out.println("Enter SSN (XXX-XX-XXXX)");
    social = keyboard.nextLine();
    while(!(social.matches("^(?!(000|666|9))\\d{3}-(?!00)\\d{2}-(?!0000)\\d{4}$"))){
      System.out.println("Invalid Social, Try Again.\n"
      + "**************************");
      social = keyboard.nextLine();
    }
    String usnDigits = social.replace("-","");
    usnDigits = (usnDigits.substring(1, 2) + usnDigits.charAt(4) + usnDigits.charAt(6) + usnDigits.charAt(8));
    fName = fName.substring(0, 1).toUpperCase() + fName.substring(1);
    lName = lName.substring(0, 1).toUpperCase() + lName.substring(1);
    String username = lName + fName.substring(0,1) +usnDigits ; //builds username out of name and social
    if(userExists(username, customerMap, employeeMap)) {
      System.out.println("User already exists. Sending to login\n*************************************");
      Driver.Initialize(customerMap, employeeMap);
    }
    while(!passwordsMatch) {
      System.out.println("Please Enter your preferred password.");
      password = keyboard.next();
      System.out.println("Please Confirm your password.");
      confirmPassword = keyboard.next();
      if(password.equals(confirmPassword)) {
        passwordsMatch = true;
        break;
      }
      System.out.println("Passwords do not match.\n"
      + "***********************");
    }
    System.out.println("Your new username is: "+username+"\nThank you for joining Bank of Medarica!\n"
    + "***********************************************************************");
    newCustomer = new Customer(fName,lName,username,password,social);
    System.out.println(newCustomer);
    customerMap.put(newCustomer.getIDNumber(), newCustomer);
    serializer.writeToFile(customerMap, customerFile);	
    
  }
  
  /**
  * Checks if username exists in given map
  * 
  * @param username Username to check the existence of
  * @param userMap Map to check for username in
  * @return boolean True if user exists, false if not 
  */
  private static boolean userExists(String username,  HashMap<?,?> customerMap, HashMap<?,?> employeeMap) {
    boolean found = false;
    for(Entry<?, ?> e : customerMap.entrySet()) {
      if(((Customer)e.getValue()).getUsername().equals(username)){
        found = true;
        break;
      }
    }
    for(Entry<?,?> e : employeeMap.entrySet()) {
      if(((Employee)e.getValue()).getUsername().equals(username)){
        found = true;
        break;
      }
    }
    return found;
  }
  
  /**
  * If credentials match a user, sets currentUser to that user in the map
  * @param username - username to check for in combination with password
  * @param password - password to check for in combination with username
  * @param userMap - map to search for credentials of each object
  * @return - True if user passes validation, false if user does not
  */
  private static boolean checkCredentials(String username, String password,HashMap<?,?> customerMap, HashMap<?,?> employeeMap){
    for(Entry<?, ?> c : customerMap.entrySet()) {
      Customer b = (Customer) ((Customer)c.getValue()).getValue();
      if(b.getUsername().equals(username) && b.getPassword().equals(password)) {
        currentUser = b;
        return true;
      }
    }
    for(Entry<?,?> e : employeeMap.entrySet() ) {
      Employee t = (Employee) ((Employee)e.getValue()).getValue();
      if(t.getUsername().equals(username) && t.getPassword().equals(password)) {
        currentUser = t;
        return true;
      } 
    }
    System.out.println("There was a problem with your credentials. Try again.\n"
    + "*******************************************");
    return false;
    
  }
}
