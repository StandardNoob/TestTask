package eventhandler;

import java.util.Queue;
import java.util.concurrent.TimeUnit; //use only for demonstration

import eventqueue.enteties.impl.MyEvent;

public class EventExec implements Runnable {

	private Queue<MyEvent> events;

	public EventExec(Queue<MyEvent> events) {
		this.events = events;
	}

	@Override
	public void run() {
		synchronized (events) {
			if (events != null) {
				while (events.size() > 0) {
					MyEvent event = events.poll();
					try {
						event.execute();
						TimeUnit.SECONDS.sleep(1);
						System.out.println();
					} catch (InterruptedException e) {
						System.out.println("Execute error!");
						e.printStackTrace();
					}
				}
			}
			try {
				Thread.yield();
				events.wait();
				run();
			} catch (InterruptedException e) {
				System.out.println("EventExec was stoped!");
			}
		}
	}
}
