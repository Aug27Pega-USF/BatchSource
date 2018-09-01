package com.driver.questions;

public class Q13 {
	/*
	 * Q13: Display the triangle on the console as follows using any type of loop.  
	 * Do NOT use a simple group of print statements to accomplish this.
	 *  0
		1 0
		1 0 1
		0 1 0 1
	 */
	public static void question() {
		boolean on = false;
		int disp = 0;
		
		int rows = 4;
		int columns = 1;
		
		//looping through each row
		for(int i = 0; i < rows; i++) {
			//drawing each number
			for(int j = 0; j < columns; j++) {
				//alternate 1 and 0
				if (on)
					disp = 1;
				else
					disp = 0;
				on = !on;
				//display
				System.out.print(" " + disp);
			}
			//extra column per row
			columns++;
			//spacing for next row
			System.out.println();
		}
	}
}
