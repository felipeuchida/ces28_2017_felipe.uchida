package notaFiscal;

import java.util.ArrayList;
import java.util.List;

public class ProdutoServico {
	private String _nome;
	private double _preco;
	private List<ProdutoServico> _subordinates;			// composite -> requisito 4
	private ProdutoServico _father;
	
	public ProdutoServico(String produto) {
		_nome = produto;
		_subordinates = new ArrayList<ProdutoServico>();
	}
	
	public String getName() {
		return _nome;
	}
	
	private void setFather(ProdutoServico ps) {
		_father = ps;
	}
	
	public void add(ProdutoServico ps) {
		_subordinates.add(ps);
		ps.setFather(this);
	}
	
	public void remove(ProdutoServico ps) {
		_subordinates.remove(ps);
	}
	
	public List<ProdutoServico> getSubordinates() {
		return _subordinates;
	}
}
