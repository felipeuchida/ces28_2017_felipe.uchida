import static org.junit.Assert.*;

import org.junit.Test;

public class CalculadoraStringTest {

	@Test
	// Teste para a tarefa 1
	public void test() {
		assertEquals(CalculadoraString.add("1,2"),3);
		assertEquals(CalculadoraString.add("1,30"),31);
		assertEquals(CalculadoraString.add("1,3,0"),4);
		assertEquals(CalculadoraString.add("1,3,10,86"),100);
		assertEquals(CalculadoraString.add("1,,,,,30"),31);
		assertEquals(CalculadoraString.add("1,, , ,,30  "),31);
		assertEquals(CalculadoraString.add("1 3 10,86"),100);
		assertEquals(CalculadoraString.add("      "),0);
		assertEquals(CalculadoraString.add(" ,,   ,,,,,,,  "),0);
		assertEquals(CalculadoraString.add(" ,,   ,,,,,5,,  "),5);
	}

}
