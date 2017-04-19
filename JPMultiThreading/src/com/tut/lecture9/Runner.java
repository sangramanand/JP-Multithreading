package com.tut.lecture9;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Runner {
	
	private Integer counter = 0;
	private Lock lock = new ReentrantLock();
	
	private void increment() {
		for(int i=0;i<10000;i++){
			counter = counter+1;
		}
	}
	
	public void firstThread(){
		
		lock.lock();
		increment();
		lock.unlock();
	}
	
	public void secondThread() {
		
		lock.lock();
		increment();
		lock.unlock();
	}
	
	public void finishOperation() {
		System.out.println("The counter val is : "+counter);
	}
	
	
}
