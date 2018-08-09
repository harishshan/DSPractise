package com.blogspot.harishshan.practise;

public class InfixToPostfix {

	//1. Infix To PostFix
	//2. Evaluating Postfix expression
	//3. Balanced Parantheses
	//4. GCD
	//5. https://www.geeksforgeeks.org/write-a-function-to-get-the-intersection-point-of-two-linked-lists/
	//6. BST - find successor and ancester
	public static void main(String[] args) {
		System.out.println("GCD:"+gcd(25,45));
		System.out.println("LCM:"+lcm(25,45));
		System.out.println("LCM by GCD:"+lcmbygcd(25,45));
	}
	public static int gcd(int a, int b) {
		int gcd=0;
		for(int i=1;i<=a && i<=b;i++){
	        if(a%i==0 && b%i==0)
	            gcd = i;
	    }
		return gcd;
	}
	public static int lcm(int a, int b) {
		int minMultiple = (a>b)? a:b;
	    while(true){
	        if( minMultiple%a==0 && minMultiple%b==0 )
	            break;
	        ++minMultiple;
	    }
	    return minMultiple;
	}
	public static int lcmbygcd(int a, int b) {
		return (a*b)/gcd(a,b);
	}
}
