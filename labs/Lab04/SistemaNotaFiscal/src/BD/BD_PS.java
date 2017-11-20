package BD;

import java.util.HashMap;
import java.util.Map;

import notaFiscal.ProdutoServico;

public class BD_PS {
	private Map<String, ProdutoServico> _catalogo;
	
	public BD_PS() {
		_catalogo = new HashMap<String, ProdutoServico>();
	}
	
	public boolean hasPS(String nome) {
		return _catalogo.containsKey(nome);
	}
	
	public ProdutoServico getPS(String nome) throws Exception{
		if(!hasPS(nome)) {
			throw new Exception("Produto/Serviço não consta no BD_PS");
		}
		return _catalogo.get(nome);
	}
}
