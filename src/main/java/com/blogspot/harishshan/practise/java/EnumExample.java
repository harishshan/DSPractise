package com.blogspot.harishshan.practise.java;

public class EnumExample {
	public static void main(String[] args) {
		for (StateEnum state : StateEnum.values()) {
			if(state == StateEnum.ACTIVE) {
				System.out.println(state);	
			}			
		}
	}
}