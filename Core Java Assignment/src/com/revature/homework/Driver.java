package com.revature.homework;

import java.io.FileNotFoundException;
import java.util.*;

//These are my answers to the Core Java homework assignment for Week 1, August 27th, 2018. 

public class Driver {
	// Driver method to test all the homework problems.
    public static void main(String args[]) throws FileNotFoundException
    {
    	/*
    	System.out.println("This is Julian Welborn's code for Core Java Assignment. :)\n");
    	//First hw problem
        Q1 sorted = new Q1();
        int arr[] = {1, 0, 5, 6, 3, 2, 3, 7, 9, 8, 4};
        sorted.bubbleSort(arr);
        
        //Second hw problem
        Q2 sequence = new Q2();
        sequence.fibonacci(25);
        
        //Third hw problem
        Q3 reversed = new Q3();
        reversed.reverseString("Julian");
        
        //Fourth hw problem
        Q4 exclamation = new Q4();
        exclamation.factorial(10);
        
        //Fifth hw problem
        Q5 partial = new Q5();
        String solved = partial.substring("welcome", 5);
        System.out.println(solved);
        System.out.println();
        
        //Sixth hw problem
        Q6 number = new Q6();
        number.isEven(17);
        
        //Seventh hw problem
        Q7 employees = new Q7();
        employees.compareEmployees();
        
        //Eighth hw problem
        Q8 palindromes = new Q8();
        ArrayList<String> wordlist = new ArrayList<String>();
        wordlist.add("karan");
        wordlist.add("madam");
        wordlist.add("tom");
        wordlist.add("civic");
        wordlist.add("radar");
        wordlist.add("jimmy");
        wordlist.add("kayak");
        wordlist.add("john");
        wordlist.add("refer");
        wordlist.add("billy");
        wordlist.add("did");

        palindromes.sortPalin(wordlist);
        
        //Ninth hw problem
        Q9 primes = new Q9();
        primes.showPrimes();
        
        //Tenth hw problem
        Q10 ternary = new Q10();
        ternary.minNum(40, 10);
        
        //Eleventh hw problem
        Q11 floats = new Q11();
        floats.printFloats();
        
        //Twelfth hw problem
        Q12 evens = new Q12();
        evens.evenList();
        
        //Thirteenth hw problem
        Q13 triangle = new Q13();
        triangle.display(4);
        
        //Fourteenth hw problem
        Q14 nintendo = new Q14();
        nintendo.switchCases(3);
        
        //Fifteenth hw problem
        Q15 calculator = new Q15();
        System.out.println("\nQ15: Using a calc interface to add, subtract, multiply, and divide.");
        calculator.addition();
        calculator.subtraction();
        calculator.multiplication();
        calculator.division();
        
        //Sixteenth hw problem
        System.out.println("\nQ16: Number of characters in a command line argument string.");
        for (int i = 0; i < args.length; i++) {
            System.out.println("String '"+ args[i].toString() +"' length is: " + args[i].length());
        }
        
        //Seventeenth hw problem
        Q17 interest = new Q17();
        interest.calculateInterest();
        
        //Eighteenth hw problem
        Q18 concrete = new Q18();
        System.out.println("\nQ18: Testing different strings for uppercase chars, "
        		+ "changing lowercase to uppercase, and adding to a string turned int.");
        String str1 = "This is a test String.";
        String str2 = "This is test string Two.";
        String str3 = "6942";
        System.out.println("Does the string '" + str1 + "' contain an uppercase char? " + concrete.hasUpper(str1));
        System.out.println("Changing the string '" + str2 + "' to uppercase: "+ concrete.lowerToUpper(str2));
        System.out.println("Converting the string '" + str3 + "' to int and adding 10: " + concrete.stringToInt(str3));
        
        //Nineteenth hw problem
        Q19 funList = new Q19();
        funList.intList();
        
        //Twentieth hw problem
        Q20 readFile = new Q20();
        readFile.readTxtFile();
        
        System.out.println("Thanks for checking out my homework. :D");
        */
    	
        Scanner scan = new Scanner(System.in);
        String str = "Matt's career ";
        int grade;
        //int[] a = {1,2,3,4,5,6,7,8,9,10};
        boolean exit = true;
        do {
            System.out.println("Please enter either 1, 2, or 0.");
            int choice = scan.nextInt();
            switch(choice) {
            case 1:
                System.out.println("for loop:");
                System.out.println("Enter a number:");
                int num = scan.nextInt();
                for(int i = 0; i <= num; i++) {
                	System.out.println("i is now " + i);
                }
                break;
            case 2:
                System.out.println("if statement");
                System.out.println("Enter a grade number:");
                grade = scan.nextInt();
                if(grade == 0)
                {
                	System.out.println(str + " is totally dead.");
                }
                else
                {
                	System.out.println(str + " might have a chance.");
                }
                break;
            case 0:
            	System.out.println("Leaving program now.");
            	exit = false;
            }
        } while(exit);
        scan.close();    
    }
}