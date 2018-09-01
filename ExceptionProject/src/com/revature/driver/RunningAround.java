package com.revature.driver;

import com.revature.exception.SpeedCheckException;
 
public class RunningAround {
	public static void main(String[] args) {
		int s = 100;
		try {
			System.out.println(s-=60);
		}
		catch (SpeedCheckException e) {
			System.out.println(e);
		}
		finally {
			System.out.println("Get outta there!");
		}
	}
}
