package ex17;

import java.util.Observable;


public class Subject extends Observable {
	private String newMessage;

	public void setValue(String newMessage) {
		this.newMessage = newMessage;
		setChanged();
		notifyObservers();
	}
	
	public String getValue() {
		return this.newMessage;
	}
}