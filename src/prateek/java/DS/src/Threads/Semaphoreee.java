package Threads;

import java.util.concurrent.Semaphore;

public class Semaphoreee extends Thread {

	Semaphore sem;
	String tName;
	int delay;
	static Integer num=0;

	public Semaphoreee(Semaphore sem, String tName,int del) {
		super(tName);
		this.tName = tName;
		this.sem = sem;
		this.delay=del;
	}

	@Override
	public void run() {
			
		System.out.println("Starting "+Thread.currentThread().getName());
		try {
			//Thread.sleep(delay);
			System.out.print("");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		try {
			sem.acquire();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("Inside exclusive area "+Thread.currentThread().getName());
		
		num=num+delay;
		sem.release();
	
		System.out.println("Ending "+Thread.currentThread().getName());

	}

}
