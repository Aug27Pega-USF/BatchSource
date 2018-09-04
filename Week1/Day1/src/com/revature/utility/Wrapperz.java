package com.revature.utility;

public class Wrapperz {

static int myInt=5;
static Integer myInteger=5;
static Integer yourInteger=5;
static Double myDouble=4.5431;
static Boolean myBool=true;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		funky(myInt,myInteger);
		funky2(myInt, yourInteger);
		funky2(myInteger, yourInteger);
		
	}
	
	static public void funky(int a, int b)
	{
		if(a==b) {
			System.out.println("Roll Tide");
		}
		else{
			System.out.println("Well Dern");
		}
	}
	
	static public void funky2(Integer a, Integer b)
	{
		if(a.equals(b)) {
			System.out.println("Roll Tide");
		}
		else{
			System.out.println("Well Dern");
		}
	}
}
