package com.blogspot.harishshan.practise;

public class Queue {
	public static final int MAX = 5;
	public static Integer[] array=new Integer[MAX];
	public static int front = -1, rear = -1;
	public static void main(String arg[]) {
		enqueue(5);
		enqueue(6);
		enqueue(7);
		enqueue(8);
	}
	public static boolean isFull() {
		return (rear + 1) % MAX == front ? true : false;
	}
	public static boolean isEmpty() {
		return front == -1 && rear == -1;
	}
	public static void enqueue(int data) {
		if(isFull()) {
			System.out.println("Queue is full");
			return;
		}
		if(isEmpty())
			front = rear = 0;
		else
			rear = (rear+1)%MAX;
		array[rear] = data;
	}
	public static void dequeue() {
		if(isEmpty()) {
			System.out.println("Queue is Empty");
			return;
		}
		if(front == rear)
			rear = front = -1;
		else
			front = (front+1)%MAX;
		
	}
	public static int front() {
		if(front == -1) {
			System.out.println("Queue is Empty");
			return -1;
		}
		return array[front];
	}
	public static void print() {
		int count = (rear+MAX-front)%MAX + 1;
		for(int i=0;i<=count;i++)
			System.out.println(i+"--"+array[i]);
	}
}
