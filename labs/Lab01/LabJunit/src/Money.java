public class Money {
	private int _amount;
	private String _currency;
	
	public Money(int amount, String currency) {
		setAmount(amount);
		setCurrency(currency);
	}
	
	public void setAmount(int amount) {
		this._amount = amount;
	}
	
	public void setCurrency(String currency) {
		this._currency = currency;
	}
	
	public int getAmount() {
		return _amount;
	}

	public String getCurrency() {
		return _currency;
	}
	
	// Compara objetos money, se amount e currency forem iguais, então os objetos são iguais
	public boolean equals(Object anObject) {
		if (anObject instanceof Money) {
			Money aMoney = (Money) anObject;
			return	aMoney.getCurrency().equals(this.getCurrency()) && this.getAmount() == aMoney.getAmount();
		}
		return false;
	}
}
