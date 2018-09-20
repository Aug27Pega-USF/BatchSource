package com.revature.threads;

public class Driver {
	/*
	 * 2 ways to spin up a thread
	 * 1- extend Thread and overwrite Run()
	 * 2- Implement the Runnable interface and overwrite Run()
	 */

	public static void main(String[] args) {
		Thread extendThread = new ExtendThread();
		Thread implementThread= new Thread(new ImplementRunnable());
		
		//extendThread.setPriority(10);
		extendThread.start();
		implementThread.start();
		
		for(int i=0;i<100; i++) {
			System.out.println("Hello-Driver");
		}
	}

}
