package com.tut.lecture8;

import java.util.LinkedList;
import java.util.Random;

public class Processor {

	private LinkedList<Integer> linkedList = new LinkedList<>();
	private final int LIMIT = 10;
	private Object lock = new Object();
	
	public void produce() throws InterruptedException {
		
		int value = 0;
		System.out.println("In produce");
		while(true){
			
			synchronized (lock) {
				
				while(linkedList.size() == LIMIT){
					System.out.println("@Produce object to wait");
					lock.wait();
				}
				System.out.println("Adding to the list");
				linkedList.add(value++);
				lock.notify();
			}
		}
	}
	
	public void consume() throws InterruptedException {

		Random random = new Random();
		System.out.println("In consume");
		
		while (true) {	

			synchronized (lock) {
				while (linkedList.size() == 0) {
					System.out.println("@Consume object to wait");
					lock.wait();
				}

				System.out.print("@consume - List size: " + linkedList.size());
				System.out.println(" Removing from the list");
				Integer remove = linkedList.removeFirst();
				System.out.println("; value removed is: " + remove);
				lock.notify();
			}

			Thread.sleep(random.nextInt(1000));
		}
	}
}
