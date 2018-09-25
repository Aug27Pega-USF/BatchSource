package com.revature.HW1;

public class Question1 {
	void bubbleSort(int arr[])
	{
	    int n = arr.length;//get length of array
	    for (int i = 0; i < n-1; i++)//for each value in array
	        for (int j = 0; j < n-i-1; j++)//for each column
	            if (arr[j] > arr[j+1])
	            {
	                // swap temp and arr[i]
	                int temp = arr[j];
	                arr[j] = arr[j+1];
	                arr[j+1] = temp;
	            }
	}

	/* Prints the array */
	void printArray(int arr[])
	{
	    int n = arr.length;
	    for (int i=0; i<n; ++i)
	        System.out.print(arr[i] + " ");//printing every value in array
	    System.out.println();
	}

	// Driver method to test above
	public static void main(String args[])
	{
	    Question1 ob = new Question1();
	    int arr[] = {1,0,5,6,3,2,3,7,9,8,4};
	    ob.bubbleSort(arr);
	    System.out.println("Sorted array");
	    ob.printArray(arr);
	}
}
