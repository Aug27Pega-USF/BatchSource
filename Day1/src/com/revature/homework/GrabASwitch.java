package com.revature.homework;

import java.util.Calendar;

public class GrabASwitch {
	public void smallSwitch(int n) {
		switch((n%3)+1){
		case 1: 
			System.out.println("The square root of " + n + " is " + Math.sqrt(n)+ ".");
			break;
		case 2: 
			  Calendar cal = Calendar.getInstance();
		      int year = cal.get(Calendar.YEAR);
		      int month = cal.get(Calendar.MONTH);
		      int day = cal.get(Calendar.DAY_OF_MONTH);
		      System.out.printf("Today's Date: %02d/%02d/%4d\n", month+1, day, year);
		      break;
		case 3:
			String s= "I am learning Core Java";
			String[] splitString= s.split(" ");
			for (String a: splitString) {
				System.out.println(a);
			}
		
		}
		
	}
}