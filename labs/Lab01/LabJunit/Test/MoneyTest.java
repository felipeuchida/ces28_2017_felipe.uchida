import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class MoneyTest {
	private  MoneyList ml;
	private Money BRL10;
	private Money CHF05;
	private Money USD15;
	
	@Before
	public void setUp() throws Exception {
		ml = new MoneyList();
		BRL10 = new Money(10,"BRL");
		CHF05 = new Money( 5,"CHF");
		USD15 = new Money(15,"USD");
		ml.add(BRL10);
		ml.add(CHF05);
		ml.add(USD15);
	}
	
	@Test
	public void WhenMoneyAreAddedWIthSameCurrencyThenMoneyAmountAddedUp() {
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
}
