package eventqueue.enteties.impl;

public class Buffer {

	private String text;

	public Buffer(String str) {
		this.text = str;
	}

	public String getText() {
		return text;
	}

	public void setText(String str) {
		this.text = str;
	}
}
