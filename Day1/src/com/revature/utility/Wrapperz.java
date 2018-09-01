package com.revature.utility;

public class Wrapperz {

	static int myInt = 5;
	static Integer myInteger = 5;
	static Integer yourInteger = 5;
	static Double myDouble = 4.5673;
	static Boolean myBool = true;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		funky2(myInt, myInteger);
		funky2(myInteger, yourInteger);
	}
	public static void funky(int a, int b) {
		if(a==b) {
			System.out.println("That was Cool!");
		}
		else
		{
			System.out.println("I'm done hanging out with the likes of you");
		}
	}
	public static void funky2(Integer a, Integer b) {
		if(a.equals(b)) {
			System.out.println("That was Cool!");
		}
		else
		{
			System.out.println("Who the f!@K are you talking to?");
		}
	}
}
