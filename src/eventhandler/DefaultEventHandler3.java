package eventhandler;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import eventqueue.enteties.EventHandler;
import eventqueue.enteties.impl.MyEvent;

public class DefaultEventHandler3 implements EventHandler {

	private Queue<MyEvent> events;
	private List<Thread> threads;

	{
		events = new LinkedList<MyEvent>();
		threads = new ArrayList<Thread>();
	}

	public Queue<MyEvent> getEvents() {
		return events;
	}

	@Override
	public void addEvent(MyEvent event) throws Exception {
		Thread eventManagerThread = new Thread(new EventManager(events, event), "EventManager");
		eventManagerThread.start();
	}

	@Override
	public void startHandler() throws Exception {
		Thread eventExecThread = new Thread(new EventExec(events), "EventExec");
		eventExecThread.start();
		threads.add(eventExecThread);
	}

	@Override
	public void stopHandler() throws Exception {
		Thread eventStopper = new Thread(new EventStopper(threads, events), "EventStopper");
		eventStopper.start();
	}
}
