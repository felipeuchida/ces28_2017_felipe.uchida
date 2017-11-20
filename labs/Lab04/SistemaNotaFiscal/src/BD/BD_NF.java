package BD;

import java.util.HashMap;
import java.util.Map;

import notaFiscal.NotaFiscal;
import notaFiscal.Validador;

public class BD_NF {
	private Validador _validador;
	private static int _id = 0;									// requisito 7
	public Map<Integer, NotaFiscal> _validadas;
	
	public BD_NF(Validador validador) {
		_validador = validador;
		_validadas = new HashMap<Integer, NotaFiscal>();
	}
	
	public int gerarID() {
		return _id++;											// requisito 7
	}
	
	public NotaFiscal validar(NotaFiscal NF) throws Exception {
		if(!_validador.checarRequisitos(NF)) {
			throw new Exception("NF não cumpre os requisitos!");
		}
		NF.setID(gerarID());									// requisito 7
		NF.setEstado("validada");
		_validadas.put(NF.getID(), NF);
		return NF;												// ************ falta fazer a nota ser Imutável
	}
}
