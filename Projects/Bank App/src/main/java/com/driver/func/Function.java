package com.driver.func;

import java.util.Scanner;

public class Function {
	
	public static String GetMenuSelection(Scanner s, int total_options) {
		//loop until we get a string pertaining to one of the options
		boolean valid_value = false;
		
		String result = "";
		
		while(!valid_value) {
			//get input
			result = s.next();
			
			for(int i = 1; i <= total_options && !valid_value; i++) {
				if(result.contains(Integer.toString(i))) {
					valid_value = true;
					result = Integer.toString(i); //just return the value we want
				}
			}
			
			//prompt if they mess up
			if(!valid_value)
				System.out.println("Please pick an option from 1 to " + total_options);
		}
		
		return result;
	}
}
