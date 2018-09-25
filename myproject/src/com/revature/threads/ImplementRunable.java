package com.revature.threads;

public class ImplementRunable implements Runnable{
	@Override
	public void run() {
		for(int i = 0; i < 5; i++) {
			System.out.println("\t\t\t\t What's up - ImplementsRunnable");
		}
	}

}
