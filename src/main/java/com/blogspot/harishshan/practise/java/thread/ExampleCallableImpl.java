package com.blogspot.harishshan.practise.java.thread;

import java.util.concurrent.Callable;

public class ExampleCallableImpl implements Callable<Integer>{
	int minValue, maxValue, sleepMillisecond;
	String command;
	
	public ExampleCallableImpl(String _command, int _minValue, int _maxValue,int _sleepMillisecond) {
		this.command = _command;
		this.minValue = _minValue;
		this.maxValue = _maxValue;
		this.sleepMillisecond = _sleepMillisecond;
	}

	public Integer call() throws Exception {
		Integer count=0;
		try {
			System.out.println(Thread.currentThread().getName()+" Start, Command = "+command);
			for(int i=minValue;i<maxValue;i++) {
				count+=i;
				Thread.sleep(sleepMillisecond);
			}
			System.out.println(Thread.currentThread().getName()+" End, Command = "+command);
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		return count;
	}
}