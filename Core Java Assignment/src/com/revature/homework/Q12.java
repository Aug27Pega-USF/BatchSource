package com.revature.homework;

public class Q12 {
	void evenList() {
		System.out.println("\nQ12: Print only even numbers from 1 to 100.");
		
		int[] nums = new int[100];
		for(int i = 1; i <= 100; i++) {
			nums[i-1] = i;
		}
		
		for(int i : nums) {
			if(i % 2 == 0) {
				System.out.print(i + " ");
			}
			else {
				continue;
			}
		}
	}
}
