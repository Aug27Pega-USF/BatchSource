package com.revatue.pcprolem;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class PCMain {

		public static void main(String[] args) {
			BlockingQueue<Message> queue = new ArrayBlockingQueue<Messaage>(10);
			Producer producer= new Producer(queue);
			Consumer consumer1 = new Consumer(queue, "Consumer 1");
			Consumer consumer2 = new Consumer(queue, "Consumer 2");
			Consumer consumer3 = new Consumer(queue, "Consumer 3");
			Consumer consumer4 = new Consumer(queue, "Consumer 4");
			
			new Thread(producer).start();
			new Thread(consumer1).start();
			new Thread(consumer2).start();
			new Thread(consumer3).start();
			Thread t = new Thread(consumer4);
			t.setPriority(10);
			t.start();
			System.out.println("Producers and consumers have been started");
			
		}
}
