package com.testing;

public class SynchronizedDemo {

	public static void main(String[] args) {
		Thread t1 = new Thread(new Task());
		Thread t2 = new Thread(new Task());
		
		t1.start();
		t2.start();
		
		try {
			t1.join();
			t2.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println(Counter.getCounterValue());
	}
	

}

class Task implements Runnable {

	@Override
	public void run() {
		for(int i=0; i < 1000; i++){
			Counter.increment();
		}
	}
	
}
