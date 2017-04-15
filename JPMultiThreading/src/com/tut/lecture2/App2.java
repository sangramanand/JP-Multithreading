package com.tut.lecture2;

public class App2 {
	
	public static void main(String args[]){
		
		Thread proc1 = new Thread(new MessageProcessor());
		Thread proc2 = new Thread(new MessageProcessor());
		
		proc1.start();
		
		proc2.start();
		
	}
}

class MessageProcessor implements Runnable {

	private boolean running = true;
	private volatile Integer counter = 0;
	
	@Override
	public void run() {
		String currentThreadName = Thread.currentThread().getName();
		while(running){
			counter++;
			System.out.println(currentThreadName+"count value"+counter);
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
