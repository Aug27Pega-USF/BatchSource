package com.revature.exception;

public class SpeedCheckException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public SpeedCheckException(int s) {
//		if(s<=50)
			System.out.println("It's no use!");
	}
	
}
