package eventqueue.enteties.impl;

import java.util.LinkedList;
import java.util.Queue;

import eventqueue.enteties.EventHandler;

public class DefaultEventHandler2 implements EventHandler {

	private Queue<MyEvent> events;
	private final Object LOCK_OBJECT;
	private EventsExecutor eventsExecutor;

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
		eventsExecutor = new EventsExecutor(events, LOCK_OBJECT);
		Thread thread = new Thread(eventsExecutor, "Events Executor");
		thread.start();
		thread.join();
	}

	@Override
	public void stopHandler() throws Exception {
		System.out.println("Stop Handler");
		Thread.currentThread().interrupt();

	}
}
