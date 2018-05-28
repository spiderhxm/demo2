package com.huxm.demo.demo2;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Test1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// LiftOff lf = new LiftOff();
		// lf.run();
		
		ExecutorService es = Executors.newCachedThreadPool();
		//ExecutorService es = Executors.newSingleThreadExecutor();
		for (int i = 0; i < 5; i++) {
			//new Thread(new LiftOff()).start();
			es.execute(new LiftOff());
		}
		es.shutdown();

		System.out.println("finished!");
	}

}
