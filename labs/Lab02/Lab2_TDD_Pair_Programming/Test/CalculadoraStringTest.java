import static org.junit.Assert.*;

import org.junit.Test;

public class CalculadoraStringTest {

	@Test
	// Teste para a tarefa 1
	public void WhenEmptyThenReturnsZero() {
		assertEquals(CalculadoraString.add(""),0);
		assertEquals(CalculadoraString.add(" "),0);
		assertEquals(CalculadoraString.add(","),0);
		assertEquals(CalculadoraString.add(" ,,, ,, "),0);
	}
	public void WhenUseEspaceAndCommaThenReturnsSum() {
		assertEquals(CalculadoraString.add("1,2"),3);
		assertEquals(CalculadoraString.add("1,30"),31);
		assertEquals(CalculadoraString.add("1,3,0"),4);
		assertEquals(CalculadoraString.add("1,3,10,86"),100);
		assertEquals(CalculadoraString.add("1 3 10,86"),100);
	}

	// Teste para a tarefa 2
	public void WhenUseEspaceAndCommaConjugatedThenReturnsSum() {
		assertEquals(CalculadoraString.add("1,,,,,30"),31);
		assertEquals(CalculadoraString.add("1,, , ,,30  "),31);
		assertEquals(CalculadoraString.add("      "),0);
		assertEquals(CalculadoraString.add(" ,,   ,,,,,,,  "),0);
		assertEquals(CalculadoraString.add(" ,,   ,,,,,5,,  "),5);
	}

	// Teste para a tarefa 3
	public void WhenUseNewLineThenReturnsSum() {
		assertEquals(CalculadoraString.add("1\n2,3"),6);
		assertEquals(CalculadoraString.add("1,\n"),1);
		assertEquals(CalculadoraString.add(" ,,  \n\n 22\n\n\n,,,,,5,, \n "),27);
	}

}
