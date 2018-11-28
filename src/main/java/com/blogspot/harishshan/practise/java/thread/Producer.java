package com.blogspot.harishshan.practise.java.thread;

import java.util.concurrent.BlockingQueue;

public class Producer extends Thread {
	private BlockingQueue<Integer> sharedQueue;

	public Producer(BlockingQueue<Integer> aQueue) {
		this.sharedQueue = aQueue;
	}
	public void run() {
		for (int i = 0; i < 10; i++) {
			try {
				System.out.println("Produced: " + i);
				sharedQueue.put(i);
				//Thread.sleep(1);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}