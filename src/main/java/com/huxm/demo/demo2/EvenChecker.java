package com.huxm.demo.demo2;

public class EvenChecker implements Runnable{
	private IntGenerator ig;
	
	public EvenChecker(IntGenerator ig) {
		this.ig = ig;
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(!ig.isCancel()) {
			int nextInt = ig.next();
			if(nextInt % 2 != 0 ) {
				ig.cancel();
				System.out.println(nextInt + " is not a even");
			}
		}
	}

}
