package com.revature.driver;

import java.sql.SQLException;
import java.util.*;
import com.revature.DAOImpl.UserAccountDAOImpl;

public class Driver {

    private static int userID;
    private static String userName;
    private static String pass;
    private static int  adminn;
    
    
    public static int returnRandom(ArrayList al)
    {
        double x = Math.random();
        x = x * 10;
        if (al.contains(x))
            {
                returnRandom(al);
            }else {
            return (int) x;
        }
        return returnRandom(al);
    }

    

    public static void main(String[] args) {
        /*********************************
         * Admin flags
         ********************************/
        int adminn = 0;
        /*********************************
         * User ID Generator
         ********************************/
       ArrayList al = new ArrayList();
       int userID = 0;
       for (int i = 0; i < 5; i++)
       {
           userID = returnRandom(al);
       }

        Scanner scanner = new Scanner(System.in);
        /*********************************
         * User login check
         * and prompting user
         ********************************/
        
        /*System.out.println("Press 1 to login");
        System.out.println("press any Number to create acount");
        int login = scanner.nextInt();
         */
        
        System.out.println("Create your user name");
        String userName = scanner.nextLine();
        
        System.out.println("Create your user password");
        String pass = scanner.nextLine();
        
        System.out.println("your user ID is: "+ userID);
        
        UserAccountDAOImpl shd = new UserAccountDAOImpl();
        try {
            shd.createUserAccount(userID, userName, pass, adminn);
            
            System.out.println(shd.getUserAccountList().toString());
        }catch (SQLException e) {
            e.printStackTrace();
        }
        //System.out.println("Press 0  to exit");
         //login = scanner.nextInt();
    }
}

