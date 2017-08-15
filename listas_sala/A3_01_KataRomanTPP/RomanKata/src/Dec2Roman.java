
import java.util.LinkedHashMap;



public class Dec2Roman {

	// esta indirecao extra so para poder trocar as versoes facil!
	// troque conv0 por conv1, conv2, conv10, etc. 
	// assim voce pode manter as versoes como metodos da mesma classe.
	public static String conv(int num) {
		return conv2008(num);
	}
	
	// 1 {} -> null
	public static String conv0(int num) {
		return null; 	// version 0: no test passes.
	}
	
	// next iteration: one test passes
	// 2 nil -> constant
	public static String conv1(int num) {
		return "I";
	}
	
	/*********************************************************/
	// 3rd iteration: 2 tests pass
	// 4 Constant -> variable
	// 5 statement -> statements
	// 6 unconditional -> conditional
	public static String conv2(int num) {
		
		 String res = "I";

	     if (num > 1)
	        {
	            res += "I";
	        }
	     
	     return res;
	}

	// **************** WHAT YOU HAVE TO DO ****************
	// now write a convX method for each test. 
	// each new convX version must make a new test pass
	// BUT PERFORM ONLY THE MINIMUM CHANGES AT EACH STEP
	// *****************************************************
	
	public static String conv3(int num) {
		String res = "I";
		for (int i = 1; i < num; i++)
		{
			res += "I";
		}
	     
		return res;
	}
	
	/// EXAMPLE OF HOW TO USE A DICTIONARY!
	// example of how to use a dictionary to avoid repetition
	public static String conv4_2(int number)
	{
		LinkedHashMap<Integer, String> Results = new LinkedHashMap<Integer, String>();
		Results.put(1,"I");
		Results.put(4,"IV");

		if (Results.containsKey(number) )
		{
			return Results.get(number);
		}
		return Results.get(1) + conv4_2(number - 1);
	}
	
	public static String conv5(int number)
	{
		LinkedHashMap<Integer, String> Results = new LinkedHashMap<Integer, String>();
		Results.put(1,"I");
		Results.put(4,"IV");
		Results.put(5,"V");

		if (Results.containsKey(number) )
		{
			return Results.get(number);
		}
		return Results.get(1) + conv5(number - 1);
	}
	
	public static String conv8(int number)
	{
		LinkedHashMap<Integer, String> Results = new LinkedHashMap<Integer, String>();
		Results.put(1,"I");
		Results.put(4,"IV");
		Results.put(5,"V");

		if (Results.containsKey(number) )
		{
			return Results.get(number);
		}
		if (number > 5){
			return Results.get(5) + conv8(number - 5);
		}
		
		return Results.get(1) + conv8(number - 1);
	}
	
	public static String conv10(int number)
	{
		LinkedHashMap<Integer, String> Results = new LinkedHashMap<Integer, String>();
		Results.put(1,"I");
		Results.put(4,"IV");
		Results.put(5,"V");
		Results.put(9,"IX");
		Results.put(10,"X");

		if (Results.containsKey(number) )
		{
			return Results.get(number);
		}
		
		if (number > 8){
			return Results.get(9) + conv10(number - 9);
		}else if (number > 5){
			return Results.get(5) + conv10(number - 5);
		}
		
		return Results.get(1) + conv10(number - 1);
	}
	
	public static String conv14(int number)
	{
		LinkedHashMap<Integer, String> Results = new LinkedHashMap<Integer, String>();
		Results.put(1,"I");
		Results.put(4,"IV");
		Results.put(5,"V");
		Results.put(9,"IX");
		Results.put(10,"X");
		Results.put(14,"XIV");

		if (Results.containsKey(number) )
		{
			return Results.get(number);
		}
		
		if (number > 10){
			return Results.get(10) + conv14(number - 10);
		}else if (number > 9){
			return Results.get(9) + conv14(number - 9);
		}else if (number > 5){
			return Results.get(5) + conv14(number - 5);
		}
		
		return Results.get(1) + conv14(number - 1);
	}
	
	public static String conv44(int number)
	{
		LinkedHashMap<Integer, String> Results = new LinkedHashMap<Integer, String>();
		Results.put(1,"I");
		Results.put(4,"IV");
		Results.put(5,"V");
		Results.put(9,"IX");
		Results.put(10,"X");
		Results.put(14,"XIV");
		Results.put(40,"XL");

		if (Results.containsKey(number) )
		{
			return Results.get(number);
		}
		
		if (number > 40){
			return Results.get(40) + conv44(number - 40);
		}else if (number > 10){
			return Results.get(10) + conv44(number - 10);
		}else if (number > 9){
			return Results.get(9) + conv44(number - 9);
		}else if (number > 5){
			return Results.get(5) + conv44(number - 5);
		}
		
		return Results.get(1) + conv44(number - 1);
	}
	
	public static String conv100(int number)
	{
		LinkedHashMap<Integer, String> Results = new LinkedHashMap<Integer, String>();
		Results.put(1,"I");
		Results.put(4,"IV");
		Results.put(5,"V");
		Results.put(9,"IX");
		Results.put(10,"X");
		Results.put(14,"XIV");
		Results.put(40,"XL");
		Results.put(50,"L");
		Results.put(90,"XC");
		Results.put(100,"C");

		if (Results.containsKey(number) )
		{
			return Results.get(number);
		}
		
		
		if (number > 90){
			return Results.get(90) + conv100(number - 90);
		}else if (number > 50){
			return Results.get(50) + conv100(number - 50);
		}else if (number > 40){
			return Results.get(40) + conv100(number - 40);
		}else if (number > 10){
			return Results.get(10) + conv100(number - 10);
		}else if (number > 9){
			return Results.get(9) + conv100(number - 9);
		}else if (number > 5){
			return Results.get(5) + conv100(number - 5);
		}

		return Results.get(1) + conv100(number - 1);
	}
	
	public static String conv100s(int number){
		LinkedHashMap<Integer, String> Results = new LinkedHashMap<Integer, String>();
		Results.put(0, "");
		Results.put(1,"I");
		Results.put(4,"IV");
		Results.put(5,  "V");
		Results.put(9,  "IX");
		Results.put(10,  "X");
		Results.put(40, "XL");
		Results.put(50, "L");
		Results.put(90, "XC");
		Results.put(100, "C");
		Results.put(400, "CD");
		Results.put(500, "D");


		if (Results.containsKey(number) )
		{
			return Results.get(number);
		}
		if(number<4)
			return Results.get(1) + conv100s(number - 1);

		int decimal = number %100;
		if(number>100){
			if(decimal!=0)
				return conv100s(number - decimal) + conv100s(decimal);
			if(number<400)
				return Results.get(100) + conv100s(number - 100);
			return Results.get(500) + conv100s(number-500);
		}

		int unidade = number%10;    	
		if(number>10){
			if(unidade!=0)
				return conv100s(number - unidade) + conv100s(unidade);
			if(number<40)
				return Results.get(10) + conv100s(number - 10);
			return Results.get(50) + conv100s(number-50);
		}
		return Results.get(5) + conv100s(number-5);
 	}
	
	public static String conv2008(int number){
		LinkedHashMap<Integer, String> Results = new LinkedHashMap<Integer, String>();
		Results.put(0, "");
		Results.put(1,"I");
		Results.put(4,"IV");
		Results.put(5,  "V");
		Results.put(9,  "IX");
		Results.put(10,  "X");
		Results.put(40, "XL");
		Results.put(50, "L");
		Results.put(90, "XC");
		Results.put(100, "C");
		Results.put(400, "CD");
		Results.put(500, "D");
		Results.put(900, "CM");
		Results.put(1000, "M");


		if (Results.containsKey(number) )
		{
			return Results.get(number);
		}

		int milhar = number %1000;
		if(number>1000){
			if(number>2000)
				return conv2008(1000) + conv2008(number - 1000);
			if(milhar!=0)
				return conv2008(number - milhar) + conv2008(milhar);
			if(number<900)
				return Results.get(400) + conv2008(number - 400);
			return Results.get(500) + conv2008(number-500);
		}
		
		int decimal = number %100;
		if(number>100){
			if(decimal!=0)
				return conv2008(number - decimal) + conv2008(decimal);
			if(number<400)
				return Results.get(100) + conv2008(number - 100);
			return Results.get(500) + conv2008(number-500);
		}

		int unidade = number%10;    	
		if(number>10){
			if(unidade!=0)
				return conv2008(number - unidade) + conv2008(unidade);
			if(number<40)
				return Results.get(10) + conv2008(number - 10);
			return Results.get(50) + conv2008(number-50);
		}
		
		if(number<4)
			return Results.get(1) + conv2008(number - 1);
		
		return Results.get(5) + conv2008(number-5);
 	}
}// class Dec2Roman
	


	
		

