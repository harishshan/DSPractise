package com.blogspot.harishshan.practise.java.thread;

import java.util.List;
import java.util.concurrent.RecursiveAction;

//Before seeing this program, first check how quick sort works and then come here 
public class QuickSortRecursiveActionImpl extends RecursiveAction {
	//There is another class called RecursiveTask<Integer> can be used to return values from compute

	List<Integer> data;
	int low, high; //Low index and HighIndex

	public QuickSortRecursiveActionImpl(List<Integer> _data, int _low, int _high) {
		this.data = _data;
		this.low = _low;
		this.high = _high;
	}

	@Override
	protected void compute() {
		System.out.println("Compute low:"+low+", high:"+high);
		if (low < high) {
			int pivot = data.get(low);//assign first element as pivot
			int i = low+1; // assign second index
	        int j = high;
	        while(i <= j)
	        {
	            while((i <= high) && (data.get(i) <= pivot))//traversing(i) from second index to last if the values are less than first element 
	                i++;
	            while((j >= low) && (data.get(j) > pivot))//reverseTraversing(j) from last to second index and if the values are greater than first element
	                j--;
	            if( i < j) {
	                swap(i, j);//Swapping only when i<j means i and j not crossed while traversing
	            }
	        }
	        swap(low, j);//Swapping first element with J(lowest value)
			invokeAll(new QuickSortRecursiveActionImpl(data, low, j - 1), new QuickSortRecursiveActionImpl(data, j + 1, high));
		}
	}

	public void swap(int i, int j) {
		System.out.println("Swapping:"+i+" for "+ j);
		int temp = data.get(i);
		data.set(i, data.get(j));
		data.set(j, temp);
	}	
}