package com.blogspot.harishshan.practise.java.thread;

import java.util.List;
import java.util.concurrent.RecursiveTask;

public class SummationRecursiveTaskImpl extends RecursiveTask<Integer>{
	List<Integer> data;
	int low, high; //Low index and HighIndex

	public SummationRecursiveTaskImpl(List<Integer> _data, int _low, int _high) {
		this.data = _data;
		this.low = _low;
		this.high = _high;
	}

	@Override
	protected Integer compute() {
		System.out.println("Compute low:"+low+", high:"+high);
		int size = high-low;
		if (size < 3) {//minimum of two elements
			int summation = 0;			
			for(int i=low; i<high; i++) {
				summation += data.get(i);
			}
			return summation;
		}else {
			int middle = low + ((high-low) / 2);
			SummationRecursiveTaskImpl summationRecursiveTaskImpl1 = new SummationRecursiveTaskImpl(data, low, middle);
			summationRecursiveTaskImpl1.fork();
			SummationRecursiveTaskImpl summationRecursiveTaskImpl2 = new SummationRecursiveTaskImpl(data, middle+1, high);
			return summationRecursiveTaskImpl2.compute() + summationRecursiveTaskImpl1.join();			
		}
	}
}