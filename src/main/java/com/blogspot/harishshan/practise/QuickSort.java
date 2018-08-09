package com.blogspot.harishshan.practise;

public class QuickSort {
	public static int[] input = {24, 2, 35, 14, 15, 25, 8, 9, 32};
	public static void main(String[] args) {
		printArray();
		quickSort(0, input.length - 1); // 0, 8-1=7
		
	}
	public static void quickSort(int low, int high) {
	    if(low < high)
	    {
	        int pivot = input[low];//assign first element as pivot
	        int i = low+1; // assign second index
	        int j = high;
	        while(i <= j)
	        {
	            while((i <= high) && (input[i] <= pivot))//traversing(i) from second index to last if the values are less than first element 
	                i++;
	            while((j >= low) && (input[j] > pivot))//reverseTraversing(j) from last to second index and if the values are greater than first element
	                j--;
	            if( i < j) {
	            	System.out.println("IF");
	                swap(i, j);//Swapping only when i<j means i and j not crossed while traversing
	            }
	        }
	        swap(low, j);//Swapping first element with J(lowest value)
	        quickSort(low, j-1);
	        quickSort(j+1, high);
	    } 
	}
	public static void printArray() {
		for(int i=0;i<input.length;i++) {
			System.out.print(input[i]+ " ");
		}
		System.out.println(" ");
	}
	public static void swap(int i, int j) {
		System.out.println("Swapping:"+input[i]+" for "+input[j]);
		int temp = input[i];
		input[i] = input[j];
		input[j] = temp;
		printArray();
	}
}
