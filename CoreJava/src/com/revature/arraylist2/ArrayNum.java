/*
 * Create an ArrayList which stores numbers from 1 to 100 and 
 * prints out all the prime numbers to the console.

 */

package com.revature.arraylist2;

import java.util.ArrayList;

public class ArrayNum {

	public static void main(String[] args) {
		
		ArrayList<Integer> arrNum = new ArrayList<Integer>(100);
		
		for(int i = 0; i < 100; i++) {
			arrNum.add(i);
			if(arrNum.get(i) % 2 == 0)
				System.out.print(" " +arrNum.get(i));
		}
	}

}
