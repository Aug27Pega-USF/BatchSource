package com.revature.homework;

import java.io.File;
import java.io.InputStream;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.Scanner;
import com.revature.fvariable.*;

public class JavaAssignment1 {
	
	/*
	 * Q1:Perform a bubble sort on the following integer array:  1,0,5,6,3,2,3,7,9,8,4
	 */
	public static void bubble() {
		Integer[] bub= {1,0,5,6,3,2,3,7,9,8,4};
		
		int l= bub.length;
		for(int i=0;i<l-1;i++)
		{
			for(int j=0; j<l-i-1;j++)
			{
				if(bub[j]>bub[j+1])
				{
					int t = bub[j];
	                bub[j] = bub[j+1];
	                bub[j+1] = t;
				}
			}		
		}
		for(Integer w: bub)
			{
				System.out.print(w+" ");
			}
		System.out.println("");
		
	}
	/*
	 * Q2:Write a program to display the first 25 Fibonacci numbers beginning at 0.
	 */
	public static void fibo() {
		
		ArrayList<Integer> fib= new ArrayList<Integer>();
		fib.add(0);
		fib.add(1);
		for(int i=0; i<25; i++)
		{
			int total;
			
			total=fib.get(i+1)+fib.get(i);
			fib.add(total);
			
		}
		System.out.print("Fibonacci: ");
		for(Integer n: fib)
		{
			System.out.print(n+" ");
		}
		System.out.println("");
	}

	/*
	 * Q3:Reverse a string without using a temporary variable.  Do NOT use reverse() in the StringBuffer or the StringBuilder APIs.
	 */
	public static void rev(String m) {
		
		int start=0;
		int end= m.length();
		
		for(int i=0; i<m.length();i++)
		{
			m= m.substring(1, end-i)+m.substring(start,1)+m.substring(end-i, m.length());
		}
		System.out.println(m);
		
	}
	/*
	 * Q4:Write a program to compute N factorial.
	 */
	public static void factor() 
	{
		int n=5;
		int fact=1;
			
		for(int i=1;i<=n;i++){    
		      fact=fact*i;    
		  }    
		  System.out.println("Factorial of "+n+" is: "+fact);    
	}
	/*
	 * Q5:Write a substring method that accepts a string str and an integer idx and returns the substring contained between 0 and idx-1 inclusive.  Do NOT use any of the existing substring methods in the String, StringBuilder, or StringBuffer APIs.
	 */
	public static void strIdx(String str, int idx)
	{
		for(int i=0;i<idx;i++)
		{
			System.out.print(str.charAt(i));
		}
	}
	/*
	 * Q6:Write a program to determine if an integer is even without using the modulus operator (%)
	 */
	public static String even(int num) 
	{
		String a="";
		
		boolean even = true;
        
        for (int i = 1; i <= num; i++) 
            even = !even;
             
        if(even==true)
        {
        	a=num+" is Even";
        }
        else
        	a=num+" is Odd";
        
        return a;
	}
	/*
	 * Q7:Sort two employees based on their name, department, and age using the Comparator interface.
	 */
	public static void employee() 
	{
		ArrayList<Employee> e= new ArrayList<Employee>();
		
		Employee e1= new Employee("Bank", "Matt",34);
		Employee e2= new Employee("IT","Bob",52);
		e.add(e1);
		e.add(e2);
		Collections.sort(e, new EmployeeComp());
		System.out.println("Sort by Age: ");
		for(Employee m: e) {
		System.out.println(m);
		}
		Collections.sort(e, new EmployeeCompName());
		System.out.println("Sort by Name: ");
		for(Employee m: e) {
		System.out.println(m);
		}
		Collections.sort(e, new EmployeeCompDep());
		System.out.println("Sort by Department: ");
		for(Employee m: e) {
		System.out.println(m);
		}
	}

	/*
	 * Q8:Write a program that stores the following strings in an ArrayList and saves all the palindromes in another ArrayList.
“karan”, “madam”, ”tom”, “civic”, “radar”, “jimmy”, “kayak”, “john”,  “refer”, “billy”, “did”
	 */
	public static void arrayList() 
	{
		StringBuffer sbr= new StringBuffer();
		ArrayList<String> pali= new ArrayList<String>();
		ArrayList<String> list= new ArrayList<String>();
		list.add("karan");
		list.add("madam");
		list.add("tom");
		list.add("civic");
		list.add("radar");
		list.add("jimmy");
		list.add("kayak");
		list.add("john");
		list.add("refer");
		list.add("billy");
		list.add("did");
		
	for(String i: list)
	{
		int l=i.length();
		String reverse="";
		for(int j=l-1;j>=0;j--)
		{
			reverse= reverse +i.charAt(j);
		}
		if(reverse.equals(i))
		{
			pali.add(i);
		}
	}
	for(String p: pali)
	{
		System.out.print(p+ " ");
	}
	}

	/*
	 * Q9:Create an ArrayList which stores numbers from 1 to 100 and prints out all the prime numbers to the console.
	 */
	public static void numArrayList()
	{
		ArrayList<Integer> num= new ArrayList<Integer>();
		int p=0;
		for(int i=1; i<=100;i++)
		{
			num.add(i);
			
			 int counter=0; 	  
	          for(p =i; p>=1; p--)
		  {
	             if(i%p==0)
		     {
	 		counter = counter + 1;
		     }
		  }
		  if (counter ==2)
		  {
			System.out.print(num.get(i-1)+", ");  
		  }
		  }
		}
	
	/*
	 * Q10:Find the minimum of two numbers using ternary operators.
	 */
	public static void ternary() {
		
		int max=5;
		int min=1;
		int ter= min<max ? min:max ;
		
		System.out.println(ter);
		
	}
	/*
	 * Q11:Write a program that would access two float-variables from a class that exists in another package. Note, you will need to create two packages to demonstrate the solution.
	 */
	public static void fVariables() 
	{
		Variable v= new Variable();
		
		System.out.println("Float one="+ v.getOne());
		System.out.println("Float twoe="+ v.getTwo());
	}
	/*
	 * Q12:Write a program to store numbers from 1 to 100 in an array. Print out all the even numbers from the array. Use the enhanced FOR loop for printing out the numbers.
	 */
	public static void evenArray() {
		
		ArrayList<Integer> numbers = new ArrayList<Integer>();
		int fill=1;
		while(fill<=100)
		{
			numbers.add(fill);
			fill++;
		}
		
		for(int i: numbers)
		{
			//int index=i-1;
			if(i%2==0) 
			{
				System.out.print(i+" ");
			//System.out.println("Index: "+index+ " Value: "+i);
			}
		}		
	}
	/*
	 * Q13:Display the triangle on the console as follows using any type of loop.  Do NOT use a simple group of print statements to accomplish this.
	0
	1 0
	1 0 1
	0 1 0 1

	 */
	public static void pyrimid() {
		
		int line = 0;
		
		for(int i=0; i<4; i++)
		{
			 for(int j=0;j<=i;j++)
			 {
				 line++;
				 if(line%2==0)
				 {
					 System.out.print(1);
				 }
				 else
				 {
					 System.out.print(0);
				 }
			 }
			 System.out.println();			 
		}
		
	}
	
	/*
	 * Q14:Write a program that demonstrates the switch case. Implement the following functionalities in the cases:java
Case 1: Find the square root of a number using the Math class method.
Case 2: Display today’s date.
Case 3: Split the following string and store it in a string array.
       	 “I am learning Core Java”

	 */
	public static void switchingCase(int num) {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM/dd/yyyy");
		LocalDate localDate = LocalDate.now();
		String j= "I am Learning Core Java";
		String[] java= j.split(" ",5) ;
		
		switch(num) {
		case 1: System.out.println(Math.sqrt(9));
			break;
		case 2: System.out.println(dtf.format(localDate));
			break;
		case 3: for(String w: java)
			{
			System.out.println(w);
			}
		break;
		}
	}
	
	/*
	 * Q15:Write a program that defines an interface having the following methods: addition, subtraction, multiplication, and division. 
	 *  Create a class that implements this interface and provides appropriate functionality to carry out the required operations. 
	 *  Hard code two operands in a test class having a main method that calls the implementing class.
	 */
	public static void interfaceQ(int x, int y) {
		try
		{
		System.out.println(Math.multiplyExact(x, y));
		System.out.println(Math.subtractExact(x, y));
		System.out.println(Math.addExact(x, y));
		System.out.println(Math.floorDiv(x,y));		
		}
		catch(Exception e) {
			System.out.println("No divide by zero");
		}
	}
	
	/*
	 * Q16:Write a program to display the number of characters for a string input. The string should be entered as a command line argument using (String [ ] args).
	 */
	public static void argsString(String[]args)
	{
		System.out.println("Number of characters is: "+ args[0].length());
	}
	/*
	 * Q17:Write a program that calculates the simple interest on the principal, rate of interest and number of years provided by the user. Enter principal, rate and time through the console using the Scanner class.
	 */
	
	public static void principal()
	{
		Scanner s= new Scanner(System.in);
				
		System.out.println("Enter Principal: ");
		double p=s.nextDouble();
		System.out.println("Enter Rate: ");
		double rate=s.nextDouble();
		System.out.println("Enter Years: ");
		int years=s.nextInt();
		
		double percent= rate/100;
		double total= p*(1+percent*years);
		System.out.println("Principal: "+p);
		System.out.println("Rate of Interest: "+rate);
		System.out.println("Years: "+years);
		System.out.println("Total Interest: "+total);
		
	}
	
	/*
	 * Q18:Write a program having a concrete ;subclass that inherits three abstract methods from a superclass.  Provide the following three implementations in the subclass corresponding to the abstract methods in the superclass:
 
1.          	Check for uppercase characters in a string, and return ‘true’ or ‘false’ depending if any are found.
2.          	Convert all of the lower case characters to uppercase in the input string, and return the result.
3.          	Convert the input string to integer and add 10, output the result to the console.
Create an appropriate class having a main method to test the above setup.

	 */
	public static void superToSubclass()
	{
		
		
	}
	/*
	 * Q19:Create an ArrayList and insert integers 1 through 10. Display the ArrayList. Add all the even numbers up and display the result. Add all the odd numbers up and display the result. Remove the prime numbers from the ArrayList and print out the remaining ArrayList.
	 */
	public static void addEvenAddOdd()
	{
		ArrayList<Integer> m= new ArrayList<Integer>();
		m.add(1);
		m.add(2);
		m.add(3);
		m.add(4);
		m.add(5);
		m.add(6);
		m.add(7);
		m.add(8);
		m.add(9);
		m.add(10);
		
		int even=0;		
		int odd=0;
		
		System.out.print("ArrayList: ");
		for(int i: m)
		{
			if(i%2==0)
			{
				even+=i;
			}
			else
			{
				odd+=i;
			}
			System.out.print(i+" ");
		}
		System.out.println("");
		System.out.println("Even Total: "+even);
		System.out.println("Odd Total: "+ odd);
		System.out.println("Array with no prime numbers: ");
		for(int i=0; i<m.size();i++)
		{
			if(m.get(i)==2)
			{
				m.remove(i);
			}
			 if(m.get(i)==3)
			{
				m.remove(i);
			}
			 if(m.get(i)==5)
			{
				m.remove(i);
			}
			 if(m.get(i)==7)
			{
				m.remove(i);
			}
			
			System.out.print(m.get(i)+" ");
		}
		
		
	}
	/*
	 * Q20:Create a notepad file called Data.txt and enter the following:
Mickey:Mouse:35:Arizona
Hulk:Hogan:50:Virginia
Roger:Rabbit:22:California
Wonder:Woman:18:Montana
 
Write a program that would read from the file and print it out to the screen in the following format:
 
Name: Mickey Mouse
Age: 35 years
State: Arizona State

	 */
	
	public static void notepad()
	{
		String file="Data.txt";
		String fname ="";
		String lname ="";
		String age ="";
		String state ="";
		try
		{
			Scanner s= new Scanner(new File(file));
			s.useDelimiter("[:\n]");
			while(s.hasNextLine())
			{
				fname=s.next();
				lname=s.next();
				age=s.next();
				state=s.next();
				
				System.out.println("Name: "+fname+" "+lname);
				System.out.println("Age: "+age+" years");
				System.out.println("State: "+state+" State");		
			}
		}
			catch(Exception e)
			{
				
			}
		}
	

	public static void main(String [] args) throws Exception
	{
		
		System.out.println("Q1:");
		bubble();
		System.out.println("Q2:");
		fibo();
		System.out.println("Q3:");
		rev("Miguel");
		System.out.println("Q4: ");
		factor();		
		System.out.println("Q5: ");
		strIdx("Hello",3);
		System.out.println("Q6: ");
		even(3);
		System.out.println("Q7: ");
		employee();
		System.out.println("Q8: ");
		arrayList();
		System.out.println("Q9: ");
		numArrayList();
		System.out.println("Q10: ");
		ternary();
		System.out.println("Q11: ");
		fVariables();
		System.out.println();
		System.out.println("Q12:");
		evenArray();
		System.out.println();
		System.out.println("Q13:");
		pyrimid();
		System.out.println();
		System.out.println("Q14:");
		switchingCase(3);
		System.out.println();
		System.out.println("Q15:");
		interfaceQ(5,0);
		System.out.println();
		System.out.println("Q16:");
		argsString(args);
		System.out.println("Q17:");
		principal();
		System.out.println();
		System.out.println("Q19:");
		addEvenAddOdd();
		System.out.println("Q20:");
		notepad();
}
}
