package com.revature.homework;

import java.util.ArrayList;

public class Q19 {
	void intList() {
		System.out.println("\nQ19: Sums of evens then odds, followed by a list without primes.");
		int sum = 0;
		ArrayList<Integer> list = new ArrayList<Integer>();
		for(int i = 1; i <= 10; i++) {
			list.add(i);
		}
		System.out.println("The ArrayList as is:");
		for(int num : list) {
			System.out.print(num + " ");
		}
		System.out.println("\nThe total sum of only even numbers:");
		for(int i : list) {
			if(i % 2 == 0) {
				sum += i;
				//System.out.print(i + " ");
			}
			else {
				continue;
			}
		}
		System.out.println(sum);
		sum = 0;
		System.out.println("And now the odds:");
		for(int i : list) {
			if(i % 2 != 0) {
				sum += i;
				//System.out.print(i + " ");
			}
			else {
				continue;
			}
		}
		System.out.println(sum);
		System.out.println("And now a list without the prime numbers:");
		for(int i = 0; i < list.size(); i++) {
			if(Q9.isPrime(list.get(i))) {
				list.remove(i);
			}
		}
		for(int num : list) {
			System.out.print(num + " ");
		}
		System.out.println();
	}
}
