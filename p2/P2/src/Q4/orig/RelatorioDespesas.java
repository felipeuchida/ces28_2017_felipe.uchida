package Q4.orig;

import java.util.Iterator;

public class RelatorioDespesas {
	private Impressora impressora;
	public RelatorioDespesas(Impressora impressora){
		this.impressora = impressora;
	}
	
	public void ImprimirRelatorio(Iterator<Despesa> despesas) {	
		float totalDespesa = 0.0f;
		IteratorDespesas itDespesa = new IteratorDespesas();
		totalDespesa = itDespesa.CalculaTotal(despesas);
		Calculadora calculadora = new Calculadora (impressora);
		calculadora.imprime(totalDespesa);
	}
}