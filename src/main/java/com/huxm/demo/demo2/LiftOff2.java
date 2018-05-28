package com.huxm.demo.demo2;

import java.util.concurrent.Callable;

public class LiftOff2 implements Callable<String> {


	private static int taskId = 0;//static当且仅当类初次加载时被初始化
	
	private final int id =  taskId++;
	
	private int countDown = 10;
	
	public LiftOff2() {
		
	}
	
	public LiftOff2(int countDown) {
		this.countDown = countDown;
	}

	private String status() {
		return "task ("+ id+ ") " + (countDown > 0 ? countDown  : "liftoff!");
			
	}


	public String call() {
		return status();		
	}
	
	
}
