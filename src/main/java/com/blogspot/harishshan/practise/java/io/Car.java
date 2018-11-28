package com.blogspot.harishshan.practise.java.io;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

public class Car implements Externalizable {
	static int age;
	String name;
	int year;

	public Car() {
	}

	public Car(String n, int y) {
		name = n;
		year = y;
		age = 10;
	}
	public void writeExternal(ObjectOutput out) throws IOException {
		out.writeObject(name);
		out.writeInt(age);
		out.writeInt(year);
	}
	public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
		name = (String) in.readObject();
		year = in.readInt();
		age = in.readInt();
	}
	public String toString() {
		return ("Name: " + name + "\n" + "Year: " + year + "\n" + "Age: " + age);
	}
}