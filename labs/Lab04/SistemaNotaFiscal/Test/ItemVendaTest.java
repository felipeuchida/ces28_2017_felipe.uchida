import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
//import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;

import BD.BD_NF;
import BD.BD_PS;
import BD.BD_Tax;
import notaFiscal.ImpostoFoo;
import notaFiscal.ItemVenda;
import notaFiscal.NotaFiscal;
import notaFiscal.Produto;
import notaFiscal.ProdutoServico;
import notaFiscal.Servico;
import notaFiscal.Validador;

public class ItemVendaTest {
	private NotaFiscal _NF;
	private ItemVenda _IV;
	private static BD_PS _bdps;
	private static BD_NF _bdnf;
	private static BD_Tax _bdtax;
	private static Validador _validador;
	
	@Before
	public void setUpBeforeClass() throws Exception {
		_bdps = mock(BD_PS.class);
		_bdtax = mock(BD_Tax.class);
		_validador = mock(Validador.class);
	}

	@Test
	public void requisito_1() throws Exception {
		when(_bdps.getPS("Lollipop")).thenReturn(new ProdutoServico("Lollipop"));
		_IV = new ItemVenda("Lollipop", 1, _bdps);
		_NF = new NotaFiscal(_IV);		// o construtor precisar receber
		assertTrue(_NF.hasIV());		// um IV ja garante o requisito 1	
	}
	
	@Test
	public void requisito_2_UmIvEmMaisDeUmaNotaGeraExcecao() throws Exception{
		when(_bdps.getPS("Lollipop")).thenReturn(new ProdutoServico("Lollipop"));
		_IV = new ItemVenda("Lollipop", 1, _bdps);
		_NF = new NotaFiscal(_IV);
		boolean thrown = false;

		  try {
			  NotaFiscal NF2 = new NotaFiscal(_IV);
		  } catch (Exception e) {
		    thrown = true;
		  }

		 assertTrue(thrown);
		//assertThrows(Exception.class, ()->{NotaFiscal NF2 = new NotaFiscal(_IV);});
	}
	
	@Test
	public void requisito_3() throws Exception {
		when(_bdps.getPS("Lollipop")).thenReturn(new ProdutoServico("Lollipop"));
		_IV = new ItemVenda("Lollipop", 1, _bdps);
		assertEquals(_IV.getPS(), _bdps.getPS("Lollipop"));
	}

	// requisito 4 -> composite patterns implementado em ProdutoServico
	
	@Test
	public void requisito_5_NFAdicionarPSNaoCadastradoGeraExcecao() throws Exception {
		when(_bdps.hasPS("Lollipop")).thenReturn(false);
		BD_PS bdps = new BD_PS();
		
		boolean thrown = false;

		  try {
		  _IV = new ItemVenda("Lollipop", 1, bdps);
		  } catch (Exception e) {
		    thrown = true;
		  }

		 assertTrue(thrown);
		 
		//assertThrows(Exception.class, ()->{_IV = new ItemVenda("Lollipop", 1, bdps);});
	}
	
	@Test
	public void requisito_6() throws Exception {
		when(_bdps.getPS("Lollipop")).thenReturn(new ProdutoServico("Lollipop"));
		_IV = new ItemVenda("Lollipop", 1, _bdps);
		_NF = new NotaFiscal(_IV);
		//assertTrue(_NF.getEstado().equals("em elaboracao"));
	}
	
	@Test
	public void requisito_7() throws Exception {
		when(_bdps.getPS("Lollipop")).thenReturn(new ProdutoServico("Lollipop"));
		when(_bdps.getPS("Bubbaloo")).thenReturn(new ProdutoServico("Bubbaloo"));
		_IV = new ItemVenda("Lollipop", 1, _bdps);
		ItemVenda IV2 = new ItemVenda("Bubbaloo", 1, _bdps);
		_NF = new NotaFiscal(_IV);
		NotaFiscal NF2 = new NotaFiscal(IV2);
		
		when(_validador.checarRequisitos(_NF)).thenReturn(true);
		when(_validador.checarRequisitos(NF2)).thenReturn(true);
		_bdnf = new BD_NF(_validador);
		_bdnf.validar(_NF);															// ********** falta tornar as NFs imutáveis
		_bdnf.validar(NF2);
		assertEquals(NF2.getID(), _NF.getID()+1);
	}
	
	@Test
	public void requisito_8() throws Exception {
		when(_bdps.getPS("Apple")).thenReturn(new ProdutoServico("Apple"));
		_IV = new ItemVenda("Apple", 1, _bdps);
		when(_bdtax.getImposto(_IV)).thenReturn(new ImpostoFoo(0.15));
		_NF = new NotaFiscal(_IV);
		Validador validador = new Validador(_bdtax);
		_NF.validar(validador);
		double imposto = _NF.calcularImpostos(validador);
		assertEquals(imposto, 0.15, 0.01);
	}
	
	@Test
	public void requisitos_9_10() throws Exception {
		when(_bdps.getPS("Lollipop")).thenReturn(new ProdutoServico("Lollipop"));
		_IV = new ItemVenda("Lollipop", 1, _bdps);
		_NF = new NotaFiscal(_IV);
		ImpostoFoo imposto = new ImpostoFoo(0.15);
		assertEquals(imposto.gerarImposto(_IV), 0.25, 0.01);
	}
	
	// requisito 12 -> na implementacao
	
	// requisito 13 -> método readIVs() de NF -> unmodifiable list
	
	// requisito 15 -> pattern strategy: Imposto é abstrato. Novos impostos devem extender e sobrescrever o método gerarImposto(ItemVenda)

	// requisito 16 -> na implementacao
	
	@Test
	public void requisitos_17() {		
		Produto esperado = null;
        try{
        	when(_bdps.getPS("Lollipop")).thenReturn(new ProdutoServico("Lollipop"));
    		_IV = new ItemVenda("Lollipop", 1, _bdps);
    		_NF = new NotaFiscal(_IV);
    		ImpostoFoo imposto = new ImpostoFoo(0.15);
    		assertEquals(imposto.gerarImposto(_IV), 0.25, 0.01);
        } catch(Exception e){
            fail(e.getMessage());
        }
	}
	
	// requisito 18, 19, 20, 21 -> na implementacao
}
