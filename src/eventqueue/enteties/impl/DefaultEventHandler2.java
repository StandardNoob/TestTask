package eventqueue.enteties.impl;

import java.util.LinkedList;
import java.util.Queue;

import eventqueue.enteties.EventHandler;

public class DefaultEventHandler2 implements EventHandler {

	private Queue<MyEvent> events;
	private final Object LOCK_OBJECT;

	{
		events = new LinkedList<MyEvent>();
		LOCK_OBJECT = new Object();
	}

	@Override
	public void addEvent(MyEvent event) throws Exception {
		synchronized (LOCK_OBJECT) {
			if (event != null) {
				events.add(event);
			}
			LOCK_OBJECT.notifyAll();
		}
	}

	@Override
	public void startHandler() throws Exception {
		synchronized (LOCK_OBJECT) {
			while (true) {
				if (events != null && events.size() > 0) {
					Thread thread = new Thread(() -> {
						while (events.size() > 0) {
							try {
								MyEvent myEvent = events.poll();
								myEvent.execute();
							} catch (InterruptedException e) {
								e.printStackTrace();
							}
						}
						Thread.yield();
					}, "Events Executor");
					thread.start();
					thread.join();

				} else {
					LOCK_OBJECT.wait();
				}
			}
		}
	}

	@Override
	public void stopHandler() throws Exception {
		System.out.println("Stop Handler");
		Thread.currentThread().interrupt();

	}
}
