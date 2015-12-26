package hu.iit.uni.miskolc.iit.webtech.real.estate.model;

import java.util.Date;

public class Residence {
	
	private String residenceId;
	private String name;
	private String description;
	private Address address;
	private Price price;
	private Date published;
	private Date expire;
	private String mainPhotoPath;
	private String[] phathOfPhotos;
	private User contact;

	public Residence() {
		super();
	}

	public Residence(String residenceId, String name, String description,
			Address address, Price price, Date published, Date expire,
			String mainPhotoPath, String[] phathOfPhotos, User contact) {
		super();
		this.residenceId = residenceId;
		this.name = name;
		this.description = description;
		this.address = address;
		this.price = price;
		this.published = published;
		this.expire = expire;
		this.mainPhotoPath = mainPhotoPath;
		this.phathOfPhotos = phathOfPhotos;
		this.contact = contact;
	}

	public String getResidenceId() {
		return residenceId;
	}

	public void setResidenceId(String residenceId) {
		this.residenceId = residenceId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public Price getPrice() {
		return price;
	}

	public void setPrice(Price price) {
		this.price = price;
	}

	public Date getPublished() {
		return published;
	}

	public void setPublished(Date published) {
		this.published = published;
	}

	public Date getExpire() {
		return expire;
	}

	public void setExpire(Date expire) {
		this.expire = expire;
	}

	public String getMainPhotoPath() {
		return mainPhotoPath;
	}

	public void setMainPhotoPath(String mainPhotoPath) {
		this.mainPhotoPath = mainPhotoPath;
	}

	public String[] getPhathOfPhotos() {
		return phathOfPhotos;
	}

	public void setPhathOfPhotos(String[] phathOfPhotos) {
		this.phathOfPhotos = phathOfPhotos;
	}

	public User getContact() {
		return contact;
	}

	public void setContact(User contact) {
		this.contact = contact;
	}

}
