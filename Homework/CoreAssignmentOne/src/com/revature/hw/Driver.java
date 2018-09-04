package com.revature.hw;

import java.util.*;
import com.revature.beans.*;

public class Driver {
  
  /*
  * Most of the variables for questions are defined here
  */
  
  static ArrayList<Integer> integerList = new ArrayList<Integer>();
  static ArrayList<Integer> primeList = new ArrayList<Integer>();
  
  static Scanner scan = new Scanner(System.in);
  static Scanner scan2 = new Scanner(System.in);
  static int arr[] = {1,0,5,6,3,2,3,7,9,8,4}; //array to bubble sort
  static int myInt; //myInt is used for the substring  problem, checking even numbers, and the switch case
  static int num1,num2; //used for finding min
  static int hardInt1 = 21;
  static int hardInt2 = 45;
  static int nLines = 4; //for triangle print
  static Q18Child Q18Object = new Q18Child(); //subClass object that extends Abstract class
  static int intArray[] = new int[100];
  static Q15 customArithmetic = new Q15();//UsesCustom Math implements the CustomMath Interface (Q15)
  
  public static void main(String[] args) {
    
	  
    
    System.out.println("** Question 1: Bubble Sort an int array **");
    System.out.print("Array Before bubble sort: " );
    printIntArray(arr);
    System.out.print("\nArray After Bubble Sort: ");
    printIntArray(Q1.bubbleSort(arr));
    System.out.println();
    
    System.out.println("\n** Question 2: Display first 25 Fibonacci Numbers starting from 0 **");
    Q2.fibonacci(25);
    System.out.println();
    
    System.out.println("\n** Question 3: Enter A String And Reverse The String **");
    String myString = scan.nextLine();
    System.out.print(myString +" --> " + Q3.reverseString(myString));
    System.out.println();
    
    System.out.println("\n** Question 4: Enter a Number and Compute the Factorial **");
    try {
      myInt = scan.nextInt();
      System.out.println(myInt +" Factorial: " + Q4.nFactorial(myInt));
    }
    catch(InputMismatchException e){
      System.out.println("Error: Nice Try Idiot");
    }
    
    System.out.println("\n** Question 5: Substring method that returns substring contained between 0 and idx-1. **");
    System.out.println("Enter A String");
    String newString = scan2.nextLine();
    System.out.println("Enter an integer");
    myInt = scan2.nextInt();
    System.out.println(Q5.findSubString(newString,myInt));
    
    System.out.println("\n** Question 6: Enter a Number And Determine if number is even w/out Modulo **");
    try {
      myInt = scan.nextInt();
      System.out.println("Is "+myInt+" "+ "even? " + Q6.isEven(myInt));
    }
    catch(InputMismatchException e){
      System.out.println("Nice Try Idiot");
    }
    
    System.out.println("\n** Question 7: Compare two employees by name, age, and department");
    Q7.sortAndPrint();
    
    System.out.println("\n** Question 8: Store Strings in an arrayList and palindromes in another arrayList **");
    Q8.populateList();
    System.out.println("Originals\n**********\n"+Q8.toPalindrome+"\n");
    System.out.println("Palindromes\n***********");
    System.out.println(Q8.getPalindromes());
    
    System.out.println("\n** Question 9: Create an ArrayList that stores 1-100 and prints the prime numbers to console **");
    integerList = Q9.numberList();
    System.out.println(integerList);
    primeList = Q9.createPrimeList(integerList);
    System.out.println(primeList);
    
    System.out.println("\n** Question 10: Find the Mininum of two numbers using ternary operators **");
    try {
      System.out.println("Enter an Integer");
      num1 = scan2.nextInt();
      System.out.println("Enter Another Integer");
      num2 = scan2.nextInt();
    } catch(InputMismatchException e) {
      System.out.println("Input is not a number");
    }
    System.out.println("Minimum of " +num1+" and "+ num2+": " + Q10.findMin(num1,num2)); 
    
    System.out.println("\n** Question 11: Access two float variables from a class in another package **");
    System.out.println("Float 1: " + Q11.getFloat1() + "\nFloat 2: " + Q11.getFloat2());
    
    System.out.println("\n** Question 12: Create Array w/ number 1-100, print evens using enhanced FOR");
    intArray = Q12.fillIntArray(1,100);
    Q12.printWithAdvancedFor(intArray); 
    System.out.println();
    
    System.out.println("\n** Question 13: Display the triangle in console using any loop, not using group of prints **");
    Q13.printTriangle(nLines); 
    
    System.out.println("\n** Question 14: demonstrates the switch case. Implement the specified functionalities in the cases. Gives 3 opportunities **");
    System.out.println("Enter A Number To Choose\n1) to find the sqrt\n2) to display todays date\n3) to split the specified string");
    myInt = scan2.nextInt();
    Q14.displayCase(myInt);
    System.out.println("Enter 1,2, or 3 to check case");
    myInt = scan2.nextInt();
    Q14.displayCase(myInt);
    System.out.println("Enter 1,2, or 3 to check case");
    myInt = scan2.nextInt();
    Q14.displayCase(myInt);
    
    System.out.println("\n** Question 15: Created interface 'CustomMath' implemented by 'UsesCustomMath'. The Driver creates an object and calls implementing class ** ");
    System.out.println("Addition of " +num1+" and "+num2+ ": " +customArithmetic.addition(hardInt1, hardInt2));
    System.out.println("Subtract " +num1+" from "+num2+ ": " +customArithmetic.subtraction(hardInt1, hardInt2));
    System.out.println("Multiply " +num1+" by "+num2+ ": " +customArithmetic.multiplication(hardInt1, hardInt2));
    System.out.println("Divide " +num1+" by "+num2+ ": " +customArithmetic.division(hardInt1, hardInt2));
    
    System.out.println("\n** Question 16: display the number of characters for a string input. The string should be entered as a command line argument using (String [ ] args). **");
    // use command "java -cp ./bin;. com.revature.hw.Driver" from project folder because CLASSPATH was not set(to run from cmd)
    Q16.printCommandArgs(args);
    
    
    System.out.println("\n** Question 17: Calculates the simple interest on the principal, rate of interest and number of years provided by the user."
    + "Enter principal, rate and time through the console using the Scanner class. Interest = Principal* Rate* Time **");
    System.out.println("The Interest on this loan will be: " +Q17.simpleInterest());
    
    System.out.println("\n** Question 18: Write a program having a concrete ;subclass that inherits three abstract methods from a superclass. "
    + " Provide the following three implementations in the subclass corresponding to the abstract methods in the superclass: **");
    System.out.println("Enter A String to check for uppercase letters");
    String string = scan2.nextLine();
    System.out.println(" -String '"+string+" Contains an uppercase? " + Q18Object.checkUpper(string));
    System.out.println(" -Convert lowercase in '"+string+"' to uppercase: " + Q18Object.convertLowerToUpper(string));
    System.out.println(" -Convert '12345' to integer and add 10: " + Q18Object.convertStringToInt("12345"));
    
    
    System.out.println("\n** Question 19: Create an ArrayList and insert integers 1 through 10. "
    + "Display the ArrayList. Add all the even numbers up and display the result. "
    + "Add all the odd numbers up and display the result. "
    + "Remove the prime numbers from the ArrayList and print out the remaining ArrayList. **");
    ArrayList<Integer> integerList = new ArrayList<Integer>();
    Q19.addIntegersToArrayList(integerList,10);
    System.out.println("ArrayList of Integers 1-10: " + integerList );
    System.out.println("Sum of Evens in ArrayList: " + Q19.sumEvens(integerList));
    System.out.println("Sum of Odds in ArrayList: " + Q19.sumOdds(integerList));
    System.out.println("List with primes Removed: " + Q19.removePrimes(integerList)); 
    
    
    System.out.println("\n** Question 20: Create a notepad file called Data.txt and enter lines delimited by colons (Mickey:Mouse:35:Arizona). "
    + "Print to screen in specified format");
    Q20.readAndFormat();
    
  }
  
  //function to print ArrayList
  public static void printArrayList(ArrayList<?> list) {
    for(Object x : list) {
      System.out.print(x.toString() + "\n");
    }
    System.out.println();
  }
  
  //function to print int array
  public static void printIntArray(int[] arr) {
    for(int x : arr) {
      System.out.print(" " + x);
    }
  }
}
