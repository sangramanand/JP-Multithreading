package com.tut.lecture13;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

public class App {

	//semaphore are used to control access to some resource
	public static void main(String[] args) throws InterruptedException {
		
//		Semaphore sem = new Semaphore(1);
//		sem.release();
//		sem.acquire();
//		System.out.println("Available permits = "+sem.availablePermits());
		
		ExecutorService executor = Executors.newCachedThreadPool();
		
		for(int i=0;i<200;i++){
			executor.submit(new Runnable() {
				
				@Override
				public void run() {
					Connection.getInstance().connect();
				}
			});
		}
		
		executor.shutdown();
		executor.awaitTermination(1, TimeUnit.DAYS);
	}

}
