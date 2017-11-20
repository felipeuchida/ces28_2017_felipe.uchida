package BD;

import java.util.HashMap;
import java.util.Map;

import notaFiscal.Imposto;
import notaFiscal.ItemVenda;
import notaFiscal.ProdutoServico;

public class BD_Tax {
	private Map<ProdutoServico, Imposto> _impostos;
	
	public BD_Tax() {
		_impostos = new HashMap<ProdutoServico, Imposto>();
	}
	
	public Imposto getImposto(ItemVenda IV) {
		return _impostos.get(IV.getPS());
	}
	
	public void setImposto(ProdutoServico PS, Imposto imposto) {
		_impostos.put(PS, imposto);						// requisito 12
	}
}
