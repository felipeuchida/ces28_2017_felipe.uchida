import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class MoneyTest {
	private  MoneyBag ml;
	private Money BRL10;
	private Money CHF05;
	private Money USD15;

	@Before
	public void setUp() throws Exception {
		ml = new MoneyBag();
		BRL10 = new Money(10,"BRL");
		CHF05 = new Money( 5,"CHF");
		USD15 = new Money(15,"USD");
		ml.add(BRL10);
		ml.add(CHF05);
		ml.add(USD15);
	}

	@Test
	// Teste com base em assertTrue (Processo 02)
	public void WhenMoneyAreAddedWIthSameCurrencyInMonaybagThenMoneyAmountAddedUp() {
		assertTrue(ml.contains(BRL10));
		assertTrue(ml.contains(CHF05));
		assertTrue(ml.contains(USD15));

		Money BRL5 = new Money(5,"BRL");
		Money BRL15 = new Money(15,"BRL");
		Money BRL16 = new Money(16,"BRL");
		ml.add(BRL5);
		assertTrue(ml.contains(BRL15));
		assertTrue(!ml.contains(BRL16));

		Money CHF17 = new Money(17,"CHF");
		Money CHF22 = new Money(22,"CHF");
		ml.add(CHF17);
		assertTrue(ml.contains(CHF22));

		Money EUR30 = new Money(30,"EUR");
		ml.add(EUR30);
		assertTrue(ml.contains(EUR30));
	}

	@Test
	// Teste com base em assertEquals (Processo 03)
	public void WhenMoneyAreAddedWIthSameCurrencyThenMoneyAmountAddedUp() {
		Money BRL = new Money(5,"BRL");
		Money BRL15 = new Money(15,"BRL");
		BRL.add(BRL15);
		assertEquals(BRL.getAmount(),20);
		Money BRL20 = new Money(20,"BRL");
		assertEquals(BRL,BRL20);
	}

	@Test
	// Teste para o m�todo add do MoneyBag (Processo 08)
	public void WhenListsHaveSameElementsThenListsAreEqual() {
		// Mesma ordem de elementos
		MoneyBag actual = new MoneyBag();
		actual.add(new Money(10,"BRL"));
		actual.add(new Money( 5,"CHF"));
		actual.add(new Money(15,"USD"));
		assertEquals(ml,actual);

		// Ordem diferente de elementos
		MoneyBag actual2 = new MoneyBag();
		actual2.add(new Money(15,"USD"));
		actual2.add(new Money(10,"BRL"));
		actual2.add(new Money( 5,"CHF"));
		assertEquals(ml,actual2);
	}

	@Test
	// Teste para o m�todo size do MoneyBag (Processo 08)
	public void WhenListsHaveSameNumberOfElementsThenReturnOk() {
		assertEquals(ml.size(),3);

		MoneyBag actual2 = new MoneyBag();
		actual2.add(new Money(15,"USD"));
		actual2.add(new Money(10,"BRL"));
		actual2.add(new Money( 5,"CHF"));
		actual2.add(new Money( 5,"XX1"));
		actual2.add(new Money( 5,"XX2"));
		assertEquals(actual2.size(), 5);
	}

	@Test
	// Teste para o m�todo contains do MoneyBag (Processo 08)
	public void WhenListContainElementThenReturnOk() {
		assertTrue(ml.contains(BRL10));
		assertTrue(ml.contains(CHF05));
		assertTrue(ml.contains(USD15));

		Money XXX = new Money(5,"XXX");
		ml.add(XXX);
		assertTrue(ml.contains(XXX));
	}

	@Test
	// Testando para o m�todo showBag do MoneyBag (Processo 09)
	public void WhenWeHaveElementsThenWePrintThey(){
		String[] mlCurrencies = {"BRL","CHF","USD"};
		assertEquals(mlCurrencies,ml.showBag());
		String[] mlCurrencies2 = {"BRL","CHF","USD", "XXX"};
		Money XXX = new Money(5,"XXX");
		ml.add(XXX);
		assertEquals(mlCurrencies2,ml.showBag());
	}
}
