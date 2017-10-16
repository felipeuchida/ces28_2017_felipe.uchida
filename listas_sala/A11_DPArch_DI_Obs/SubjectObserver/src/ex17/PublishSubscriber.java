package ex17;

import java.util.Observable;
import java.util.Observer;
import java.util.LinkedList;
import java.util.List;

public class PublishSubscriber extends Observable implements Observer {
	private static int nextId = 1;
	private final int myId;
	Observable subject1;
	Observable subject2;
	String message_;
	
	public PublishSubscriber(Observable subject1, Observable subject2) {
		myId = nextId++;
		this.subject1 = subject1;
		this.subject2 = subject2;
		subject1.addObserver(this);
		subject2.addObserver(this);
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
	
	
	
	
	
	
	
	
	
	/*private static int nextId = 1;
	private final int myId;
	private List<Observable> subjects_ = new LinkedList<Observable>( );
	String message_;
	
	public PublishSubscriber(List<Observable> subjects_) {
		myId = nextId++;
		this.subjects_ = subjects_;
		int index = subjects_.size();
		while(index>0){
			subjects_.get(index).addObserver(this);
			index--;
		}
	}
	
	@Override
	public void update(List<Observable> subjects_, Object arg1) {
		if (subject_ instanceof Subject) {
			private List<Observable> mySubjects = new LinkedList<Observable>( );
			int index = mySubjects.size();
			Subject mySubject = (Subject) subject_;
			message_ = mySubject.getValue();
			System.out.println("Obs" + myId + " notificado");
			System.out.println(">>> " + ((Subject) subject_).getValue());
		}
	}	
	
	public static void main(String[] args) {
		Subject sub1 = new Subject();
		Subject sub2 = new Subject();
		List<Observable> subjects_ = new LinkedList<Observable>( );
		subjects_.add(sub1);
		subjects_.add(sub1);		
		PublishSubscriber PB = new PublishSubscriber(subjects_);
		Observador obs1 = new Observador(PB);
		Observador obs2 = new Observador(PB);
		String newMessage = "\"msg do sub1\"";
		sub1.setValue(newMessage);
		System.out.println("---------------------");
		newMessage = "\"msg do sub2\"";
		sub2.setValue(newMessage);
	}*/
}
