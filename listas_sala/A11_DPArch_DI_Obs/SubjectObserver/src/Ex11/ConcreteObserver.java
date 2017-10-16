package Ex11;

public class ConcreteObserver extends Observer{
	private boolean _observerState = false;
	static ConcreteSubject _subject;
	private String Id;
	
	public String getId() {
		return Id;
	}

	public void setId(int id) {
		Id = "Obs"+id;
	}
	
	public void update(Subject subject){
    	if(_observerState)
			System.out.println(">>> Por aqui vai tudo bem!");
		else
			System.out.println(">>> Olá, como vai?");
    	
		_subject = (ConcreteSubject) subject ;
		_observerState = _subject.getState();
	}
}
