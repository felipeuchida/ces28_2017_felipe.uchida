package notaFiscal;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author lucas1jorge
 *
 */
  
public class NotaFiscal {
	private List<ItemVenda> _iv;
	private String _estado;
	private int _id;
	
	public NotaFiscal (ItemVenda IV) throws Exception {
		this._iv = new ArrayList<ItemVenda>();
		this._estado = "em elaboraçao";									// requisito 6
		this.addIV(IV);													// requisito 1
	}
	
	public boolean hasIV() {
		return !_iv.isEmpty();
	}
	
	public void validar(Validador validador) throws Exception {
		if(!_estado.equals("em elaboraçao")) {
			throw new Exception("NF já foi validada!");					// requisito 6
		}
		validador.checarRequisitos(this);								// requisito 1
		validador.gerarID(this);										// conceito 6						// *********** falta tornar imutável
	}
	
	public double calcularImpostos(Validador validador) {
		double total = 0.0;
		for(ItemVenda item :_iv) {
			total += validador.getImpostos(item);
		}
		return total;
	}
	
	public int getID() {
		return _id;
	}
	
	public void setID(int id) {
		_id = id;
	}
	
	public String getEstado() {
		return _estado;
	}
	
	public void setEstado(String estado) {
		_estado = estado;
	}
	
	public List<ItemVenda> readIVs() {
		List<ItemVenda> iv_copy = Collections.unmodifiableList(_iv);	// requisito 13
		return iv_copy;
	}
		
	public void addIV(ItemVenda IV) throws Exception{
		if(!_estado.equals("em elaboraçao")) {
			throw new Exception("NF já foi validada!");
		}
		if(!_iv.contains(IV)) {
			IV.comprar();
			_iv.add(IV);
		} else {
			// aumentar quantidade
		}
	}
}