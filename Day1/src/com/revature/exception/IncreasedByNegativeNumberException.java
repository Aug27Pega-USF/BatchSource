package com.revature.exception;

public class IncreasedByNegativeNumberException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public IncreasedByNegativeNumberException(int x)  {
		if (x < 0) {
			throw new IncreasedByNegativeNumberException(x);
		}
		System.out.println("Nice try idiot");
	}

}
