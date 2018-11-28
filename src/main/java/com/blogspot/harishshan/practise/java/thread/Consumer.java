package com.blogspot.harishshan.practise.java.thread;

import java.util.concurrent.BlockingQueue;

public class Consumer extends Thread{
	private BlockingQueue<Integer> sharedQueue;

	public Consumer(BlockingQueue<Integer> aQueue) {
		this.sharedQueue = aQueue;
	}

	public void run() {
		try {
			while (true) {
				Integer item = sharedQueue.take();
				System.out.println("Consumed: " + item);			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}