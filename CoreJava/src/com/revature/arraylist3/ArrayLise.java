package com.revature.arraylist3;

import java.util.ArrayList;
import java.util.List;

public class ArrayLise {

	public static void main(String[] args) {
		List<Integer> arrInt = new ArrayList<Integer>(10);
		System.out.println("The ArrayList values: ");
		for(int i= 0; i < 10; i++) {
			arrInt.add(i);
			System.out.print(" "+ arrInt.get(i));
		}
			System.out.println();
			int sum = 0;
			int sumO = 0;
		for(int j = 0; j < 10; j++) {
			if(arrInt.get(j) % 2 == 0) {
				sum += arrInt.get(j);
			}else {
				sumO += arrInt.get(j);
			}
		}
		System.out.println("sum of the even = " +sum);
		System.out.println("sum of the odd = " +sumO);
		
		System.out.println("list of odd values: ");
		for(int k = 0; k < 10; k++) {
			if(arrInt.get(k) % 2 != 0) {
				System.out.print(" " +arrInt.get(k));
			}
		}
		}
		
	

}
