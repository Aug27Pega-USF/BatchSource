package com.revature.homework;

import java.util.ArrayList;

public class Prime {
	
	public ArrayList<Integer> myPrime(ArrayList<Integer> list) {
		ArrayList<Integer> result = new ArrayList<Integer>();
		for (int i=1; i<101; i++) {
			int num = list.get(i-1);
			
				boolean prime=true;
				if (num==1)
					continue;
				for (int j=2; j <= Math.sqrt(num);j++) {
					if (num/j*j == num && j!=num) {
						prime=false;
					}
					continue;
				}
				if (prime) {
				result.add(i);
				}
			}
			return result;
		}
}
