package com.blogspot.harishshan.practise.java.string;

public class ReverseString {

	public static StringBuffer s = new StringBuffer("position     1 no. @ durga is This");
	public static void main(String[] args) {
		System.out.println(s );
		int i=0,j=0,w=0;
		while(i<s.length()) {
			if(s.charAt(i) == ' ' || i==s.length()-1) {
				j=i;//end pointer
				if(i == s.length()-1)
					j=i;
				else
					j--;
				swap(w,j);
				w=i+1;//start pointer
			}
			i++;
		}
		System.out.println(s);
		swap(0, s.length()-1);
		System.out.println(s);
	}
	
	public static void swap(int i, int j) {
		while(i<j) {
			char ch = s.charAt(i);
			s.setCharAt(i, s.charAt(j));
			s.setCharAt(j, ch);
			i++;
			j--;
		}
	}

}
