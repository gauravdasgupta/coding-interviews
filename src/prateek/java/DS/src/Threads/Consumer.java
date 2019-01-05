package Threads;

import java.util.concurrent.BlockingQueue;

public class Consumer implements Runnable {

	private BlockingQueue<Message> queue;

	public Consumer(BlockingQueue<Message> q) {
		this.queue = q;
	}

	@Override
	public void run() {
		Message msg;
		try {
			while ((msg = queue.take()).getMsg() != "Exit") {
				// System.out.println("Consumed "+msg.getMsg());
				Thread.sleep(5000);
				System.out.println("Consumed " + msg.getMsg());
			}
		} catch (InterruptedException e) {

			e.printStackTrace();
		}

	}

}
