package com.blogspot.harishshan.practise.java.thread;

import java.util.concurrent.ForkJoinPool;

//To make the JoinFork java is providing java.util.concurrent.ForkJoinPool
public class JoinFork {
	public static void main(String[] args) {
		try {
			ExampleThread  exampleThread1 = new ExampleThread("Thread1", 1, 10, 100);
			Thread exampleThread2 = new Thread(exampleThread1);
			exampleThread2.start();
		}catch(Exception ex) {
			ex.printStackTrace();
		}
	}
}