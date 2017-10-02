package Q4.orig;

import java.util.Iterator;

public class IteratorDespesas {
	public float CalculaTotal(Iterator<Despesa> despesas) {
		float totalDespesa = 0.0f;
		while (despesas.hasNext()) {
			Despesa desp = despesas.next();
			float despesa = desp.getDespesa();
			totalDespesa+= despesa;
		}
		return totalDespesa;
	}
}
