package eventhandler;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.TimeUnit;

import eventqueue.enteties.EventHandler;
import eventqueue.enteties.impl.MyEvent;

public class Demo {

	public static void main(String[] args) throws Exception {

		Queue<MyEvent> events = new LinkedList<MyEvent>();
		EventHandler eventHandler = new DefaultEventHandler3(events);
		int eventIterator = 0;

		eventHandler.stopHandler();

		MyEvent myEvent = new MyEvent("My Event 1");
		MyEvent myEvent2 = new MyEvent("My Event 2");
		MyEvent myEvent3 = new MyEvent("My Event 3");
		MyEvent myEvent4 = new MyEvent("My Event 4");
		MyEvent myEvent5 = new MyEvent("My Event 5");

		eventHandler.addEvent(myEvent5);
		eventHandler.addEvent(myEvent3);
		eventHandler.addEvent(myEvent4);
		eventHandler.addEvent(myEvent);
		eventHandler.addEvent(myEvent2);
		System.out.println("Events From List:");

		eventHandler.startHandler();

		while (true) {
			MyEvent event = new MyEvent("Event from loop #" + eventIterator);
			eventHandler.addEvent(event);
			TimeUnit.SECONDS.sleep(2);
			eventIterator++;
		}
	}
}
