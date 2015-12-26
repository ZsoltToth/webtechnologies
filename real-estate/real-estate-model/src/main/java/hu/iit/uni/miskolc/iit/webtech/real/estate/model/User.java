package hu.iit.uni.miskolc.iit.webtech.real.estate.model;

public class User {

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

}
