import java.lang.Character;

public class CalculadoraString {
	
	// Verifica se caracter é "," ou " "
	static boolean verificaSeparador(char c) {
		boolean separador = false;
		if(c == ','  || c == ' ' || c == '\n')
			separador = true;
		return separador;
	}

	// Função principal
	static int add(String numbers) {
		if(numbers.equals(""))
			return 0;
		//System.out.println("add  " + numbers);
		//System.out.println(q0(numbers, 0));
		return q0(numbers, 0);
	}

	// Estado 0 (inicial e recebe "," ou " ")
	static int q0(String numbers, int total) {
		//System.out.println("q0  " + numbers + "  total = " + total);
		int n = numbers.length();
		
		if(numbers.equals(""))
			return total;
		else if(verificaSeparador(numbers.charAt(0)))
			return q0(numbers.substring(1,n), total);
		else if(Character.isDigit(numbers.charAt(0)))
			return q1(numbers.substring(1,n), numbers.charAt(0) - '0', total);
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
}
