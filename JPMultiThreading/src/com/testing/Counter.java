package com.testing;

public class Counter {

	private static volatile Integer counter = 0;
	
	public synchronized static void increment(){
		counter = counter+1;
	}
	
	public static Integer getCounterValue(){
		return counter;
	}
}
