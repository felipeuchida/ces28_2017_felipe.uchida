import java.lang.Character;

public class CalculadoraString {
	static char delimitadorAdicional;

	// Verifica se caracter � "," ou " "
	static boolean verificaSeparador(char c) {
		boolean separador = false;
		if(c == ','  || c == ' ' || c == '\n' || c == delimitadorAdicional)
			separador = true;
		return separador;
	}

	// Fun��o principal
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
			throw new IllegalArgumentException("Entrada inv�lida e n�o-trat�vel");
	}

	// Estado 1 (L� a sequ�ncia de n�meros e retorna o valor)
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
			throw new IllegalArgumentException("Entrada inv�lida e n�o-trat�vel");
	}
}
