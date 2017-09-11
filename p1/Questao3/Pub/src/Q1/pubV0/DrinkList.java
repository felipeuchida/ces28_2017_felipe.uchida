package Q1.pubV0;


import java.util.LinkedList;
import java.util.List;

public class DrinkList {
	private List<Drink> _drinks = new LinkedList<Drink>( );
	
	public void add(Drink drink) { 
		_drinks.add(drink); 
	}
	
	public void remove(Drink drink) { 
		_drinks.remove(drink); 
	}
	
	public Drink get(int i) { 
		return _drinks.get(i); 
	}
	
	public int price(String drink) {
		int n = _drinks.size();
		int price = -1;
		for (int i=0; i < n; i++) {
			if (drink.equals(_drinks.get(i).get_tipo())){
				price = _drinks.get(i).get_price();
				break;
			}
		}
		return price;
	}
}
