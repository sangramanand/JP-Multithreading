package com.tut.lecture14;

import java.util.concurrent.Callable;

public class CalculateTask implements Callable<Integer> {

	
	private Integer a;
	private Integer b;
	
	
	public CalculateTask(Integer a, Integer b) {
		super();
		this.a = a;
		this.b = b;
	}


	@Override
	public Integer call() throws Exception {
		return a+b;
	}

}
