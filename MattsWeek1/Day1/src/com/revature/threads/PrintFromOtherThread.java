package com.revature.threads;

public class PrintFromOtherThread extends Thread {

	@Override
	public void run() {
		
		//Send email
		super.run();
		for (int i = 0; i < 10; i++) {
			System.out.println("\t\t Hi -Other Thread");
		}
		
	}
}