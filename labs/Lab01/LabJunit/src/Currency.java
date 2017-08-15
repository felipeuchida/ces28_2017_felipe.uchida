public class Currency {
	private String _currency;
	
	public Currency(String currency) {
		setCurrency(currency);
	}
	
	public void setCurrency(String currency) {
		this._currency = currency;
	}

	public String getCurrency() {
		return _currency;
	}
}
