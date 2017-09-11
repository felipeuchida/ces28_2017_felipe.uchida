package Q1.pubV0;

public class Drink {
	private String _tipo;
	private int _price;
	
	public String get_tipo() {
		return _tipo;
	}

	public void set_tipo(String _tipo) {
		this._tipo = _tipo;
	}

	public int get_price() {
		return _price;
	}

	public void set_price(int _price) {
		this._price = _price;
	}

	public Drink(String tipo, int price){
		set_price(price);
		set_tipo(tipo);
	}
}
