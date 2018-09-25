package com.revatue.pcprolem;

import java.util.concurrent.BlockingQueue;

public class Consumer {
	private BlockingQueue<Message> queue;
	private String name;
	public Consumer(BlockingQueue<Message> queue, String name) {
		super();
		this.queue = queue;
		this.name = name;
	}
	
}
