package com.revature.utility;

public class Wrapperz {
	static Integer myInt=3;
	static Integer myInteger=5;
	static Integer yourInteger=5;
	static int aint=2;
	static int bint=3;
	static Double myDouble=4.5431;
	static Boolean myBool=true;
	
	static public void main(String[] args) {
		// TODO Auto-generated method stub
		funky(myInteger,myInteger);
	}
	
	/*static public void funky(Integer a, Integer b) {
		 System.out.println("Integer");
	}*/
	
	static public void funky(int a, int b) {
		 System.out.println("int");
	}
	 
	 static public void funky(double a, double b) {
		 System.out.println("double");
	 }
	 static public void funky(int...a) {
		 System.out.println("varargs");
	 }
	 
	 
	 static public void funky(double...a) {
		 System.out.println("varargs double");
	 }	 
	 
}
