package com.revature.HW1;

public class Question4 {

    // method to find factorial of given number
    static int factorial(int n)
    {
        if (n == 0)
          return 1;
          
        return n*factorial(n-1);
    }
      
    // Driver method
    public static void main(String[] args)
    {
        int num = 2; //can change this variable to any number greater than 0
        System.out.println("Factorial of "+ num + " is " + factorial(2));
	}

}
