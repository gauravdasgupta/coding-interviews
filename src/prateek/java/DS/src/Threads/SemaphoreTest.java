package Threads;

import java.util.concurrent.Semaphore;

public class SemaphoreTest {

	public static void main(String[] args)
	{
		Semaphore sem=new Semaphore(1);
		
		Semaphoreee t1=new Semaphoreee (sem,"t1",5000);
		Semaphoreee t2=new Semaphoreee (sem,"t2",7000);
		Semaphoreee t3=new Semaphoreee (sem,"t3",2000);
		
		t1.start();
		t2.start();
		t3.start();
		
		try {
			t1.join();
			//t2.join();
			//t3.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		
		System.out.println(t1.num);
		
		System.out.println("End of main");

		
		
		
	}
	
}
