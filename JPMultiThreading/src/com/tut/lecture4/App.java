package com.tut.lecture4;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

class Processor implements Runnable {
	
	private Integer id;
	
	public Processor(Integer id) {
		this.id = id;
	}

	@Override
	public void run() {
		System.out.println("Starting "+id);
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("Completed "+id);
	}
	
}


public class App {

	public static void main(String[] args) {
		
		ExecutorService exec = Executors.newFixedThreadPool(2);
		
		for(int i=0;i<5;i++){
			exec.submit(new Processor(i));
		}
		
		exec.shutdown();
		
		System.out.println("All tasks submitted!!!");
		
		try {
			exec.awaitTermination(1, TimeUnit.HOURS);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println("All tasks completed!!!");
	}

}
