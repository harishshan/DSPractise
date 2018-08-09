package com.blogspot.harishshan.practise;

public class Stack {
	public static final int MAX = 5;
	public static Integer[] array=new Integer[MAX];
	public static int top=-1;
	public static void main(String arg[]) {
		push(5);
		push(7);
		push(6);
		push(3);
		push(7);
		print();
		push(8);
		pop();
		print();		
	}
	public static void pop() {
		if(top == -1) {
			System.out.println("Stack Empty");
			return;
		}
		array[top]=null;
		top--;
	}
	public static void push(int data) {
		if(top == MAX-1) {
			System.out.println("Stack Overflow");
			return;
		}
		array[++top] = data;
	}
	public static int top() {
		return array[top];
	}
	public static boolean isEmpty() {
		if(top == -1)
			return true;
		return false;
	}
	public static void print() {
		for(int i=0;i<=top;i++)
			System.out.println(i+"--"+array[i]);
	}
}
