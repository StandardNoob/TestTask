package eventqueue.enteties.impl;

import java.util.Queue;

public class EventsExecutor implements Runnable {

	private Queue<MyEvent> events;
	private Object LOCK_OBJECT;

	public EventsExecutor(Queue<MyEvent> events, Object object) {
		this.events = events;
		this.LOCK_OBJECT = object;
	}

	@Override
	public void run() {
		synchronized (LOCK_OBJECT) {
			if (events != null && events.size() > 0) {
				while (events.size() > 0) {
					try {
						MyEvent myEvent = events.poll();
						myEvent.execute();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
			try {
				LOCK_OBJECT.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
