package com.revature.threads;

public class Main {

	public static void main(String[] args) {
		/*
		 *  	2 ways to spin up a Thread
		 *  
		 *  1. Extend Thread overwrite Run()
		 *  2. implement Runnable overwrite Run()
		 *  
		 */
		//Thread's run method is no-op or no operations
		 Thread myThread = new Thread();
		 
		 Thread printFromOther = new PrintFromOtherThread();
		 
//		 Runnable job = new OverwriteRun();
		 Thread fromRunnableClass = new Thread(new OverwriteRun());
		 
		 
		 
		 printFromOther.setPriority(10);
		 
		 fromRunnableClass.start();
		 printFromOther.start();

		for (int i = 0; i < 10; i++) {
			System.out.println("Hello -Main Thread");
		}
	}

}
