package com.revature.pcproblem;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class PCMain {

	public static void main(String[] args) {

		BlockingQueue<Message> queue =
				new ArrayBlockingQueue<Message>(10);
		Producer producer =  new Producer(queue);
		Consumer consumer =  new Consumer(queue,"Consumer 1");
		Consumer consumer2 =  new Consumer(queue,"Consumer 2");
		Consumer consumer3 =  new Consumer(queue,"Consumer 3");
		Consumer consumer4 =  new Consumer(queue,"Consumer 4");
		Consumer consumer5 =  new Consumer(queue,"Consumer 5");
		
		new Thread(producer).start();
		Thread t=new Thread(consumer);
		t.setPriority(10);
		t.start();
		new Thread(consumer2).start();
		new Thread(consumer3).start();
		new Thread(consumer4).start();
		new Thread(consumer5).start();
		System.out.println("Producer and consumers have been started...");
		
	}

}
