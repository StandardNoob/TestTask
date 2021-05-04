package eventhandler;

import eventqueue.enteties.impl.MyEvent;

public class Demo {

	public static void main(String[] args) throws Exception {

		DefaultEventHandler3 eventHandler = new DefaultEventHandler3();

		for (int i = 0; i < 5; i++) {
			MyEvent myEvent = new MyEvent("My Event #" + (i + 1));
			eventHandler.addEvent(myEvent);
		}
		eventHandler.startHandler();
		eventHandler.stopHandler();
	}
}
