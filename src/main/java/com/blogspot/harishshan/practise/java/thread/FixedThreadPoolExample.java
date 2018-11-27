package com.blogspot.harishshan.practise.java.thread;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

//Executor, a simple interface that supports launching new tasks.
//ExecutorService, a subinterface of Executor, which adds features that help manage the lifecycle, both of the individual tasks and of the executor itself.
//ScheduledExecutorService, a subinterface of ExecutorService, supports future and/or periodic execution of tasks.

public class FixedThreadPoolExample {
	//an executor that uses a fixed thread pool
	public static void main(String[] args) {
		try {			
			List<Future<Integer>> futureList = new ArrayList<Future<Integer>>(5);
			ExecutorService executorService = Executors.newFixedThreadPool(5);
			for(int i=0;i<5;i++) {
				int j=i+1;
				ExampleRunnableImpl  exampleRunnableImpl = new ExampleRunnableImpl("RunnableThread"+j, 1*j, 10*j, 100);
				executorService.execute(exampleRunnableImpl);
				
				ExampleCallableImpl exampleCallableImp = new ExampleCallableImpl("CallableThread"+j, 1*j, 10*j, 100);
				futureList.add(executorService.submit(exampleCallableImp));
			}
			for(Future future: futureList) {
				System.out.println("Future:"+future.get());
			}
		}catch(Exception ex) {
			ex.printStackTrace();
		}
	}
}