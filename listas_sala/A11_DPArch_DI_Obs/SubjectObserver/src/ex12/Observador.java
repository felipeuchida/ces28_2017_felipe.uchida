package ex12;

import java.util.Observer;
import java.util.Observable;


class Observador implements Observer {
	private static int nextId = 1;
	private final int myId;
	Observable subject_;
	String message_;
	
	public Observador(Observable subject) {
		myId = nextId++;
		this.subject_ = subject;
		subject.addObserver(this);
	}
	
	@Override
	public void update(Observable subject_, Object arg1) {
		if (subject_ instanceof Subject) {
			Subject mySubject = (Subject) subject_;
			message_ = mySubject.getValue();
			System.out.println("Obs" + myId + " notificado");
			System.out.println(">>> " + ((Subject) subject_).getValue());
		}
	}	
}