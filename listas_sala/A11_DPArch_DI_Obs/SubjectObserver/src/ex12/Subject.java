package ex12;

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
	
	public static void main(String[] args) {
		Subject subject = new Subject();
		String newMessage = "Olá, como vai?";
		Observador obs1 = new Observador(subject);
		Observador obs2 = new Observador(subject);
		subject.setValue(newMessage);
		System.out.println("---------------------");
		subject.deleteObserver(obs1);
		newMessage = "Por aqui vai tudo bem!";
		subject.setValue(newMessage);
	}

}