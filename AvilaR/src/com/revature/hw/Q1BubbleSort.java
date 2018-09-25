package com.revature.hw;

public class Q1BubbleSort {

	/*
	 * BubbleSort method takes the numbers in and per index checks against next index to see which value is higher
	 * It will swap values if the left value is higher than right value
	 * Once it goes through an iteration it will sort again to make sure all values are in proper order
	 */
	void BubbleSort(int[] arr){
		int l = arr.length;
		for(int i =0; i < l-1; i++) {// l - 1 so it doesn't go out of bounds
			for(int j =0;j < l-i-1;j++) {// l-i-1 so it doesn't go out of bounds as well as stops when last two values are being compared
				if(arr[j] > arr[j+1]) {
					int temp = arr[j];//Temp value to swap values for ordering
					arr[j] = arr[j+1];
					arr[j+1] = temp;
				}
			}
		}
		
	}
}
