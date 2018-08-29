package com.revature.hw;

import java.util.ArrayList;
import java.util.Arrays;

import com.revature.floats.Floats;

public class Driver {
  
  //All variables for questions are defined here
  static int arr[] = {1,0,5,6,3,2,3,7,9,8,4};
  static String myString = "Roll Tide I Guess";
  static long factorial = 4;
  static int number = 6;
  static int idx =5;
  static Employee Emp1 = new Employee("David",30, "Human Resources");
  static Employee Emp2 = new Employee("Matt", 32, "Training");
  static ArrayList<String> toPalindrome = new ArrayList<String>();
  static ArrayList<Integer> integerList = new ArrayList<Integer>();
  static ArrayList<Integer> primeList = new ArrayList<Integer>();
  static int intArray[] = new int[100];
  
  public static void main(String[] args) {
    
    bubbleSort(arr);
    System.out.println("** Question 1: Bubble Sort an int array **");
    printIntArray(arr);
    System.out.println();
    
    System.out.println("\n** Question 2: Display first 25 Fibonacci Numbers starting from 0 **");
    fibonacci(25);
    System.out.println();
    
    System.out.println("\n** Question 3: Reverse The String **");
    System.out.print(myString +" --> " + reverseString(myString));
    
    System.out.println("\n** Question 4: Compute N Factorial **");
    System.out.println(factorial +" Factorial: " +nFactorial(factorial));
    
    System.out.println("\n** Question 5: Substring method that returns substring contained between 0 and idx-1 **");
    System.out.println(findSubString(myString,idx));
    
    System.out.println("\n** Question 6: Determine if number is even w/out Modulo **");
    System.out.println("Is "+number+" "+ "even? " + isEven(number));
    
    System.out.println("\n** Question 7: Compare two employees by name, age, and department");
    System.out.println("Comparing Names: " +Employee.nameComparator.compare(Emp1,Emp2));
    System.out.println("Age Difference: " +Employee.ageComparator.compare(Emp1,Emp2));
    System.out.println("Compare Departments: " +Employee.departmentComparator.compare(Emp1,Emp2));
    
    System.out.println("\n** Question 8: Store Strings in an arrayList and palindromes in another arrayList **");
    populateList(toPalindrome);
    toPalindrome = getPalindrome(toPalindrome);
    System.out.println(toPalindrome);
    
    System.out.println("\n** Question 9: Create an ArrayList that stores 1-100 and store Prime numbers and print primes **");
    integerList = numberList();
    primeList = createPrimeList(integerList);
    System.out.println(primeList);
    
    System.out.println("\n** Question 10: Find the Mininum of two numbers using ternary operators **");
    System.out.println("Minimum: " + findMin(10,5));
    
    System.out.println("\n** Question 11: Access two float variables from a class in another package **");
    System.out.println("Float 1: " + Floats.getFloat1() + "\nFloat 2: " + Floats.getFloat2());
    
    System.out.println("\n** Question 12: Create Array w/ number 1-100, print evens");
    //intArray=fillIntArray(1,100);
    intArray = fillIntArray(1,100);
    System.out.println(Arrays.toString(intArray));
    //intArray.toString();
    
    
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
  //Q4 Compute Factorial 
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
    for(int x=0; x <= idx-1;x++) {
      result += str.charAt(x);
    }
    return result;
  }
  
  //Q6 Determine if Int is even 
  //binary number is odd if its last digit is 1 and even if its last digit is 0.
  public static boolean isEven(int x) {
    return ((x & 1) == 0)? true : false;
  }
  
  //Q7 Sort Two employees based on name, department, and age using comparator interface
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
    int len = word.length()-1;
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
    int thisArr[] = new int[100];
    for(int x=i;x <=j; x++) {
      thisArr[x-1] = x;
    }
    return thisArr;
    // TODO Auto-generated method stub
    
  }
  
  
  //function to print int array
  public static void printIntArray(int[] arr) {
    for(int x : arr) {
      System.out.printf(" " + x);
    }
  }
}
