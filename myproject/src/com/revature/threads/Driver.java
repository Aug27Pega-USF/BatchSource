package com.revature.threads;

public class Driver {
	
	/*
	 * Two ways to spin up a thread
	 * 	1- extend thread and overwrite Run()
	 * 	2- Implement theTunnable interface and overwrite Run()
	 */

	public static void main(String[] args) {
		Thread extendThread = new ExtendThread();
		Thread implementThread = new Thread(new ImplementRunable());
		
		extendThread.setPriority(10);
		extendThread.start();
		implementThread.start();
		
		for(int i = 0; i < 5; i++) {
			System.out.println("Hello Driver");
		}
	}

}
