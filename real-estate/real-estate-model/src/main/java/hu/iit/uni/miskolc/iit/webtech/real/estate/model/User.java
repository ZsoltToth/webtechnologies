package hu.iit.uni.miskolc.iit.webtech.real.estate.model;

public class User implements Cloneable {

	private String nickName;
	private String email;
	private String phone;

	public User() {
		super();
	}

	public User(String nickName, String email, String phone) {
		super();
		this.nickName = nickName;
		this.email = email;
		this.phone = phone;
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	@Override
	public Object clone() throws CloneNotSupportedException {
		User clone = new User(nickName, email, phone);
		return clone;
	}

	/**
	 * Two users equals if their nickName is the same.
	 */
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof User == false) {
			return false;
		}
		return this.nickName.equals(((User)obj).nickName);
	}

	@Override
	public int hashCode() {
		return nickName.hashCode();
	}

	
}
