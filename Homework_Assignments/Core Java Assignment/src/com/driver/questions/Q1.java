package com.driver.questions;

import com.driver.functions.Functions;

public class Q1 {
	public static void question( int arr[] ) {

		//display unsorted array
		System.out.print("Unsorted array: ");
		Functions.displayArray(arr);
		
		//sort the array
		sortArray(arr);
		
		//display the new sorted array
		System.out.println("");
		System.out.print("Sorted array: ");
		Functions.displayArray(arr);
	}
	
	public static void sortArray(int arr[]) {
		
		int arraySize = arr.length;
		
		while(arraySize > 0) {
			for(int i = 0; i < arraySize-1; i++) {
				//if the left element is lower than the right
				if(arr[i] > arr[i+1]) {
					//swap them
					int temp = arr[i];
					arr[i] = arr[i+1];
					arr[i+1] = temp;
				}
			}
			//ignore last element by removing how many are left to check
			arraySize--;
		}
	}
}
