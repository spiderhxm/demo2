package com.huxm.demo.demo2;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Test2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// LiftOff lf = new LiftOff();
		// lf.run();
		
		List<Future<String>> fsList = new ArrayList<Future<String>>();
		
		ExecutorService es = Executors.newCachedThreadPool();
		//ExecutorService es = Executors.newSingleThreadExecutor();
		for (int i = 0; i < 5; i++) {
			//new Thread(new LiftOff()).start();
			fsList.add(es.submit(new LiftOff2()));
		}
		
		for(Future<String> fs: fsList) {
			try {
				System.out.println(fs.get());
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ExecutionException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				//es.shutdown();
			}
		}
		es.shutdown();

		System.out.println("finished!");
	}

}
