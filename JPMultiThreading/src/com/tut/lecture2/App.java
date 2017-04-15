package com.tut.lecture2;

import java.util.Scanner;

class Processor extends Thread {

	private boolean running = true;
	
	
	@Override
	public void run() {
		String currentThreadName = Thread.currentThread().getName();
		while(running){
			System.out.println(currentThreadName+" - Hello, the value of running is - "+running);
			
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public void shutdown() {
		String currentThreadName = Thread.currentThread().getName();
		running = false;
		System.out.println(currentThreadName+" - the value of running is - "+running);
	}
}



public class App {
	public static void main(String args[]){
		
		Processor proc1 = new Processor();
		proc1.start();
		
		Processor proc2 = new Processor();
		proc2.start();
		
		System.out.println("Press return to stop ...");
		
		Scanner scanner = new Scanner(System.in);
		scanner.nextLine();
		
		proc1.shutdown();
		
	}
}
