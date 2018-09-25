package com.revature.enhance;

public class EnhanceForLoop {

	public static void main(String[] args) {
		int [] arr = new int[100];
		
		for(int i = 1; i < arr.length; i++) {
			arr[i] = i;
		}
		
		/*for(int i = 1; i < arr.length; i++) {
			System.out.print(i);		
			}*/
		
		
		for(int j : arr) {
			System.out.print(j);
		}
	}

}
