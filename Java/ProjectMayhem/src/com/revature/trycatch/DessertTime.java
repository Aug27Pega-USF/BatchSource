package com.revature.trycatch;

public class DessertTime {

	public static void main(String[] args) {
		finallyExample();
	}
	public static void finallyExample() {
		System.out.println("trying code");
		try {
		int [] arr =  new int [4];
		arr[3]=5;
		System.out.println("no exception thrown");
		}catch (Exception e){
			System.out.println("Caught Exception");
		}finally {//finally block will always run
			System.out.println("Finally");
		}
	}
}
