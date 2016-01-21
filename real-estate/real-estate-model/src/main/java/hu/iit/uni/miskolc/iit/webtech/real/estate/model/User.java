package hu.iit.uni.miskolc.iit.webtech.real.estate.model;

/**
 * It represents a User.
 * The users are identified by their nickName and 
 * their email address is also unique.
 * 
 * 
 * @author zsolt
 *
 */
public class User implements Cloneable {

	/**
	 * nickName of the user. It is known by other users.
	 */
	private String nickName;
	
	/**
	 * email of the User. It is used to send messages to the user by the system.
	 */
	private String email;
	
	/**
	 * phone number of the user. It souldn't be public to other users.
	 */
	private String phone;

	/**
	 * Default constructor. It is used for JSON serialization. 
	 */
	public User() {
		super();
	}

	/**
	 * 
	 * @param nickName nickName of the user
	 * @param email email address of the user
	 * @param phone phone number of the user
	 */
	public User(final String nickName, final String email, final String phone) {
		super();
		this.nickName = nickName;
		this.email = email;
		this.phone = phone;
	}

	/**
	 * 
	 * @return the nick name of the user
	 */
	public final String getNickName() {
		return nickName;
	}

	/**
	 * It tends to be used during JSON serialization.
	 * 
	 * @param nickName sets the nickName of the user.
	 */
	public final void setNickName(final String nickName) {
		this.nickName = nickName;
	}

	/**
	 * 
	 * @return email address of the user
	 */
	public final String getEmail() {
		return email;
	}

	/**
	 * It tends to be used during the serialization.
	 * 
	 * 
	 * @param email email address of the user.
	 */
	public final void setEmail(final String email) {
		this.email = email;
	}

	/**
	 * Returns with the phone number of the user.
	 * 
	 * @return phone number as string
	 */
	public final String getPhone() {
		return phone;
	}

	/**
	 * Sets the phone number of the user to the new phone number.
	 * Validation is not performed.
	 * 
	 * @param phone new phone number of the user
	 */
	public final void setPhone(final String phone) {
		this.phone = phone;
	}

	@Override
	public final Object clone() throws CloneNotSupportedException {
		User clone = new User(nickName, email, phone);
		return clone;
	}

	/**
	 * Two users equals if their nickName is the same.
	 */
	@Override
	public final boolean equals(final Object obj) {
		if (!(obj instanceof User)) {
			return false;
		}
		return this.nickName.equals(((User) obj).nickName);
	}

	@Override
	public final int hashCode() {
		return nickName.hashCode();
	}

	
}
