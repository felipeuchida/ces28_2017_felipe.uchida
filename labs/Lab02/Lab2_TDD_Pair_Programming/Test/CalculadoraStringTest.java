import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.Rule;
import org.junit.rules.ExpectedException;

public class CalculadoraStringTest {
/*
	@Test
	// Teste para a tarefa 1
	public void WhenEmptyThenReturnsZero() {
		assertEquals(CalculadoraString.add(""),0);
		assertEquals(CalculadoraString.add(" "),0);
		assertEquals(CalculadoraString.add(","),0);
		assertEquals(CalculadoraString.add(" ,,, ,, "),0);
	}
	@Test
	// Teste para a tarefa 1
	public void WhenUseEspaceAndCommaThenReturnsSum() {
		assertEquals(CalculadoraString.add("1,2"),3);
		assertEquals(CalculadoraString.add("1,30"),31);
		assertEquals(CalculadoraString.add("1,3,0"),4);
		assertEquals(CalculadoraString.add("1,3,10,86"),100);
		assertEquals(CalculadoraString.add("1 3 10,86"),100);
	}

	@Test
	// Teste para a tarefa 2
	public void WhenUseEspaceAndCommaConjugatedThenReturnsSum() {
		assertEquals(CalculadoraString.add("1,,,,,30"),31);
		assertEquals(CalculadoraString.add("1,, , ,,30  "),31);
		assertEquals(CalculadoraString.add("      "),0);
		assertEquals(CalculadoraString.add(" ,,   ,,,,,,,  "),0);
		assertEquals(CalculadoraString.add(" ,,   ,,,,,5,,  "),5);
	}

	@Test
	// Teste para a tarefa 3
	public void WhenUseNewLineThenReturnsSum() {
		assertEquals(CalculadoraString.add("1\n2,3"),6);
		assertEquals(CalculadoraString.add("1,\n"),1);
		assertEquals(CalculadoraString.add(" ,,  \n\n 22\n\n\n,,,,,5,, \n "),27);
	}

	@Test
	// Teste para a tarefa 4
	public void WhenUseDifferentDelimiterThenReturnsSum() {
		assertEquals(CalculadoraString.add("//[;]"),0);
		assertEquals(CalculadoraString.add("//[;]\n ,,,; "),0);
		assertEquals(CalculadoraString.add("//[;]\n1;2"),3);
		assertEquals(CalculadoraString.add("//[;]\n1;2,3\n4"),10);
	}
	*/
	@Rule
	public ExpectedException expectedException = ExpectedException.none();
	
	@Test
	// Teste para a tarefa 5
	public void WhenNegativeNumbersThenReturnsException() {
		expectedException.expect(IllegalArgumentException.class);
		expectedException.expectMessage("negativos proibidos [-1445 -31 -3]");
		CalculadoraString.add("-1445 448,,,,, -31 555555 -3");
	}
	
	@Test
	// Teste para a tarefa 5
	public void WhenNegativeNumbersBegginingWithZeroThenReturnsException() {
		expectedException.expect(IllegalArgumentException.class);
		expectedException.expectMessage("negativos proibidos [-1445 -3166 -3]");
		CalculadoraString.add("-00001445 448,,,,, -003166 555555 -03");
	}
}
