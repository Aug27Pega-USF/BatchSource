package com.revature.utility;

public class Wrapperz {
	static int myInt=5;
	static Integer myInteger=5;
	static Integer yourInteger=5;
	
	
	
	
	public static void main(String[] args) {
	datMethodDo(myInt,myInteger);
		
	}
	
	static public void datMethodDo(int a, int b) {
		if(a==b) {
			System.out.println("roll tide!");
		}else {
			System.out.println("well,dern");
		}
	}
	static public void datMethodDo2(Integer a, Integer b) {
		if(a.equals(b)) {
			System.out.println("roll tide!");
		}else {
			System.out.println("well,dern");
		}
	}
}
