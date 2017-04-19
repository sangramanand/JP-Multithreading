package com.tut.lecture9;

public class App {

	public static void main(String[] args) {

		final Runner runner = new Runner();

		Thread t1 = new Thread(new Runnable() {

			@Override
			public void run() {
				runner.firstThread();
			}
		});

		Thread t2 = new Thread(new Runnable() {

			@Override
			public void run() {
				runner.firstThread();
			}
		});
		
		t1.start();
		t2.start();
		
		try {
			t1.join();
			t2.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		runner.finishOperation();

	}

}
