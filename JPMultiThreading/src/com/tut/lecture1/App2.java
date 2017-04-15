package com.tut.lecture1;

class RunnerTwo implements Runnable{

	@Override
	public void run() {
		
		String threadName = Thread.currentThread().getName();
		for(int i=0;i<10;i++){
			System.out.println(threadName+"- Hello "+i);
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
}


public class App2 {

	public static void main(String[] args) {
		Thread t1 = new Thread(new RunnerTwo());
		t1.start();
		
		Thread t2 = new Thread(new RunnerTwo());
		t2.start();
	}
}
