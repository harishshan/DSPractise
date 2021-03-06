package com.blogspot.harishshan.practise.java.thread;

public class ExampleRunnableImpl implements Runnable{
	int minValue, maxValue, sleepMillisecond;
	String command;
	
	public ExampleRunnableImpl(String command, int minValue, int maxValue,int sleepMillisecond) {
		this.command = command;
		this.minValue = minValue;
		this.maxValue = maxValue;
		this.sleepMillisecond = sleepMillisecond;
	}
	
	public void run() {
		try {
			System.out.println(Thread.currentThread().getName()+" Start, Command = "+command);
			for(int i=minValue;i<maxValue;i++) {
				System.out.println(command+" - " + i);
				Thread.sleep(sleepMillisecond);
			}
			System.out.println(Thread.currentThread().getName()+" End, Command = "+command);
		}catch(Exception ex) {
			ex.printStackTrace();
		}
	}
}