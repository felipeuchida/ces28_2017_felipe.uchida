import java.util.LinkedList;
import java.util.List;

public class MoneyBag {
	private List<Money> _monies = new LinkedList<Money>( );

	public int size() { 
		return _monies.size(); 
	}

	public boolean contains(Money m) {
		return _monies.contains(m);
	}

	public Money get(int i) { 
		return _monies.get(i); 
	}

	public void add(Money m) { 
		// loop sobre cada elemento e verifica se já existe aquela currency
		int n = 0;
		boolean already_exists = false;
		n = _monies.size();
		for (int i=0; i < n; i++) {
			if (_monies.get(i).getCurrency().equals(m.getCurrency())){
				already_exists = true;
				_monies.get(i).setAmount(_monies.get(i).getAmount() + m.getAmount());
				break;
			}
		}
		if(!already_exists)
			_monies.add(m); 
	}

	public boolean equals(Object anObject) {
		if (this == anObject) // checks if they are the same pointer!
			return true; 
		if (!(anObject instanceof MoneyBag)) 
			return false;
		MoneyBag otherlist = (MoneyBag) anObject;
		if (!(otherlist.size() == this.size()))
			return false;
		// loop over each element of otherlist
		int n = otherlist.size();
		for (int i=0; i < n ; i++) {
			if (!contains(otherlist.get(i)))
				return false;
		}//for
		return true;
	}

	public String[] showBag(){
		int n = _monies.size();
		String[] vetorCurrencies = new String[n];
		for(int i=0; i < n; i++){
			vetorCurrencies[i] = _monies.get(i).getCurrency();
			System.out.println( vetorCurrencies[i] );
		}
		return vetorCurrencies;
	}
}
