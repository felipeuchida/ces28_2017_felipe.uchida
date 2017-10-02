package Q4;

import static org.junit.Assert.*;

import org.junit.Test;
import org.mockito.Mockito;

import Q4.orig.Calculadora;
import Q4.orig.Despesa;
import Q4.orig.Impressora;
import Q4.orig.IteratorDespesas;
import Q4.orig.RelatorioDespesas;
import Q4.orig.SistemaOperacional;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.Iterator;

public class RelatorioDespesasTest {

	// Letra b
	@Test
	public void WhenInitiateRelatorioDespesasThenIsOK() {
		RelatorioDespesas relatorio = mock(RelatorioDespesas.class);
		IteratorDespesas itDespesa = mock(IteratorDespesas.class);
		Calculadora calculadora = mock(Calculadora.class);
		Mockito.when(itDespesa.CalculaTotal(Mockito.any())).thenReturn(Mockito.anyFloat());
	}

}
