package core;

import java.util.Calendar;

public class Q14Switch {
	public void q14switch(int n) {
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
			String split= "I am learning Core Java";
			String[] strarr= split.split(" ");
			for (String a: strarr) {
				System.out.println(a);
			}
		
		}
		
	}
}
