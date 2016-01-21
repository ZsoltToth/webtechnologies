package hu.iit.uni.miskolc.iit.webtech.real.estate.model;

import java.util.Date;

/**
 * It represents an advertisement about Residence. This ads are submitted by
 * users and will shown on the site.
 * 
 * @author zsolt
 *
 */
public class Residence implements Cloneable {

	/**
	 * Generated Id.
	 */
	private String residenceId;

	/**
	 * Name of the residence. It shall be short.
	 */
	private String name;

	/**
	 * Details of the residence.
	 */
	private String description;

	/**
	 * Address.
	 */
	private Address address;

	/**
	 * Price.
	 */
	private Price price;

	/**
	 * When the advertisement was published.
	 */
	private Date published;

	/**
	 * Expiration date of the ad.
	 */
	private Date expire;

	/**
	 * File path of the photo which represents the residence. It is required.
	 */
	private String mainPhotoPath;

	/**
	 * Multiple photos can be added to the residence. It is optional.
	 */
	private String[] phathOfPhotos;

	/**
	 * User who published the ad.
	 */
	private User contact;

	/**
	 * Default constructor for serialization; Do not use it.
	 */
	public Residence() {
		super();
	}

	/**
	 * 
	 * 
	 * @param residenceId 
	 * @param name 
	 * @param description 
	 * @param address 
	 * @param price 
	 * @param published 
	 * @param expire 
	 * @param mainPhotoPath 
	 * @param phathOfPhotos 
	 * @param contact 
	 */
	public Residence(final String residenceId, final String name, final String description, final Address address,
			final Price price, final Date published, final Date expire, final String mainPhotoPath,
			final String[] phathOfPhotos, final User contact) {
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

	/**
	 * 
	 * @return id of the advertisement.
	 */
	public final String getResidenceId() {
		return residenceId;
	}

	/**
	 * It is defined for serialization;
	 * Do not use it.
	 * 
	 * @param residenceId 
	 */
	public final void setResidenceId(final String residenceId) {
		this.residenceId = residenceId;
	}

	/**
	 * 
	 * @return Name of the residence.
	 */
	public final String getName() {
		return name;
	}

	/**
	 * 
	 * 
	 * @param name nem of the residence
	 */
	public final void setName(final String name) {
		this.name = name;
	}

	/**
	 * 
	 * @return description
	 */
	public final String getDescription() {
		return description;
	}

	/**
	 * 
	 * @param description 
	 */
	public final void setDescription(final String description) {
		this.description = description;
	}

	/**
	 * 
	 * @return address
	 */
	public final Address getAddress() {
		return address;
	}

	/**
	 * 
	 * @param address 
	 */
	public final void setAddress(final Address address) {
		this.address = address;
	}

	/**
	 * 
	 * @return price
	 */
	public final Price getPrice() {
		return price;
	}

	/**
	 * 
	 * @param price 
	 */
	public final void setPrice(final Price price) {
		this.price = price;
	}

	/**
	 * 
	 * @return publication date
	 */
	public final Date getPublished() {
		return published;
	}

	/**
	 * Defined for serialization.
	 * Do not use it.
	 * 
	 * @param published 
	 */
	public final void setPublished(final Date published) {
		this.published = published;
	}

	/**
	 * 
	 * @return expiration date
	 */
	public final Date getExpire() {
		return expire;
	}

	/**
	 * 
	 * @param expire 
	 */
	public final void setExpire(final Date expire) {
		this.expire = expire;
	}

	/**
	 * 
	 * @return file path of the main photo
	 */
	public final String getMainPhotoPath() {
		return mainPhotoPath;
	}

	/**
	 * 
	 * @param mainPhotoPath 
	 */
	public final void setMainPhotoPath(final String mainPhotoPath) {
		this.mainPhotoPath = mainPhotoPath;
	}

	/**
	 * 
	 * @return file path of all photos
	 */
	public final String[] getPhathOfPhotos() {
		return phathOfPhotos;
	}

	/**
	 * 
	 * @param phathOfPhotos 
	 */
	public final void setPhathOfPhotos(final String[] phathOfPhotos) {
		this.phathOfPhotos = phathOfPhotos;
	}

	/**
	 * 
	 * @return user who published the ad.
	 */
	public final User getContact() {
		return contact;
	}

	/**
	 * 
	 * @param contact 
	 */
	public final void setContact(final User contact) {
		this.contact = contact;
	}

	@Override
	public final Object clone() throws CloneNotSupportedException {
		Residence clone = new Residence(residenceId, name, description, (Address) address.clone(),
				(Price) price.clone(), (Date) published.clone(), (Date) expire.clone(), mainPhotoPath, phathOfPhotos,
				(User) contact.clone());
		return clone;
	}

	@Override
	public final int hashCode() {
		return residenceId.hashCode();
	}

	@Override
	public final boolean equals(final Object obj) {
		if (!(obj instanceof Residence)) {
			return false;
		}
		return residenceId.equals(((Residence) obj).residenceId);
	}

}
