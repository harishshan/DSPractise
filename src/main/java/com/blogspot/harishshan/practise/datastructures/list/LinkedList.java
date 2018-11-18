package com.blogspot.harishshan.practise.datastructures.list;

/**
 * Hello world!
 *
 */
public class LinkedList 
{
    public static void main( String[] args )
    {
        try {
        	Node head = null;
        	head = new Node(5);
        	sortedInsert(head, new Node(8));
        	sortedInsert(head, new Node(12));
        	sortedInsert(head, new Node(24));
        	sortedInsert(head, new Node(6));
        	sortedInsert(head, new Node(18));
        	sortedInsert(head, new Node(27));
        	printList(head);
        	//deleteNode(head, head.next.next); // uncomment to delete the node
        	printList(head);
        	alternateReverseAlternate(head, head.next);
        	findMid(head);
        	int lenght = findLength(head);
        	printNthFromLast(head, lenght, 2);
        	Node last = findLast(head);
        	//last.next=head; //uncomment to make it as loop
        	System.out.println(detectLoop(head));
        	System.out.println(maxSumSubArray(4));
        }catch(Exception ex) {
        	System.out.println(ex);
        }
    }
    public static void sortedInsert(Node _head, Node newNode) {
    	Node current;
    	if(_head == null || _head.data >= newNode.data) {
    		newNode.next = _head;
    		_head = newNode;
    	} else {
    		current = _head;
    		while(current.next!=null && current.next.data < newNode.data) {
    			current = current.next;
    		}
    		newNode.next = current.next;
    		current.next = newNode;
    	}
    }
    public static void printList(Node _head) {
    	Node temp = _head;
    	while(temp!=null) {
    		System.out.print(temp.data+" ");
    		temp = temp.next;
    	}
    	System.out.println();
    }
    public static void deleteNode(Node _head, Node node) {
    	if(_head == node) {
    		if(_head.next == null) 
    			return;
    		_head.data = _head.next.data;
    		_head.next = _head.next.next;
    		return;
    	}
    	Node cursor = _head;
    	while(cursor.next !=null && cursor.next !=node)
    		cursor = cursor.next;
    	if(cursor.next == null)
    		return;
    	cursor.next = cursor.next.next;
    	return;
    }
    public static int compare(Node list1, Node list2) {
    	while(list1 != null && list2 != null && list1.data == list2.data) {
    		list1 = list1.next;
    		list2 = list2.next;
    	}
    	if (list1 != null && list2 != null) 
            return (list1.data > list2.data)? 1: -1;
    	if (list1 != null && list2 == null)
    		return 1;
        if (list2 != null && list1 == null)
        	return -1;
        return 0;
    }
    
    public static void alternateReverseAlternate(Node head, Node next){
        if (head == null) {
            return;
        }
        if(head != null)
        	System.out.println(head.data);
        if(next!=null && next.next!=null)
        	alternateReverseAlternate(next.next, next.next.next);
        if(next!=null)
        	System.out.println(next.data);
    }
    public static void findMid(Node head) {
    	Node slowCurser = head;
    	Node fastCurser = head;
    	while(fastCurser != null && fastCurser.next != null) {
    		fastCurser = fastCurser.next.next;
    		slowCurser = slowCurser.next;
    	}
    	System.out.println(slowCurser.data);
    }
    public static int findLength(Node head) {
    	int len=0;
    	Node temp = head;
    	while(temp != null) {
    		temp = temp.next;
    		len++;
    	}
    	return len;
    }
    public static void printNthFromLast(Node head, int len, int n) {
        if (len < n)
            return;
        Node temp = head;
        for (int i = 1; i < len-n+1; i++)
            temp = temp.next;
        System.out.println(temp.data);
    }
    public static boolean detectLoop(Node node) {
    	Node slowCurser = node;
    	Node fastCurser = node;
    	while(slowCurser != null && fastCurser != null && fastCurser.next!=null) {
    		slowCurser = slowCurser.next;
    		fastCurser = fastCurser.next.next;
    		if(slowCurser == fastCurser)
    			return true;
    	}
    	return false;
    }
    public static Node findLast(Node _head) {
    	if(_head == null)
    		return null;
    	Node previous = _head;
    	Node temp = _head;
    	while(temp.next!=null) {
    		previous = temp;
    		temp = temp.next;
    	}
    	return temp;
    }
    public static int maxSumSubArray(int n) {
    	int arr[] = {10,12,32,34,42,153,163};
    	int maxsum=0;
    	for(int i=0;i<arr.length-(n-1);i++) {
    		maxsum=Math.max(sumSubArray(arr,i,n), maxsum);
    	}
    	return maxsum;
    }
    public static int sumSubArray(int arr[], int start,int count) {
    	int sum=0;
    	for(int i=start;i<start+count;i++)
    		sum = sum+arr[i];
    	return sum;
    }
}
class Node{
	public int data;
	public Node next;
	public Node(int _data) {
		this.data = _data;
		this.next = null;
	}
	public Node(int _data, Node _node) {
		this.data = _data;
		this.next = _node;
	}
	@Override
	public String toString() {
		return ""+data;
	}
}
