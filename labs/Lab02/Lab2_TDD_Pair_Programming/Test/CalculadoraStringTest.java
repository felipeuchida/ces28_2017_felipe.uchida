import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.Rule;
import org.junit.rules.ExpectedException;

public class CalculadoraStringTest {
	@Rule
	public ExpectedException expectedException = ExpectedException.none();
	
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

	@Test
	// Teste para a tarefa 6
	public void WhenNumberIsBiggerThen1000ThenIgnoreIt() {
		assertEquals(CalculadoraString.add("//[;]\n1;2 1001 4"),7);
		assertEquals(CalculadoraString.add("//[;]\n1;2, 10000 3\n4"),10);
		assertEquals(CalculadoraString.add(" ,1001,, 99999,, "),0);
	}
	
	@Test
	// Teste para a tarefa 7
	public void WhenUseDifferentDelimiterWithAnyLengthThenReturnsSum() {
		assertEquals(CalculadoraString.add("//[d+]\n"),0);
		assertEquals(CalculadoraString.add("//[***]\n1***2***3"),6);
		assertEquals(CalculadoraString.add("//[***]\n1***2,3\n4"),10);
	}
	
	@Test
	// Teste para a tarefa 8
	public void WhenUseDifferentDelimitersThenReturnsSum() {
		assertEquals(CalculadoraString.add("//[*][%]\n1*2%3"),6);
		assertEquals(CalculadoraString.add("//[*][%]\n1*2%3\n4,5"),15);
		assertEquals(CalculadoraString.add("//[*][%][a][b]\n1*2%3\n4,5aaa10bbb90"),115);
	}
	
	@Test
	// Teste para a tarefa 9
	public void WhenUseDifferentDelimitersWithAnyLengthThenReturnsSum() {
		assertEquals(CalculadoraString.add("//[***][%]\n1***2%3"),6);
		assertEquals(CalculadoraString.add("//[*asdf][%asdf]\n1*asdf2%asdf3\n4,5"),15);
		assertEquals(CalculadoraString.add("//[*][%][aa][bb]\n1*2%3\n4,5aaaa10bbbb90"),115);
	}
	
	@Test
	// Teste para o FAQ e Casos Especiais 1
	// Se a entrada começar com "//[***]\n", então desconsidero * e ** como delimitadores ou *, ** e *** serão delimitadores?
	public void WhenUseDifferentDelimitersWithAnyLengthThenSubstringsOfThisDelimitersArentDelimiter() {
		expectedException.expect(IllegalArgumentException.class);
		expectedException.expectMessage("Entrada inválida e não-tratável");
		CalculadoraString.add("//[***]\n1*2**3");
	}
	
	@Test
	// Teste para o FAQ e Casos Especiais 2
	// Os colchetes, '[' , ']'  podem ser delimitadores?
	public void WhenUseOpenerBracketAsDelimiterThenException() {
		expectedException.expect(IllegalArgumentException.class);
		expectedException.expectMessage("Entrada inválida e não-tratável");
		CalculadoraString.add("//[[]\n");
	}
	
	@Test
	// Teste para o FAQ e Casos Especiais 2
	public void WhenUseClosenerBracketAsDelimiterThenException() {
		expectedException.expect(IllegalArgumentException.class);
		expectedException.expectMessage("Entrada inválida e não-tratável");
		CalculadoraString.add("//[]]\n");
	}
	
	@Test
	// Teste para o FAQ e Casos Especiais 3
	// Caracteres que são digitos, e.g. ‘2’'  podem ser delimitadores?
	public void WhenUseNumberAsDelimiterThenException() {
		expectedException.expect(IllegalArgumentException.class);
		expectedException.expectMessage("Entrada inválida e não-tratável");
		CalculadoraString.add("//[3]\n");
	}
	
	@Test
	// Teste para o FAQ e Casos Especiais 4
	// Tab eh diferente de espaço em branco?
	public void WhenDontDefineTabAsDelimiterThenExceptionIfUsed() {
		expectedException.expect(IllegalArgumentException.class);
		expectedException.expectMessage("Entrada inválida e não-tratável");
		CalculadoraString.add("//[*]****\t");
	}
	
	@Test
	// Teste para o FAQ e Casos Especiais 5
	/* "//[-]\n -1--2- -3- \n-4-,-5" devo retornar apenas uma excecao ou retorno uma excecao com a mensagem 
 	"negativos proibidos [-2 -3 -4 -5]" ou seria "negativos proibidos [-2]" ou seria "negativos proibidos [-2 -3]"?*/
	public void WhenDefineMinusAsDelimiterThenMinusIsLikeSpace() {
		assertEquals(CalculadoraString.add("//[-]\n -1--2- -3- \n-4-,-5"),CalculadoraString.add("1,2,3,4,5"));
		assertEquals(CalculadoraString.add("//[-]\n -1--2- -3- \n-4-,-5"),15);
	}
	
	@Test
	// Teste para o FAQ e Casos Especiais 6
	/*" -0 -1001 -2 -2" retorno uma excecao com a mensagem "negativos proibidos [-2]" ou "negativos proibidos [ -0 -2 -1001]" 
	 * ou "negativos proibidos [-2 -1001]" ou "negativos proibidos [-1001 -2]" ou "negativos proibidos [-0 -1001 -2 -2]" ou uma outra forma?*/
	public void WhenNumberIsSmallerThenMinus1000ThenAlsoHasPartOnTheException() {
		expectedException.expect(IllegalArgumentException.class);
		expectedException.expectMessage("negativos proibidos [-1001 -2 -2]");
		CalculadoraString.add(" -0 -1001 -2 -2");
	}
	
	@Test
	// Teste para o FAQ e Casos Especiais 7
	// Se vier "-0", devo retornar 0 ou mando uma exceção com a mensagem "negativos proibidos [-0]"
	public void WhenMinusZeroThenEqualsZero() {
		assertEquals(CalculadoraString.add("-0"),0);
		assertEquals(CalculadoraString.add("-  0"),0);
	}
}
