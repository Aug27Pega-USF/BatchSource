package com.revature.hw;

import java.io.File;
import java.io.FileNotFoundException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;
import com.revature.beans.*;

public class Driver {
  
  /*
  * Most of the variables for questions are defined here
  */
  static int arr[] = {1,0,5,6,3,2,3,7,9,8,4}; //array to bubble sort
  static String myString = "Roll Tide I Guess"; //starts as this but is changed here and there based on user input
  static int myInt; //myInt is used for the substring  problem, checking even numbers, and the switch case
  static int num1, num2; //used for finding the minimum as well as custom Arithmetic
  static int nLines = 4; //for triangle print
  static Employee emp1 = new Employee("David",36, "Human Resources");
  static Employee emp2 = new Employee("Matt", 32, "Training");
  static Scanner scan = new Scanner(System.in);
  static Scanner scan2 = new Scanner(System.in);
  static ArrayList<Employee> employeeList = new ArrayList<Employee>();
  static ArrayList<String> toPalindrome = new ArrayList<String>();
  static ArrayList<Integer> integerList = new ArrayList<Integer>();
  static ArrayList<Integer> primeList = new ArrayList<Integer>();
  static int intArray[] = new int[100];
  
  public static void main(String[] args) throws InterruptedException {
    
    bubbleSort(arr);
    System.out.println("** Question 1: Bubble Sort an int array **");
    printIntArray(arr);
    System.out.println();
    
    System.out.println("\n** Question 2: Display first 25 Fibonacci Numbers starting from 0 **");
    fibonacci(25);
    System.out.println();
    
    System.out.println("\n** Question 3: Enter A String And Reverse The String **");
    myString = scan.nextLine();
    System.out.print(myString +" --> " + reverseString(myString));
    System.out.println();
    
    System.out.println("\n** Question 4: Enter a Number and Compute the Factorial **");
    try {
      myInt = scan.nextInt();
      System.out.println(myInt +" Factorial: " +nFactorial(myInt));
    }
    catch(InputMismatchException e){
      System.out.println("Error: Nice Try Idiot");
    }
    
    System.out.println("\n** Question 5: Substring method that returns substring contained between 0 and idx-1. **");
    System.out.println("Enter A String");
    String newString = scan2.nextLine();
    System.out.println("Enter an integer");
    myInt = scan2.nextInt();
    System.out.println(findSubString(newString,myInt));
    
    System.out.println("\n** Question 6: Enter a Number And Determine if number is even w/out Modulo **");
    try {
      myInt = scan.nextInt();
      System.out.println("Is "+myInt+" "+ "even? " + isEven(myInt));
    }
    catch(InputMismatchException e){
      System.out.println("Nice Try Idiot");
    }
    
    System.out.println("\n** Question 7: Compare two employees by name, age, and department");
    employeeList.add(emp1);
    employeeList.add(emp2);
    System.out.println("Sorted By Name: "+ "\n***************");
    Collections.sort(employeeList, Employee.NameComparator);
    printArrayList(employeeList);
    System.out.println("Sorted By Age: " + "\n***************");
    Collections.sort(employeeList, Employee.AgeComparator);
    printArrayList(employeeList);
    System.out.println("Sorted By Department: "+ "\n***************");
    Collections.sort(employeeList, Employee.DepartmentComparator);
    printArrayList(employeeList);
    
    System.out.println("\n** Question 8: Store Strings in an arrayList and palindromes in another arrayList **");
    populateList(toPalindrome);
    System.out.println("Originals\n**********\n"+toPalindrome+"\n");
    toPalindrome = getPalindrome(toPalindrome);
    System.out.println("Palindromes\n***********\n"+ toPalindrome);
    
    System.out.println("\n** Question 9: Create an ArrayList that stores 1-100 and prints the prime numbers to console **");
    integerList = numberList();
    primeList = createPrimeList(integerList);
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
    System.out.println("Minimum of " +num1+" and "+ num2+": " + findMin(num1,num2)); 
    
    System.out.println("\n** Question 11: Access two float variables from a class in another package **");
    System.out.println("Float 1: " + Floats.getFloat1() + "\nFloat 2: " + Floats.getFloat2());
    
    System.out.println("\n** Question 12: Create Array w/ number 1-100, print evens using enhanced FOR");
    intArray = fillIntArray(1,100);
    for(int x : intArray) { if(isEven(x)) { System.out.print(x + " "); } } //enhanced for prints evens w/ isEven function
    System.out.println();
    
    System.out.println("\n** Question 13: Display the triangle in console using any loop, not using group of prints **");
    printTriangle(nLines); 
    
    System.out.println("\n** Question 14: demonstrates the switch case. Implement the specified functionalities in the cases. Gives 3 opportunities **");
    System.out.println("Enter 1: to find the sqrt,2: to display todays date , or 3: to split the specified string");
    myInt = scan2.nextInt();
    displayCase(myInt);
    System.out.println("Enter 1,2, or 3 to check case");
    myInt = scan2.nextInt();
    displayCase(myInt);
    System.out.println("Enter 1,2, or 3 to check case");
    myInt = scan2.nextInt();
    displayCase(myInt);
    
    System.out.println("\n** Question 15: Created interface 'CustomMath' implemented by 'UsesCustomMath'. The Driver creates an object and implements the arithmetic. ** ");
    UsesCustomMath customArithmetic = new UsesCustomMath();
    System.out.println("Addition of " +num1+" and "+num2+ ": " +customArithmetic.addition(num1,num2));
    System.out.println("Subtract " +num1+" from "+num2+ ": " +customArithmetic.subtraction(num1,num2));
    System.out.println("Multiply " +num1+" by "+num2+ ": " +customArithmetic.multiplication(num1,num2));
    System.out.println("Divide " +num1+" by "+num2+ ": " +customArithmetic.division(num1,num2));
    
    System.out.println("\n** Question 16: display the number of characters for a string input. The string should be entered as a command line argument using (String [ ] args). **");
    //had to use command "java -cp ./bin;. com.revature.hw.Driver" from project folder becuase CLASSPATH was not set
    for (int i = 0; i < args.length; i++) {
      System.out.println("String '"+ args[i].toString() +"' length is: " + args[i].length());
    }
    
    System.out.println("\n** Question 17: Calculates the simple interest on the principal, rate of interest and number of years provided by the user."
    + "Enter principal, rate and time through the console using the Scanner class. Interest = Principal* Rate* Time **");
    System.out.println("The Interest on this loan will be: " +simpleInterest());
    
    System.out.println("\n** Question 18: Write a program having a concrete ;subclass that inherits three abstract methods from a superclass. "
    + " Provide the following three implementations in the subclass corresponding to the abstract methods in the superclass: **");
    MySubClass sub1 = new MySubClass(); //subClass object that extends Abstract class
    System.out.println("Enter A String to check for uppercase letters");
    myString = scan.nextLine();
    System.out.println(" -String '"+myString+" Contains an uppercase? " + sub1.checkUpper(myString));
    System.out.println(" -Convert lowercase in '"+myString+"' to uppercase: " + sub1.convertLowerToUpper(myString));
    System.out.println(" -Convert '12345' to integer and add 10: " + sub1.convertStringToInt("12345"));
    
    
    System.out.println("\n** Question 19: Create an ArrayList and insert integers 1 through 10. "
    + "Display the ArrayList. Add all the even numbers up and display the result. "
    + "Add all the odd numbers up and display the result. "
    + "Remove the prime numbers from the ArrayList and print out the remaining ArrayList. **");
    ArrayList<Integer> Q19 = new ArrayList<Integer>();
    System.out.println("ArrayList of Integers 1-10: " + addIntegersToArrayList(Q19,10));
    System.out.println("Sum of Evens in ArrayList: " + sumEvens(Q19));
    System.out.println("Sum of Odds in ArrayList: " + sumOdds(Q19));
    System.out.println("List with primes Removed: " + removePrimes(Q19)); 
    
    
    System.out.println("\n** Question 20: Create a notepad file called Data.txt and enter lines delimited by colons (Mickey:Mouse:35:Arizona). "
    + "Print to screen in specified format");
    readAndFormat();
    
  }
  
  
  //Q1 bubblesort
  public static void bubbleSort(int[] a) {
    int i = a.length;
    int temp=0;
    for(int x=0;x<i;x++) {
      for(int j=1;j<=(i-1);j++) {
        //swap element 
        if(arr[j-1] > arr[j]) {
          temp = arr[j-1];
          arr[j-1] = arr[j];
          arr[j]=temp;
        }
      }			
    }
  }
  
  //Q2 Prints fibonacci array up to specified number
  public static void fibonacci(int count) {
    int n1 =0;
    int n2 =1;
    int n3;
    System.out.print(n1 + " " + n2 + " ");
    for(int x=2;x<count;x++) {
      n3=n1+n2;
      System.out.printf("%s ", n3);
      n1=n2;
      n2=n3;
    }
  }
  //Q3 Reverse string without temp variable or StringBuffer class
  public static String reverseString(String str) {
    String reversed="";
    //iterate through string backwards
    for(int i = str.length()-1;i>=0;i--) {
      reversed += str.charAt(i);
    }
    return reversed;
  }
  //Q4 Compute Factorial of given number
  public static long nFactorial(long n) {
    long result=1;
    for(int factor=1;factor <= n; factor++) {
      result *= factor;
    }
    return result;
  }
  //Q5 Find substring between 0 and idx-1 inclusive
  public static String findSubString(String str, int idx) {
    String result ="";
    try {
      for(int x=0; x <= idx-1;x++) {
        result += str.charAt(x);
      }
      return result;
    } 
    catch(StringIndexOutOfBoundsException e) {
      System.out.println("Error: Nice Try Idiot. Returning String");
    }
    return result;
  }
  
  //Q6 Determine if Int is even 
  //binary number is odd if its last digit is 1 and even if its last digit is 0.
  public static boolean isEven(int x) {
    return ((x & 1) == 0)? true : false;
  }
  
  //Q7 is handled in Employee class
  
  
  //Q8 call function to populate arrayList then check if palindrome
  public static ArrayList<String> getPalindrome(ArrayList<String> list) { 
    ArrayList<String> goodPalindromes = new ArrayList<>();
    for(String word : list) {
      if(isPalindrome(word)) {
        goodPalindromes.add(word);
      }		
    }
    return goodPalindromes;	
  }
  
  //Q8 check if palindrome
  public static boolean isPalindrome(String word) {
    boolean result = false;
    int front = 0; int back = word.length() -1;
    while(front < back) {
      if (word.charAt(front++) != word.charAt(back--)) {
        return false;
      } else {
        return true;
      }
    }
    return result;
  }
  //Q8 Function to populate arrayList
  public static void populateList(ArrayList<String> list) {
    
    list.add("madam");
    list.add("tom");
    list.add("civic");
    list.add("radar");
    list.add("karan");
    list.add("jimmy");
    list.add("kayak");
    list.add("john");
    list.add("refer");
    list.add("billy");
    list.add("did");
  }
  
  //Q9 Create an array list which stores numbers 1 to 100 and prints prime numbers
  public static ArrayList<Integer> numberList() {
    ArrayList<Integer> intList = new ArrayList<Integer>();
    for(int x=1;x<=100;x++) {
      intList.add(x);
    }
    return intList;	
  }
  /*
  * Q9 create arrayList of primes
  * creates new arrayList to add two after parameter list is iterated through and checked for primes
  * calls isPrime function for each index of parameter list
  */
  public static ArrayList<Integer> createPrimeList(ArrayList<Integer> list){
    ArrayList<Integer> thisList = new ArrayList<Integer>();;
    for(Integer x :list) {
      if(isPrime(x)) {
        thisList.add(x);
      }
    }
    return thisList;
  }
  
  /* 
  * Q9 check if prime
  * One isn't prime
  * Check two seperately
  * check if n is multiple of two
  * then check odds
  * only have to go to sqrt of n because it is in the middle of its factors
  */
  public static boolean isPrime(Integer n) {
    if(n==1)return false;
    else if(n==2)return true;
    else if(n%2==0) return false;
    for(int i=3;i*i<=n;i+=2) {
      if(n%i==0){
        return false;
      }
    }
    return true;
  }
  
  //Q10 Find minimum of two numbers
  public static int findMin(int a, int b) {
    int min = (a < b) ? a : b;
    return min;
  }
  
  //Q12 Create int array 
  private static int[] fillIntArray(int i, int j) {
    int thisArr[] = new int[j];
    for(int x=i;x <=j; x++) {
      thisArr[x-1] = x;
    }
    return thisArr; 
  }
  
  //Q13 Use to print triangle with specified amount of lines
  public static void printTriangle(int n) {
    int track = 1;
    //String str="";
    for (int i =0;i<= n; i++) {
      for (int j = 1; j <= i; j++) {
        //			  if(track%2!=0) {
        System.out.print((track%2 ==0) ? "1":"0");
        track++;
        
      }
      System.out.print("\n");
    }
  }
  
  //Q14 Display Case based on number
  public static void displayCase(int num) {
    try {
      switch(num) {
        case 1:
        System.out.println("Enter an integer to find the square root");
        myInt = scan2.nextInt();
        System.out.println("Case 1: Square Root of "+myInt+" is " + Math.sqrt(myInt));
        break;
        case 2: 
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
        Date date = new Date();
        System.out.println("Case 2: Todays Date is " + dateFormat.format(date));
        break;
        case 3:
        String str = "I am learning core java";
        String[] strArray = str.split(" ");
        System.out.println("Case 3: Split '" + str + "' --> " + Arrays.toString(strArray));
        break;
        default: 
        System.out.println("Case does not exist");
        break;
      }
    }catch(InputMismatchException e) {
      System.out.println("Error: Input was not an Integer");
    }
    
  }
  
  //Q17 calculate Interest from user input 
  public static double simpleInterest(){
    double principle, rate,years;
    principle = rate = years = 0;
    Scanner scan = new Scanner(System.in);
    System.out.println("Enter The Principle Amount:");
    principle = scan.nextDouble();
    System.out.println("Enter The Interest Rate:");
    rate=scan.nextDouble();
    rate = (rate/100);
    System.out.println("Enter The Number Of Years:");
    years = scan.nextInt();
    return (principle *rate*years);
    
  }
  
  //Q19 populate Array List of Integers with given list and number of ints
  public static ArrayList<Integer> addIntegersToArrayList(ArrayList<Integer> list, Integer num){
    for(int x=1;x<=num;x++) {
      list.add(x);
    }
    return list;  
  }
  //Q19 Return sum of even integers in list
  public static Integer sumEvens(ArrayList<Integer> list) {
    Integer sum=0;
    for(Integer x : list) {
      if(isEven(x))
      sum += x;
    }
    return sum;
  }
  //Q19 Return sum of odd integers in list
  public static Integer sumOdds(ArrayList<Integer> list) {
    Integer sum=0;
    for(Integer x : list) {
      if(!isEven(x))
      sum += x;
    }
    return sum;
  }
  
  //Q19 Remove Prime Numbers From List
  //Checks list index for primes
  //if not prime, store in new composites list and return
  public static ArrayList<Integer> removePrimes(ArrayList<Integer> list) {
    boolean checkPrime = false;
    for(int i=0;i<list.size();i++) {
      checkPrime = isPrime(list.get(i));
      if(checkPrime) {
        list.remove(i);
      }
    }
    return list; 
  }
  
  //Q20 
  public static void readAndFormat() {
    String firstName="";
    String lastName="";
    String age="";
    String state="";
    try {
      Scanner scanner = new Scanner(new File("Data.txt"));
      while(scanner.hasNext()) {
        firstName = scanner.next();
        lastName = scanner.next();
        age = scanner.next();
        state = scanner.next();
        System.out.println("Name: "+firstName+" "+lastName+ "\nAge: "+age+" years\nState: "+ state+ "State\n");
      }
      scan.close();
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    }
    
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
