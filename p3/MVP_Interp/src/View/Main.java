package View;

import java.io.File;

public class Main {
	public static void main(String[] args) {
		// RESPONSABILITY: CREATE APP
		View myInterp = new View();

		// ENTRADA DE USUARIO HUMANO: ESCOLHA DO METODO DE INTERPOLACAO   
		// RESPONSABILITY: LEITURA DO NOME DO METODO DE INTERPOLACAO
		myInterp.getMethod("Lagrange");
		// ENTRADA DE USUARIO HUMANO: PONTO DE INTERPOLACAO E NOME DO ARQUIVO DE DADOS.   
		// RESPONSABILITY: DEFINIR PONTO DE INTERPOLACAO (LEITURA ENTRADA DE USUARIO HUMANO) 
		// RESPONSABILITY: DEFINIR QUAL EH O ARQUIVO COM DADOS DE PONTOS DA FUNCAO (LEITURA ENTRADA DE USUARIO HUMANO)
		myInterp.calculateResult(10.3f, new File("./data.dat"));
	}
}
