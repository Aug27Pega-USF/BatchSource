package com.revature.pcproblem;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class PCMain {

	public static void main(String[] args) {

		BlockingQueue<Message> queue = new ArrayBlockingQueue<>(10);
		Producer producer = new Producer(queue);
		Consumer consumer = new Consumer(queue, "Consumer 1");
		Consumer consumer2 = new Consumer(queue, "Consumer 2");
		
		//Starting threads
		new Thread(producer).start();
		
		Thread t = new Thread(consumer);
		t.setPriority(10);
		t.start();
		new Thread(consumer2).start();
		System.out.println("Producer and Consumers have been started... ");
	}

}
