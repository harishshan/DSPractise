package com.blogspot.harishshan.practise.java.io;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class ExternalizableExample {

	public static void main(String[] args) {
		Car car = new Car("Shubham", 1995);
		Car newcar = null;
		try {
			FileOutputStream fos = new FileOutputStream("gfg.txt");
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(car);
			oos.flush();
		} catch (Exception e) {
			System.out.println(e);
		}

		// Deserialize the car
		try {
			FileInputStream fis = new FileInputStream("gfg.txt");
			ObjectInputStream ois = new ObjectInputStream(fis);
			newcar = (Car) ois.readObject();
		} catch (Exception e) {
			System.out.println(e);
		}
		System.out.println("The original car is:\n" + car);
		System.out.println("The new car is:\n" + newcar);
	}
}