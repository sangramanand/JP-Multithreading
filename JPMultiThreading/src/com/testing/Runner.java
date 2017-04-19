package com.testing;

import java.util.Random;

public class Runner {
	
	private Account acc1 = new Account();
	private Account acc2 = new Account();
//	private Object lock = new Object();
	
	public void firstThread() throws InterruptedException{
		Random random = new Random();
		
		synchronized(this){
			System.out.println("in synchronized block 1..");
			System.out.println("to wait..");
			this.wait();
			System.out.println("got notified..");
			for(int i=0; i<10000;i++){
				Account.transfer(acc1, acc2, random.nextInt(100));
			}
		}
		
	}
	
	public void secondThread() throws InterruptedException{
		Random random = new Random();
		synchronized(this){
			System.out.println("in synchronized block 2..");
			for(int i=0; i<10000;i++){
				Account.transfer(acc2, acc1, random.nextInt(100));
			}
			System.out.println("notifying..");
			this.notify();
		}
		
	}
	
	public void finished() {
		System.out.println("Balance in Account 1 is : "+acc1.getAccountBalance());
		System.out.println("Balance in Account 2 is : "+acc2.getAccountBalance());
		System.out.println("Total Amount in Bank: "+(acc1.getAccountBalance()+acc2.getAccountBalance()));
	}

}
