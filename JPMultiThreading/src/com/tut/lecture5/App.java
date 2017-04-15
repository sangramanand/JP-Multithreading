package com.tut.lecture5;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class Processor implements Runnable {
	
	private CountDownLatch latch;
	
	public Processor(CountDownLatch latch) {
		this.latch = latch;
	}

	@Override
	public void run() {
		
		System.out.println(Thread.currentThread().getName() +" STARTED");
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		latch.countDown();
		System.out.println("Latch count - "+latch.getCount());
	}
	
}


public class App {

	public static void main(String[] args) {
		
		System.out.println(Thread.currentThread().getName()+" Started");
		CountDownLatch countDownLatch= new CountDownLatch(3);
		ExecutorService executorService = Executors.newFixedThreadPool(3);
		
		for(int i=0;i <3;i++){
			executorService.submit(new Processor(countDownLatch));
		}
		
		try {
			countDownLatch.await();
			executorService.shutdown();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		System.out.println(Thread.currentThread().getName()+" Completed");
	}

}








