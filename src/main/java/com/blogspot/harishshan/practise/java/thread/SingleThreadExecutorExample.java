package com.blogspot.harishshan.practise.java.thread;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class SingleThreadExecutorExample {
	public static void main(String[] args) {
		try {
			List<Future<Integer>> futureList = new ArrayList<Future<Integer>>(2);
			ExecutorService executorService = Executors.newSingleThreadExecutor();
			for(int i=0;i<2;i++) {
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