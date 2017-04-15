package com.tut.lecture3;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Worker {
	
	private Random random = new Random();
	private List<Integer> list1 = new ArrayList<>();
	private List<Integer> list2 = new ArrayList<>();
	
	private Object lock1 = new Object();
	private Object lock2 = new Object();
	
	private void stageOne() {

		synchronized (lock1) {
			try {
				Thread.sleep(1);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			list1.add(random.nextInt(100));
		}
	}

	private void stageTwo() {

		synchronized (lock2) {
			try {
				Thread.sleep(1);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			list2.add(random.nextInt(100));
		}
	}
	
	private void processLists() {

		for (int i = 0; i < 1000; i++) {
			stageOne();
			stageTwo();
		}

	}
	
	
	public void main(){
		System.out.println("Processing lists STARTS");
		
		Thread t1 = new Thread(new Runnable() {
			
			@Override
			public void run() {
				processLists();
			}
		});
		
		Thread t2 = new Thread(new Runnable() {

			@Override
			public void run() {
				processLists();
			}
		});

		t1.start();
		t2.start();
		
		long startTime = System.currentTimeMillis();
		try {
			t1.join();
			t2.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		long endTime = System.currentTimeMillis();
		System.out.println("Time Taken - "+ (endTime-startTime));
		System.out.println("List1 size is : "+list1.size()+" --- List2 size is :"+list2.size());
	}
}
