package hu.iit.uni.miskolc.iit.webtech.real.estate.model;

public class Price {

	public static enum Currency {
		USD, HUF, EUR, AUD
	}

	private Currency currency;
	private double ammount;

	public Price() {
		super();
	}

	public Price(Currency currency, double ammount) {
		super();
		this.currency = currency;
		this.ammount = ammount;
	}

	public Currency getCurrency() {
		return currency;
	}

	public void setCurrency(Currency currency) {
		this.currency = currency;
	}

	public double getAmmount() {
		return ammount;
	}

	public void setAmmount(double ammount) {
		this.ammount = ammount;
	}

}
