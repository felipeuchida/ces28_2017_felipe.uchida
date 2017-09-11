package Q1.pubV0;

public class Ingredient {
	private String _name;
	private int _price;

	public String get_name() {
		return _name;
	}

	public void set_name(String _name) {
		this._name = _name;
	}

	public int get_price() {
		return _price;
	}

	public void set_price(int _price) {
		this._price = _price;
	}
	
	public Ingredient(String name, int price){
		set_price(price);
		set_name(name);
	}

	/*//one unit of rum
    public int getValueIngredient1() {
        return 65;
    }

    //one unit of grenadine
    public int getValueIngredient2() {
        return 10;
    }

    //one unit of lime juice
    public int getValueIngredient3() {
        return 10;
    }

    //one unit of green stuff
    public int getValueIngredient4() {
        return 10;
    }

    //one unit of tonic water
    public int getValueIngredient5() {
        return 20;
    }

    //one unit of gin
    public int getValueIngredient6() {
        return 85;
    }*/
}
