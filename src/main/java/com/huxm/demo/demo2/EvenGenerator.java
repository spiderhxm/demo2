package com.huxm.demo.demo2;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class EvenGenerator extends IntGenerator {

	private int curInt = 0;

	@Override
	public int next() {
		// TODO Auto-generated method stub
		++curInt;
		++curInt;
		return curInt;
	}

	public static void main(String[] args) {

		EvenGenerator eg = new EvenGenerator();

		ExecutorService es = Executors.newCachedThreadPool();

		for (int i = 0; i < 10; i++) {
			es.execute(new EvenChecker(eg));
		}
		
		es.shutdown();

	}

}
