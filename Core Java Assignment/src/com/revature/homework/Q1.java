package com.revature.homework;

public class Q1 {
	// Java program for implementation of Bubble Sort
	void bubbleSort(int arr[])
	{
		System.out.println("Q1: Bubble sorted array.");
		int n = arr.length;
		for (int i = 0; i < n-1; i++)
			for (int j = 0; j < n-i-1; j++)
				if (arr[j] > arr[j+1]) { //check if the current value is bigger than the next one
	                    // swap temp and arr[i]
	                    int temp = arr[j];
	                    arr[j] = arr[j+1];
	                    arr[j+1] = temp;
	                }
		
		for (int i=0; i<n; ++i)
            System.out.print(arr[i] + " ");
		
        System.out.println("\n"); //skipping lines to make it easier to read the output
	    }
}
