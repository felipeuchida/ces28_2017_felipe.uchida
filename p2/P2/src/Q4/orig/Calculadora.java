package Q4.orig;

import java.util.Iterator;

public class Calculadora {
	private Impressora impressora;
	public Calculadora(Impressora impressora){
		this.impressora = impressora;
	}
	
	public void imprime(float totalDespesa) {
		String conteudo = "Relatório de Despesas";
		conteudo+=("\n Total das despesas:" + totalDespesa);

		SistemaOperacional so = new SistemaOperacional(impressora);
		so.getDriverImpressao(conteudo);
	}
}
