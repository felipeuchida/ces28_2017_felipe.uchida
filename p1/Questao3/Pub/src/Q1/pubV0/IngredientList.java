package Q1.pubV0;

import java.util.LinkedList;
import java.util.List;

public class IngredientList {
	private List<Ingredient> _ingredients = new LinkedList<Ingredient>( );
	
	public int size() { 
		return _ingredients.size(); 
	}
	
	public void add(Ingredient ingredient) { 
		_ingredients.add(ingredient); 
	}

	public void remove(Ingredient ingredient) { 
		_ingredients.remove(ingredient); 
	}

	public Ingredient get(int i) { 
		return _ingredients.get(i); 
	}
	
	public int valueIngredient(String name){
		int n = _ingredients.size();
		int value = 0;
		for (int i=0; i < n; i++) {
			if (name.equals(_ingredients.get(i).get_name())){
				value =  _ingredients.get(i).get_price();
				break;
			}
		}
		return value;
	}
}
