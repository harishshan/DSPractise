package com.blogspot.harishshan.practise.java.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadPool1 {
	public static void main(String[] args) {
		try {
			ExecutorService executor = Executors.newFixedThreadPool(5);
			for(int i=1;i<6;i++) {
				ExampleThread  exampleThread = new ExampleThread("Thread"+i, 1, 10, 100);
				executor.execute(exampleThread);
			}
		}catch(Exception ex) {
			ex.printStackTrace();
		}
	}
}