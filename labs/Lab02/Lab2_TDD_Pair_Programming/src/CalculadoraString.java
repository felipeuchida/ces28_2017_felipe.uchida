import java.lang.Character;

public class CalculadoraString {
	static String[] delimitadorAdicional;
	static int numeroDelimitadores;

	// Verifica se caracter é "," ou " "
	static String removeZeros(String numbers) {
		int n = numbers.length();
		if(!numbers.equals("")){
			if(numbers.charAt(0) == '0')
				return removeZeros(numbers.substring(1,n));
		}
		return numbers;
	}

	// Verifica se caracter é "," ou " "
	static int verificaSeparador(String numbers) {
		char c = numbers.charAt(0);
		if(c == ','  || c == ' ' || c == '\n')
			return 1;
		for(int i = 0; i<numeroDelimitadores; i++){
			if(numbers.length() >= delimitadorAdicional[i].length() && numbers.substring(0,delimitadorAdicional[i].length()).equals(delimitadorAdicional[i])){
				return delimitadorAdicional[i].length();
			}
		}
		return -1;
	}

	// Adiciona delimitadores
	static int adicionaSeparador(String numbers) {
		if (numeroDelimitadores == 0)
			return 0;

		int aux = 0;
		int posicao = 0;
		int fim = posicao+3;

		if(numbers.substring(posicao,fim).equals("//[")){
			while(numbers.charAt(fim+1) != ']'){
				fim++;
			}
			delimitadorAdicional[0] = numbers.substring(posicao+3,fim+1);
			posicao = fim+2;
			aux++;
		}else{
			throw new IllegalArgumentException("Entrada inválida e não-tratável");
		}

		for(int i = 1; i<numeroDelimitadores; i++){
			fim = posicao+1;
			if(numbers.charAt(posicao) == '['){
				while(numbers.charAt(fim+1) != ']'){
					fim++;
				}
				delimitadorAdicional[i] = numbers.substring(posicao+1,fim+1);
				//System.out.println("delimitadorAdicional[" + i + "] = " + delimitadorAdicional[i]);
				posicao = fim+2;
				aux++;
			}else{
				throw new IllegalArgumentException("Entrada inválida e não-tratável");
			}
		}
		return posicao;
	}

	// Função principal
	static int add(String numbers) {
		int n = numbers.length();
		if(numbers.equals(""))
			return 0;

		numeroDelimitadores = (numbers.length() - numbers.replaceAll("]", "").length());
		delimitadorAdicional = new String[numeroDelimitadores];

		int atual = adicionaSeparador(numbers);
		for(int i = 0; i<numeroDelimitadores; i++){
			//System.out.println("delimitadorAdicional[" + i + "] = " + delimitadorAdicional[i]);
			if(delimitadorAdicional[i].equals("[") || delimitadorAdicional[i].equals("]") || Character.isDigit(delimitadorAdicional[i].charAt(0)))
				throw new IllegalArgumentException("Entrada inválida e não-tratável");
			else if(delimitadorAdicional[i].equals("-"))
				numbers = numbers.replaceAll("-", " ");
		}

		if(atual > 1)
			return q0(numbers.substring(atual,n), 0);
		else
			return q0(numbers, 0);
	}

	// Estado 0 (inicial e recebe Separadores)
	static int q0(String numbers, int total) {
		//System.out.println("q0  " + numbers);
		int n = numbers.length();

		if(numbers.equals(""))
			return total;
		else if( verificaSeparador(numbers) >= 0)
			return q0(numbers.substring(verificaSeparador(numbers),n), total);
		else if( Character.isDigit(numbers.charAt(0)) )
			return q1(numbers.substring(1,n), numbers.charAt(0) - '0', total);
		else if( numbers.charAt(0) == '-' ) {
			if(!removeZeros(numbers.substring(1,n)).equals("") && Character.isDigit(removeZeros(numbers.substring(1,n)).charAt(0)) )
				return q2( removeZeros(numbers.substring(1,n)).substring(1,removeZeros(numbers.substring(1,n)).length()), "[-" + removeZeros(numbers.substring(1,n)).charAt(0) );
			else if(removeZeros(numbers.substring(1,n)).equals(""))
				return total;
			else if(verificaSeparador(removeZeros(numbers.substring(1,n))) >= 0)
				return q0(removeZeros(numbers.substring(1,n)), total);
		}
		else
			throw new IllegalArgumentException("Entrada inválida e não-tratável");
		return 0;
	}

	// Estado 1 (Lê a sequência de números e retorna o valor)
	static int q1(String numbers, int atual, int total) {
		//System.out.println("q1  " + numbers + "  total = " + total);
		int n = numbers.length();

		if(numbers.equals("")){
			if(atual > 1000)
				return total;
			else 
				return total + atual;
		}
		else if(verificaSeparador(numbers) >= 0){
			if(atual > 1000)
				return q0(numbers.substring(verificaSeparador(numbers),n), total);
			else 
				return q0(numbers.substring(verificaSeparador(numbers),n), total + atual);
		}
		else if(Character.isDigit(numbers.charAt(0))){
			if(atual > 1000)
				return q1(numbers.substring(1,n), 1001, total);
			else 
				return q1(numbers.substring(1,n), atual*10 + numbers.charAt(0) - '0', total);
		}
		else
			throw new IllegalArgumentException("Entrada inválida e não-tratável");
	}

	// Estado 2 (trata dos negativos)
	static int q2(String numbers, String negativos) {
		//System.out.println("q2  " + numbers);
		int n = numbers.length();

		if(numbers.equals(""))
			throw new IllegalArgumentException("negativos proibidos " + negativos + "]");
		else if(verificaSeparador(numbers) >= 0)
			return q3( numbers.substring(verificaSeparador(numbers),n), negativos);
		else if( Character.isDigit(numbers.charAt(0)))
			return q2( numbers.substring(1,n), negativos + numbers.charAt(0) );
		else
			throw new IllegalArgumentException("Entrada inválida e não-tratável");
	}

	// Estado 3 (recebe Separadores do estado 2)
	static int q3(String numbers, String negativos) {
		//System.out.println("q3  " + numbers);
		int n = numbers.length();

		if(numbers.equals(""))
			throw new IllegalArgumentException("negativos proibidos " + negativos + "]");
		else if(verificaSeparador(numbers) >= 0)
			return q3( numbers.substring(verificaSeparador(numbers),n), negativos);
		else if(Character.isDigit(numbers.charAt(0)))
			return q3( numbers.substring(1,n), negativos);
		else if( numbers.charAt(0) == '-' && !removeZeros(numbers.substring(1,n)).equals("") && Character.isDigit(removeZeros(numbers.substring(1,n)).charAt(0)) )
			return q2( removeZeros(numbers.substring(1,n)).substring(1,removeZeros(numbers.substring(1,n)).length()), negativos + " -" + removeZeros(numbers.substring(1,n)).charAt(0) );
		else
			throw new IllegalArgumentException("Entrada inválida e não-tratável");
	}
}
