package Ex11;

public class ConcreteSubject extends Subject{
	public boolean getState(){
		return _subjectState;
	}

	public void setState(boolean subjectState){
		_subjectState = subjectState;
		notifyObserver();
	}
}
