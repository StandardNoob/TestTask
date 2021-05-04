package eventhandler;

import java.util.List;
import java.util.Queue;

import eventqueue.enteties.impl.MyEvent;

public class EventStopper implements Runnable {

	private List<Thread> threads;
	private Queue<MyEvent> events;

	public EventStopper(List<Thread> threads, Queue<MyEvent> events) {
		this.threads = threads;
		this.events = events;
	}

	@Override
	public void run() {
		synchronized (events) {
			if (events.size() == 0) {
				if (threads != null) {
					for (Thread thread : threads) {
						thread.interrupt();
					}
				}
			}
		}
	}
}
