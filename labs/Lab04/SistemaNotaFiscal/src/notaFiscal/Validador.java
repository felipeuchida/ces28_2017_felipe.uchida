package notaFiscal;

import BD.BD_NF;
import BD.BD_Tax;

public class Validador {
	private BD_Tax _bdtax;
	
	public Validador(BD_Tax bdtax) {
		_bdtax = bdtax;
	}
	
	public boolean checarRequisitos(NotaFiscal NF) throws Exception {
		if(!NF.hasIV()) {
			throw new Exception("NF não contém IV's");
		}
		return true;
	}
	
	public void gerarID(NotaFiscal NF) {
		int id = new BD_NF(this).gerarID();
		NF.setID(id);
	}
	
	public double getImpostos(ItemVenda IV) {
		double valor = 0.0;
		valor = _bdtax.getImposto(IV).gerarImposto(IV);
		return valor;
	}
}
