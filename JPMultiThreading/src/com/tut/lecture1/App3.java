package com.tut.lecture1;


//Anonymous Thread class
public class App3 {

	public static void main(String[] args) {
		
		Thread t1 = new Thread(new Runnable() {
			
			@Override
			public void run() {
				String threadName = Thread.currentThread().getName();
				
				for(int i=1;i<=10;i++){
					System.out.println(threadName+"- Hello "+i);
				}
			}
		});
		
		t1.start();
	}

}
