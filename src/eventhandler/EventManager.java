package eventhandler;

import java.util.Queue;
import eventqueue.enteties.impl.MyEvent;

public class EventManager extends Thread {

	private Queue<MyEvent> events;
	private MyEvent myEvent;

	public EventManager(Queue<MyEvent> events, MyEvent myEvent) {
		this.events = events;
		this.myEvent = myEvent;
	}

	@Override
	public void run() {
		synchronized (events) {
			if (myEvent != null && events != null) {
				try {
					events.add(myEvent);
				} catch (Exception e) {
					System.out.println("Event add error!");
					e.printStackTrace();
				}
			}
			events.notify();
		}
	}
}
