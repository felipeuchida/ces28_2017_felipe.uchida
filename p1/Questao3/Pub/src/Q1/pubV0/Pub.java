package Q1.pubV0;

public class Pub {
	private boolean verificaDesconto(String drink) { 
		boolean desconto = false;
		
		if(drink.equals("grans") || drink.equals("hansa") || drink.equals("strongbow"))
			desconto = true;
		
		return desconto;
	}
	
	private int cost(DrinkList drinkList, String drink, int amount) { 
		if (amount > 2 && (drink.equals("gt") || drink.equals("bacardi_special"))) 
			throw new RuntimeException("Too many drinks, max 2.");
		
		int price = drinkList.price(drink);
		
		if(price < 0)
			throw new RuntimeException("No such drink exists");

		return price; 
	}
	
	public int computeCost(String drink, boolean student, int amount) {
		IngredientList ingredientList = new IngredientList();
		ingredientList.add(new Ingredient("rum",65));
		ingredientList.add(new Ingredient("grenadine",10));
		ingredientList.add(new Ingredient("lime juice",10));
		ingredientList.add(new Ingredient("green stuff",10));
		ingredientList.add(new Ingredient("tonic water",20));
		ingredientList.add(new Ingredient("gin",85));
		
		
		DrinkList drinkList = new DrinkList();
		drinkList.add(new Drink("hansa",74)); //public static final String ONE_BEER = "hansa";		
		drinkList.add(new Drink("grans",103));//public static final String ONE_CIDER = "grans";
		drinkList.add(new Drink("strongbow",110));//public static final String A_PROPER_CIDER = "strongbow";
		drinkList.add(new Drink("gt",ingredientList.valueIngredient("gin") + ingredientList.valueIngredient("tonic water") 
		+ ingredientList.valueIngredient("green stuff")));//public static final String GT = "gt";
		drinkList.add(new Drink("bacardi_special",ingredientList.valueIngredient("gin") + ingredientList.valueIngredient("rum") 
		+ ingredientList.valueIngredient("grenadine") + ingredientList.valueIngredient("lime juice")));//public static final String BACARDI_SPECIAL = "bacardi_special";
		
		int price = cost(drinkList, drink, amount);
		
		if (student && verificaDesconto(drink)) 
			price = price - price/10;
		
		return price*amount;
	}
}
