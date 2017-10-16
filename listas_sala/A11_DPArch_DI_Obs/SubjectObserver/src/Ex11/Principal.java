package Ex11;

public class Principal {
	public static void main(String[] args){
		System.out.println("Gerar primeiro evento");
		System.out.println("---------------------");
		ConcreteSubject x = new ConcreteSubject();
		
		ConcreteObserver y = new ConcreteObserver();
		x.attach(y);
		x.attach(new ConcreteObserver());
		x.setState(true);
		
		System.out.println("\nGerar segundo evento");
		System.out.println("---------------------");
		x.dettach(y);
		x.setState(true);
		
	}
}
