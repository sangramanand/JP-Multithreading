package com.tut.lecture7;

import java.util.Scanner;

public class Processor {

	public void produce() throws InterruptedException {
		
		System.out.println("Inside Producer!");
		synchronized (this) {
			System.out.println("Producer method started!!! ");
			wait();
			System.out.println("Producer method resumed!!! ");
		}
		
	}
	
	public void consumer() throws InterruptedException {
		
		System.out.println("Inside Consumer!");
		Scanner sc = new Scanner(System.in);
		Thread.sleep(3000);
		synchronized (this) {
			System.out.println("Press return key to continue...!!!");
			sc.nextLine();
			System.out.println("Before Notify...!!!");
			notify();
			System.out.println("After Notify, going to sleep...!!!");
			Thread.sleep(5000);
			System.out.println("After sleep, wokeup, waking producer...!!!");
		}
		
	}
}
