package Ex11;
import java.util.LinkedList;
import java.util.List;

public abstract class Subject {
	protected boolean _subjectState = false;
	static int cont = 1;
    private List<ConcreteObserver> _observers = new LinkedList<ConcreteObserver>( );
    
    public int size() { 
        return _observers.size(); 
    }

    public boolean contains(ConcreteObserver observer) {
        return _observers.contains(observer);
    }

    public ConcreteObserver get(int i) { 
        return _observers.get(i); 
    }

    public void attach(ConcreteObserver obs){
    	obs.setId(cont);
    	cont++;
    	_observers.add(obs); 
    }

    public void dettach(ConcreteObserver obs){
    	_observers.remove(obs);
    }

    protected void notifyObserver(){
        //System.out.println("Notificar IU");
        int n = size();
        for (int i=0; i < n; i++) {
        	System.out.println(_observers.get(i).getId() + " notificado");
            _observers.get(i).update(this);
        }
        
        
    }
}
