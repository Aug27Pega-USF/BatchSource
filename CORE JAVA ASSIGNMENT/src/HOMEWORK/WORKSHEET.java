package HOMEWORK;

import java.util.Scanner;

public class WORKSHEET {
	//scanner
	public static Scanner sc = new Scanner (System.in);
	
	//Bubble Sort Question #1
	   static void bubbleSort(int[] arr) {  
	        int b = arr.length;  
	        int temp = 0;  
	         for(int i=0; i < b; i++){  
	                 for(int j=1; j < (b-i); j++){  
	                          if(arr[j-1] > arr[j]){  
	                                 //organize elements  
	                                 temp = arr[j-1];  
	                                 arr[j-1] = arr[j];  
	                                 arr[j] = temp;  
	                         }  
	                          
	                 }  
	         }  
	   }
	  //Fibonacci Sequence
	        static int f1=0, f2=1, f3=0;
	        static void doFib(int count) {
	        	if(count>0) {
	        		f3= f1+f2;
	        		f1=f2;
	        		f2=f3;
	        		System.out.print(" "+f3);
	        		doFib(count-1);
	        		
	        	}
	        }
	   

	
	public static void main(String[] args) {
		//user inputs
		
		
	//Question 1
	//prints out numbers for bubble sort 
		int arr[] = {14,234,53,5,754,22,4,6,7,8,886,12};
		System.out.println("1. Array before bubble sort:");
		for (int i=0; i< arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
		//prints out bubble sort after being sorted
		bubbleSort(arr);
		System.out.println("Array after bubble sort:");
		for( int i=0; i< arr.length; i++) {
			System.out.print(arr[i]+ " ");
		}
		System.out.println();
		System.out.println("---------------------------------------------------------");

		//***************************************************************************
	//Question 2
	//FIB SEQUENC PRINT OUT
	System.out.println("2. The Fibonacci sequence");	
		int count=15;
	System.out.print(f1+" "+f2);
	doFib(count-2);
	
	//Question 3
		//String Reverse
	System.out.println();
	System.out.println("---------------------------------------------------------");
		String reverse = "Theres a difference";
		System.out.println("3. Reverse a String:");
		System.out.println(reverse);
		for(int i =0 ; i< reverse.length();i++) {
			reverse = reverse.substring(1, reverse.length() - i)
			        + reverse.substring(0, 1)
			        + reverse.substring(reverse.length() - i, reverse.length());
		}
		System.out.println("String Reversed");
		System.out.print(reverse);
		System.out.println();
		System.out.println("---------------------------------------------------------");
	//Question 4
		// N factorial 
		int enter1;
		int f, fact =1; 
		System.out.println("4. Enter a number to find the factorial");
		enter1 = sc.nextInt();
		int number = enter1;
		for(f=1; f < number; f++) {
			fact= fact*f;
		}
		System.out.println(" So the factorial of " + number+ " is "+fact );
		System.out.println();
		System.out.println("---------------------------------------------------------");
		//Question 5
		/*Write a substring method that accepts a 
		 * string str and an integer idx and returns 
		 * the substring contained between 0 and 
		 * idx-1 inclusive. Do NOT use any of the 
		 * existing substring methods in the String, 
		 * StringBuilder, or StringBuffer APIs. 
		 */
		System.out.println();
		System.out.println("---------------------------------------------------------");
		//Question 6
		System.out.println();
		System.out.println("---------------------------------------------------------");

		System.out.println();
		System.out.println("---------------------------------------------------------");

		System.out.println();
		System.out.println("---------------------------------------------------------");

		System.out.println();
		System.out.println("---------------------------------------------------------");

		System.out.println();
		System.out.println("---------------------------------------------------------");

		System.out.println();
		System.out.println("---------------------------------------------------------");

		System.out.println();
		System.out.println("---------------------------------------------------------");

		System.out.println();
		System.out.println("---------------------------------------------------------");

		System.out.println();
		System.out.println("---------------------------------------------------------");

		System.out.println();
		System.out.println("---------------------------------------------------------");

		System.out.println();
		System.out.println("---------------------------------------------------------");

		System.out.println();
		System.out.println("---------------------------------------------------------");

		System.out.println();
		System.out.println("---------------------------------------------------------");

		System.out.println();
		System.out.println("---------------------------------------------------------");

		System.out.println();
		System.out.println("---------------------------------------------------------");

		System.out.println();
		System.out.println("---------------------------------------------------------");

		System.out.println();
		System.out.println("---------------------------------------------------------");

		System.out.println();
		System.out.println("---------------------------------------------------------");

		System.out.println();
		System.out.println("---------------------------------------------------------");

		System.out.println();
		System.out.println("---------------------------------------------------------");

		System.out.println();
		System.out.println("---------------------------------------------------------");

		System.out.println();
		System.out.println("---------------------------------------------------------");

		
	}
	{

}
}
	
	
	

	