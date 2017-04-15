package com.tut.lecture1;

class Runner extends Thread {

	@Override
	public void run() {
		
		String threadName = Thread.currentThread().getName();
		for(int i = 0; i <10; i++) {
			
			System.out.println(threadName+" Hello " +i);
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	
}



public class App {
	
	public static void main(String args[]){
		
//		Runner runner0 = new Runner();
//		runner0.run();
		
		Runner runner1 = new Runner();
		runner1.start();
		
		Runner runner2 = new Runner();
		runner2.start();
	}
}
