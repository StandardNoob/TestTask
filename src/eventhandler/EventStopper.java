package eventhandler;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class EventStopper implements Runnable {

	private List<Thread> threads;

	public EventStopper(List<Thread> threads) {
		this.threads = threads;
	}

	@Override
	public void run() {
		if (threads != null) {
			try {
				TimeUnit.SECONDS.sleep(10);
				for (Thread thread : threads) {
					thread.interrupt();
				}
			} catch (InterruptedException e) {
				System.out.println("Exception from EventStopper");
				e.printStackTrace();
			}
		}
	}
}
