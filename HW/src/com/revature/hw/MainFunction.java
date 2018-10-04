package com.revature.hw;

import java.awt.geom.Arc2D.Float;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Scanner;

public class MainFunction {

	

	public static void main(String[] args) {
		



		
		class Driver {

			public void main(String args[])
			{
				//output Q1
				bubbleSort();
				//output Q2
				fibNumbers();
				//output Q3
				reverseString();
				//output Q4
				factorial();
				//output Q5
				String sub = subString("Roll", 2);
				System.out.println(sub);
				//output Q6
				evenNumbers();
				//output Q7
				//employee person = new employee();
				//person.comparison();
				//output 8
				Palindrome();
				//output 9
				primes();
				//output 10
				min();
				//output 11
				access();
				//output 12
				evenNums();
				//output 13
				triangle();
				//output 14
				swithCase(); }
				//Output 15
				/*calculate work = new calculate();
				work.add();
				work.sub();
				work.multiply();
				work.divide();
				//output 16
				
				//output 17
				interest();
			}
			
			
			 /*
			 * Question one perform bubble sort on an array
			 */
			void bubbleSort() 
			{
				int array[] = {1,0,5,6,3,2,3,7,9,8,4};
				int n = array.length;
				for (int i = 0; i < n -1; i++)
					for (int j = 0; j < n-i-1; j++)
						if (array[j] > array[j+1])
						{
							//swap temp and array[i]
							int temp = array[j];
							array[j] = array[j+1];
							array[j+1] = temp;
						}
				for (int z = 0; z < n; ++z)
					System.out.print(array[z] + " ");
				
				System.out.println();
			}
			/*
			 * Question two display the first 25 fib numbers starting at 0
			 */
			void fibNumbers()
			{
				int n = 25;
				int start = 1;
				int num1 = 0;
				int num2 = 1;
				
				while (start <= n )
				{
					System.out.print(num1 + " ");
					int sum = num1 + num2;
					num1 = num2;
					num2 = sum;
					
					start++;
				}
				System.out.println();
			}
			/*
			 * Question three reverse a string
			 */
			void reverseString()
			{
				String reverse = "Roll Tide";
				for(int i = 0; i <reverse.length(); i++)
				{
					reverse = reverse.substring(1, reverse.length() - i)
					        + reverse.substring(0, 1)
					        + reverse.substring(reverse.length() - i, reverse.length());
				}
				System.out.println(reverse);
			}
			/*
			 * Question four write program to compute N factorial
			 */
			void factorial()
			{
				
				int num = 1;
				//the number for which the factorial will be done 
				int fact = 5;
				for (int z = 1; z <=fact; z++)
				{
					num = num * z;
				}
				System.out.println("Factorial of " + fact + " is: " + num);
			}
			/*
			 * Question five substring method 
			 */
			String subString(String word, int idx)
			{
				 String part = "";
				for (int i = 0; i < idx; i++)
				{
					part += word.charAt(i);
				}
				return part;
			}
			/*
			 * Question six find even number without mod 
			 */
			void evenNumbers()
			{
				int num = 6;
				if ((num & 1) == 0)
				{
					System.out.println("Even number");
				}
				else
				{
					System.out.println("Try again, not even");
				}
			}
			/*
			 * Question eight find all the Palindromes
			 */
			void Palindrome ()
			{
				ArrayList <String> Set = new ArrayList<String>();
				ArrayList <String> PalSet = new ArrayList<String>();
				

				Set.add("karan");
				Set.add("madam");
				Set.add("tom");
				Set.add("civic");
				Set.add("radar");
				Set.add("jimmy");
				Set.add("kayak");
				Set.add("john");
				Set.add("refer");
				Set.add("billy");
				Set.add("did");
				
				for (int i = 0; i <Set.size(); i++)
				{
					if (isPal(Set.get(i)))
					{
						PalSet.add(Set.get(i));
					}
					else
						continue;

				}
				System.out.println("displaying arraylist of alindromes of strings");
				for (int i=0; i < PalSet.size(); i++) {
				   System.out.println(PalSet.get(i));}
				System.out.println();
					
			}
			boolean isPal(String str)
			{
				String pal = "";
				
				for (int i = str.length() - 1; i >=0; i--)
				{
					pal = pal + str.charAt(i);
					
				}
				if (str.equals(pal))
				{
					return true;
				}
				else 
				{
					return false;
				}
			}
			/*
			 * Question 9
			 */
			void primes()
			{
				int n = 100,m;
				
				//declaring an ArrayList with an initial size
				ArrayList<Integer> array = new ArrayList<Integer>(n);
				
			       // Appending the new element at the end of the list
			       for (int i=1; i<=n; i++)
			           array.add(i);
			       
			       System.out.println("All the primes upto 100:");
			       //prints the primes
			       for(int i=0;i<array.size();i++)
			       {
			           m=array.get(i);
			           if(isprime(m))
			               System.out.print(m+" ");
			              
			       }
			       
			}
			boolean isprime(int n)
			{
					boolean flag = false;
			       for(int i=2;i<=n/2;i++)
			       {
			           if(n%i==0)
			           {
			               flag=true;
			               break;
			           }
			       }
			       if(flag==false)
			           return true;
			       else
			           return false;
			}
			/*
			 * Question 10 minimum of two numbers using ternary operators
			 */
			void min()
			{
				int a = 100;
				int b = 90;
				int min;
				
				min = a<b ? a:b;
				System.out.println("Min of two nos:");	
				System.out.println(min + " ");
			}
			/*
			 * Question 11 float-variables
			 */
			void access()
			{
				Float num = new Float();
				System.out.println("Variable 1: " + num);
				System.out.println("Variable 2: " + num);
				System.out.println();
				
			}
			/*
			 * Question 12 
			 */
			void evenNums()
			{
				int number [] = new int[100];
			      
			       //Storing 1 to 100 in Array
			       for (int i=1;i<=100;i++) 
			       {
			           number [i-1] = i;
			       }
			      
			       //Showing Even Number using For Each Loop
			       for (int j:number) 
			       {
			           if(j%2==0)
			               System.out.print(j + " ");
			       }   
			       System.out.println("\n");
			}
			
			/*
			 * Question 13
			 */
			void triangle()
			{
				int count = 1;
			       for (int i=1;i<=4;i++)
			       {
			           for (int j=0;j<i;j++)
			           {
			               if (count%2!=0) 
			               {
			                   System.out.print("0");
			               }
			               else 
			               {
			                   System.out.print("1");
			               }
			               count++;
			           }
			           System.out.print("\n");
			       }  
			       System.out.println();
			   }
			/*
			 * Question 14 implement switch cases
			 */
			void swithCase()
			{
				@SuppressWarnings("resource")
				Scanner sc = new Scanner(System.in);
			       System.out.println("Enter Number between 1 to 3");
			       int number = sc.nextInt();
			       double mathNumber = 10;
			       switch (number) 
			       {
			           case 1:
			              
			               mathNumber = Math.sqrt(mathNumber);
			               System.out.println("Suare Root: "+mathNumber);
			               break;
			           case 2:
			               Date date = new Date(number);
			               System.out.println("Todays Date: "+date);
			               break;          
			           case 3:
			               String s = "I am Learning Core Java";
			               String sArray [] = s.split(" ");
			               for (String token:sArray) 
			               {
			                   System.out.println("String Array Value: "+token);
			               }
			               break;
			           default:
			               break;
			       }
			   }
			
			/*
			 * Question 16
			 */
			
			/*
			 * Questions 17
			 */
			void interest()
			{
				double priniciple = 0;
				double rate = 0;
				double years = 0;
				double answer = 0;
				
				Scanner scan = new Scanner(System.in);
				System.out.println("Enter the Principle Amount: ");
				priniciple = scan.nextDouble();
				System.out.println("Enter the Interest Rate: ");
				rate = scan.nextDouble();
				rate = (rate/100);
				System.out.println("Enter the number of years: ");
				years = scan.nextInt();
				answer = (priniciple*rate*years);
				System.out.println("The principle interest is: " + answer);
			}
			}
			


	}

}
