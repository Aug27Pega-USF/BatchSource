package com.revature.runtime;

public class AuthenticationException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public AuthenticationException() {
		System.out.println("Wrong username");
	}
}
