package com.blogspot.harishshan.practise.java.thread;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class ProducerConsumerUsingBlockingQueue {

	public static void main(String[] args) {
		BlockingQueue<Integer> sharedQ = new LinkedBlockingQueue<Integer>();
		Producer p = new Producer(sharedQ);
		Consumer c = new Consumer(sharedQ);
		p.start();
		c.start();
	}
}