package hu.iit.uni.miskolc.iit.webtech.real.estate.model;

/**
 * Represents an address.
 * 
 * 
 * @author zsolt
 *
 */
public class Address implements Cloneable {

	/**
	 * 
	 */
	private String country;
	/**
	 * 
	 */
	private String county;
	/**
	 * 
	 */
	private String city;
	/**
	 * 
	 */
	private String zipCode;
	/**
	 * 
	 */
	private String street;
	/**
	 * 
	 */
	private String door;

	/**
	 * Default constructor for serialization. It should not be used.
	 */
	public Address() {
		super();
	}

	/**
	 * It should be used.
	 * 
	 * @param country 
	 * @param county 
	 * @param city 
	 * @param zipCode 
	 * @param street 
	 * @param door 
	 */
	public Address(final String country, final String county, final String city, final String zipCode,
			final String street, final String door) {
		super();
		this.country = country;
		this.county = county;
		this.city = city;
		this.zipCode = zipCode;
		this.street = street;
		this.door = door;
	}

	/**
	 * 
	 * @return name of the country
	 */
	public final String getCountry() {
		return country;
	}

	/**
	 * 
	 * @param country 
	 */
	public final void setCountry(final String country) {
		this.country = country;
	}

	/**
	 * 
	 * @return name of the county
	 */
	public final String getCounty() {
		return county;
	}

	/**
	 * 
	 * @param county 
	 */
	public final void setCounty(final String county) {
		this.county = county;
	}

	/**
	 * 
	 * @return name of the city
	 */
	public final String getCity() {
		return city;
	}

	/**
	 * 
	 * @param city 
	 */
	public final void setCity(final String city) {
		this.city = city;
	}

	/**
	 * 
	 * @return zip code or postal code
	 */
	public final String getZipCode() {
		return zipCode;
	}

	/**
	 * 
	 * @param zipCode 
	 */
	public final void setZipCode(final String zipCode) {
		this.zipCode = zipCode;
	}

	/**
	 * 
	 * @return name of the street
	 */
	public final String getStreet() {
		return street;
	}

	/**
	 * 
	 * @param street 
	 */
	public final void setStreet(final String street) {
		this.street = street;
	}

	/**
	 * 
	 * @return door number or house number.
	 */
	public final String getDoor() {
		return door;
	}

	/**
	 * 
	 * @param door number of door or house
	 */
	public final void setDoor(final String door) {
		this.door = door;
	}

	@Override
	public final Object clone() throws CloneNotSupportedException {
		return new Address(country, county, city, zipCode, street, door);
	}

}
