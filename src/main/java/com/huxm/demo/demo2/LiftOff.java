package com.huxm.demo.demo2;

import java.util.concurrent.TimeUnit;

public class LiftOff implements Runnable {


	private static int taskId = 0;//static���ҽ�������μ���ʱ����ʼ��
	
	private final int id =  taskId++;
	
	private int countDown = 10;
	
	public LiftOff() {
		
	}
	
	public LiftOff(int countDown) {
		this.countDown = countDown;
	}

	private String status() {
		return "task ("+ id+ ") " + (countDown > 0 ? countDown  : "liftoff!");
	}


	public void run() {
		while(countDown-- > 0) {
			System.out.println(status());
			//Thread.yield();
			try {
				TimeUnit.MILLISECONDS.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				//�쳣���ܿ��̴߳���main��ֻ�ܱ��ش���
			}
		}
		
	}
	
	
}
