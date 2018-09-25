package com.revature.utility;

public class WrapperZ{
	
	static int myInt = 5;
	static Integer myInteger = 5;

	public static void main(String[] args) {
	daMethadDo(myInt, myInteger);
	}
	
	static public void daMethadDo(int a , int b) {
		if(a == b) {
			System.out.println("Roll tide!");
		}else {
			System.out.println("well , dern");
		}
	}

}
