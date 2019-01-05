package Threads;

import java.util.concurrent.BlockingQueue;
import Threads.Message;

public class Producer implements Runnable {

	private BlockingQueue<Message> queue;

	public Producer(BlockingQueue<Message> q) {
		this.queue = q;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		for (int i = 0; i < 100; i++) {
			Message msg = new Message(" " + i + "th ");
			try {
				//Thread.sleep(i);
				queue.put(msg);
				System.out.println("Produced " + msg.getMsg());
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

		}
		Message msg = new Message("Exit");
		try {
			queue.put(msg);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

}
