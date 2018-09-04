package com.revature;

import java.io.File;
import java.util.List;
import java.util.Scanner;

import com.revature.beans.BankUser;
import com.revature.beans.Customer;

public class Login {
  private static Serialize serializer = new Serialize();
  private static File userFile = new File("BankUsers.txt");//File with bank user info
  private static Scanner keyboard = new Scanner(System.in);
  private static BankUser currentUser;
  
  protected static BankUser run() {
    boolean found = false;
    List<BankUser> list = serializer.readFromFile(userFile);
    while(!found) {
      System.out.println("LOGIN PAGE:");
      System.out.println("Enter Username: ");
      String username = keyboard.nextLine();
      System.out.println("Enter Password: ");
      String password = keyboard.nextLine();
      for(BankUser s : list) {
        if(s.getUsername().equals(username) && s.getPassword().equals(password)) {
          found = true;
          currentUser = s;
          break;
        }
      }
      if(!found) {
        System.out.println("There was a problem with your credentials.");
      }
    }
    return currentUser;
  }
  
  protected static void createAccount() {
    BankUser newUser;
    List<BankUser> users = serializer.readFromFile(userFile);
    boolean passwordsMatch =false;
    String password = null;
    System.out.println("CREATION PAGE:");
    System.out.println("First Name: ");
    String fName = keyboard.next();
    System.out.println("Last Name: ");
    String lName = keyboard.next();
    fName = fName.substring(0, 1).toUpperCase() + fName.substring(1);
    lName = lName.substring(0, 1).toUpperCase() + lName.substring(1);
    String username = lName + fName.substring(0,1);
    for(BankUser s : users ) {
      if(s.getUsername().equalsIgnoreCase(username)) {
        System.out.println("User Already Exists. Sending to login.");
        run();
        return;
      }  
    }
    while(!passwordsMatch) {
      System.out.println("Username: " + username);
      System.out.println("Please Enter your preferred password.");
      String password1 = keyboard.next();
      System.out.println("Please Confirm your password.");
      String confirmPassword = keyboard.next();
      if(password1.equals(confirmPassword)) {
        passwordsMatch = true;
        break;
      }
      System.out.println("Passwords do not match.\n");
    }
    newUser = new Customer(fName,lName,username,password);
    users.add(newUser);
    serializer.writeToFile(users, userFile);	
    System.out.println("New User Created.\n");
    Driver.Initialize();
  }
}
