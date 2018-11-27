package com.blogspot.harishshan.practise.java.thread;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ForkJoinPool;

//To make the JoinFork java is providing java.util.concurrent.ForkJoinPool
public class ForkJoinPoolExample {
	public static void main(String[] args) {
		try {
			List<Integer> list = new ArrayList<Integer>(25);
	        for (int i=0; i<25; i++){
	        	list.add((int) (Math.random() * 1000));
	        }
	        //Using RecursiveAction for Quick Sort Problem
	        QuickSortRecursiveActionImpl quickSortRecursiveActionImpl = new QuickSortRecursiveActionImpl(list, 0, list.size()-1);
			ForkJoinPool forkJoinPool1 = new ForkJoinPool();//For Java 8 use ForkJoinPool forkJoinPool = ForkJoinPool.commonPool();
			forkJoinPool1.invoke(quickSortRecursiveActionImpl);
			
			for(Integer i: list) {
				System.out.println(i);
			}
			
			//Using RecursiveTask for Summation Problem
			ForkJoinPool forkJoinPool2 = new ForkJoinPool();
			SummationRecursiveTaskImpl summationRecursiveTaskImpl = new SummationRecursiveTaskImpl(list, 0, list.size()-1);
		    Integer summationResult = forkJoinPool2.invoke(summationRecursiveTaskImpl);
		    System.out.println(summationResult);
			
		}catch(Exception ex) {
			ex.printStackTrace();
		}
	}
}