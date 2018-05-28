package com.huxm.demo.demo2;

public abstract class IntGenerator {
	private volatile boolean canceled =false;
	
	public void cancel() {
		canceled = true;
	};
	public boolean isCancel() {
		return canceled;
	};
	public abstract int next();

}
