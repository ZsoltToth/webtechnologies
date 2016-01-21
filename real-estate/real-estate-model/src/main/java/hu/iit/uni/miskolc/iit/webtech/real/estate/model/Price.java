package hu.iit.uni.miskolc.iit.webtech.real.estate.model;

import java.util.Currency;

/**
 * Represents an amount of money with its currency.
 * 
 * @author zsolt
 *
 */
public class Price implements Cloneable {

	/**
	 * Currency of the money.
	 */
	private Currency currency;
	/**
	 * Amount of the money.
	 */
	private double ammount;

	/**
	 * Default constructor.
	 * It is defined for serialization.
	 * It should not be used.
	 */
	public Price() {
		super();
	}

	/**
	 * It should be used.
	 * 
	 * @param currency 
	 * @param ammount 
	 */
	public Price(final Currency currency, final double ammount) {
		super();
		this.currency = currency;
		this.ammount = ammount;
	}

	/**
	 * 
	 * @return the actual currency
	 */
	public final Currency getCurrency() {
		return currency;
	}

	/**
	 * 
	 * @param currency 
	 */
	public final void setCurrency(final Currency currency) {
		this.currency = currency;
	}

	/**
	 * 
	 * @return amount of money without currency
	 */
	public final double getAmmount() {
		return ammount;
	}

	/**
	 * 
	 * @param ammount 
	 */
	public final void setAmmount(final double ammount) {
		this.ammount = ammount;
	}

	@Override
	public final Object clone() throws CloneNotSupportedException {
		return new Price(currency, ammount);
	}

}
