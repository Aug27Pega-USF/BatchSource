package com.revature.exceptions;

public class NameNotFoundException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public NameNotFoundException() {
		System.out.println("Name Not Found");
	}

}
