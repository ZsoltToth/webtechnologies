package hu.iit.uni.miskolc.iit.webtech.real.estate.model;

public class Address implements Cloneable{

	private String country;
	private String county;
	private String city;
	private String zipCode;
	private String street;
	private String door;

	public Address() {
		super();
	}

	public Address(String country, String county, String city, String zipCode,
			String street, String door) {
		super();
		this.country = country;
		this.county = county;
		this.city = city;
		this.zipCode = zipCode;
		this.street = street;
		this.door = door;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getCounty() {
		return county;
	}

	public void setCounty(String county) {
		this.county = county;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getDoor() {
		return door;
	}

	public void setDoor(String door) {
		this.door = door;
	}

	@Override
	public Object clone() throws CloneNotSupportedException {
		return new Address(country, county, city, zipCode, street, door);
	}

	
}
