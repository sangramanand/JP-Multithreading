package com.tut.lecture14;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class App {

	public static void main(String[] args) {
		
		ExecutorService execService = Executors.newCachedThreadPool();
		Future<Integer> futureVal = execService.submit(new CalculateTask(20, 40));
		
		execService.shutdown();
		
		try {
			execService.awaitTermination(30, TimeUnit.MINUTES);
			System.out.println("Sum result : "+futureVal.get());
		} catch (InterruptedException | ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
