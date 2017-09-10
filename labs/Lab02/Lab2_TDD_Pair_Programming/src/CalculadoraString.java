import java.lang.Character;

public class CalculadoraString {
	static char delimitadorAdicional;

	// Verifica se caracter é "," ou " "
	static String removeZeros(String numbers) {
		int n = numbers.length();
		if(!numbers.equals("") && numbers.charAt(0) == '0')
			return removeZeros(numbers.substring(1,n));
		return numbers;
	}

	// Verifica se caracter é "," ou " "
	static boolean verificaSeparador(char c) {
		boolean separador = false;
		if(c == ','  || c == ' ' || c == '\n' || c == delimitadorAdicional)
			separador = true;
		return separador;
	}

	// Função principal
	static int add(String numbers) {
		int n = numbers.length();
		if(numbers.equals(""))
			return 0;
		delimitadorAdicional = ' ';
		if(n >= 5){
			if(numbers.substring(0,3).equals("//[") && numbers.charAt(4) == ']'){
				delimitadorAdicional = numbers.charAt(3);
				return q0(numbers.substring(5,n), 0);
			}else
				return q0(numbers, 0);
		}
		return q0(numbers, 0);
	}

	// Estado 0 (inicial e recebe Separadores)
	static int q0(String numbers, int total) {
		//System.out.println("q0  " + numbers);
		int n = numbers.length();

		if(numbers.equals(""))
			return total;
		else if( verificaSeparador(numbers.charAt(0)) )
			return q0(numbers.substring(1,n), total);
		else if( Character.isDigit(numbers.charAt(0)) )
			return q1(numbers.substring(1,n), numbers.charAt(0) - '0', total);
		else if( numbers.charAt(0) == '-' && !removeZeros(numbers.substring(1,n)).equals("") && Character.isDigit(removeZeros(numbers.substring(1,n)).charAt(0)) )
			return q2( removeZeros(numbers.substring(1,n)).substring(1,removeZeros(numbers.substring(1,n)).length()), "[-" + removeZeros(numbers.substring(1,n)).charAt(0) );
		else
			throw new IllegalArgumentException("Entrada inválida e não-tratável");
	}

	// Estado 1 (Lê a sequência de números e retorna o valor)
	static int q1(String numbers, int atual, int total) {
		//System.out.println("q1  " + numbers + "  total = " + total);
		int n = numbers.length();

		if(numbers.equals(""))
			return total + atual;
		else if(verificaSeparador(numbers.charAt(0)))
			return q0(numbers.substring(1,n), total + atual);
		else if(Character.isDigit(numbers.charAt(0)))
			return q1(numbers.substring(1,n), atual*10 + numbers.charAt(0) - '0', total);
		else
			throw new IllegalArgumentException("Entrada inválida e não-tratável");
	}

	// Estado 2 (trata dos negativos)
	static int q2(String numbers, String negativos) {
		//System.out.println("q2  " + numbers);
		int n = numbers.length();

		if(numbers.equals(""))
			throw new IllegalArgumentException("negativos proibidos " + negativos + "]");
		else if(verificaSeparador(numbers.charAt(0)))
			return q3( numbers.substring(1,n), negativos);
		else if( Character.isDigit(numbers.charAt(0)) )
			return q2( numbers.substring(1,n), negativos + numbers.charAt(0) );
		else
			throw new IllegalArgumentException("Entrada inválida e não-tratável");
	}

	// Estado 3 (recebe Separadores do estado 2)
	static int q3(String numbers, String negativos) {
		int n = numbers.length();

		if(numbers.equals(""))
			throw new IllegalArgumentException("negativos proibidos " + negativos + "]");
		else if(verificaSeparador(numbers.charAt(0)) || Character.isDigit(numbers.charAt(0)))
			return q3( numbers.substring(1,n), negativos);
		else if( numbers.charAt(0) == '-' && !removeZeros(numbers.substring(1,n)).equals("") && Character.isDigit(removeZeros(numbers.substring(1,n)).charAt(0)) )
			return q2( removeZeros(numbers.substring(1,n)).substring(1,removeZeros(numbers.substring(1,n)).length()), negativos + " -" + removeZeros(numbers.substring(1,n)).charAt(0) );
		else
			throw new IllegalArgumentException("Entrada inválida e não-tratável");
	}
}
