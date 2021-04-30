package eventqueue.enteties.impl;

import java.util.LinkedList;
import java.util.Queue;

import eventqueue.enteties.EventHandler;

public class DefaultEventHandler implements EventHandler {

	private Queue<MyEvent> eventsQueue;
	private Buffer text;

	{
		eventsQueue = new LinkedList<MyEvent>();
	}

	public DefaultEventHandler(Buffer text) {
		this.text = text;
	}

	@Override
	public void addEvent(MyEvent event) throws Exception {
		synchronized (text) {
			try {
				eventsQueue.add(event);
				startHandler();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public void startHandler() throws Exception {
		synchronized (text) {
			if (eventsQueue != null) {
				Thread thread = new Thread(() -> {

					while (eventsQueue.size() > 0) {
						MyEvent event = eventsQueue.poll();
						try {
							event.execute();
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
						System.out.println("The Event was processed" + System.lineSeparator());
					}

				}, "StartHandler Thread");
				thread.start();
				thread.join();
			}
		}
	}

	@Override
	public void stopHandler() {
		synchronized (text) {
			try {
				System.out.println("DefaultEventHandler was stoped!");
				System.exit(0);

			} catch (Exception e) {
				System.out.println("Stop Handler Exception block");
			}
		}
	}
}
