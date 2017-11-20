package notaFiscal;

import java.util.Map;

public abstract class Imposto {
	protected String _nome;
	protected Double _aliquota_default;
	
	// requisito 10:
	// as classes que extenderem Imposto podem possuir um 'private static state',
	// caso o cálculo do imposto dependa da ordem em que os IVs aparecem na NF
	
	public void setDefault(Double aliquota_default) {
		_aliquota_default = aliquota_default;
	}
	
	// ao incluir um novo imposto, deve-se sobrescrever esse método (DP Strategy):
	public abstract double gerarImposto(ItemVenda IV);		// requisito 9
}
