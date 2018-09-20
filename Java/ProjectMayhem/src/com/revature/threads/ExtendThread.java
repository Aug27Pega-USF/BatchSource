package com.revature.threads;

public class ExtendThread extends Thread{
	
@Override
 public void run() {
	 super.run();
	 for(int i =0; i<100;i++) {
		 System.out.println("\t\t Hi -ExtendThread");
	 }
 }
}
