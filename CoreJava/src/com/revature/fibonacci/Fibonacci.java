package com.revature.fibonacci;
import java.util.*;

public class Fibonacci {

		public static void main(String[] args) {
			
			Scanner input = new Scanner(System.in);
			System.out.println("enter the number of element");
			int number = input.nextInt();		
			fibon(number);	
	}
		
		public static void fibon(int n){
			int a = 0;
			int  b = 1;
			int  c;
			System.out.println("list of the first 25 fibonacci numbers is");
			System.out.print(" " +a);
			System.out.print(" " +b);
			for (int i = 0; i <= n; i++) {
				c = a + b;
				a = b;
				b = c;
				System.out.print(" " +c);
			}
	}

}
