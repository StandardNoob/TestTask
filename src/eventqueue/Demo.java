package eventqueue;

import java.util.concurrent.TimeUnit;

import eventqueue.enteties.EventHandler;
import eventqueue.enteties.impl.Buffer;
import eventqueue.enteties.impl.DefaultEventHandler;
import eventqueue.enteties.impl.MyEvent;

public class Demo {
	public static void main(String[] args) throws Exception {

		Buffer text = new Buffer("Test");
		EventHandler eventHandler = new DefaultEventHandler(text);

		MyEvent myEvent1 = new MyEvent("My Event 1");
		MyEvent myEvent2 = new MyEvent("My Event 2");
		MyEvent myEvent4 = new MyEvent("My Event 4");

		eventHandler.addEvent(myEvent1);
		eventHandler.addEvent(myEvent4);
		eventHandler.addEvent(myEvent2);

		eventHandler.startHandler();

		MyEvent myEvent5 = new MyEvent("My Event 5");
		TimeUnit.SECONDS.sleep(1);

		System.out.println(System.lineSeparator() + "New Event Added!" + System.lineSeparator());
		eventHandler.addEvent(myEvent5);

		eventHandler.stopHandler();
	}
}
