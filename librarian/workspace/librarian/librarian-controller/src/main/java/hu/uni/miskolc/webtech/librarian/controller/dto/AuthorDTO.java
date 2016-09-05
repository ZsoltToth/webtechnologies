package hu.uni.miskolc.webtech.librarian.controller.dto;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import hu.uni.miskolc.webtech.librarian.model.Nationality;

public class AuthorDTO {

	private int authorID;
	private String name;
	private Nationality nationality;
	@JsonFormat(pattern="yyyy-MM-dd")
	private Date birthDate;

	public AuthorDTO() {

	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Nationality getNationality() {
		return nationality;
	}

	public void setNationality(Nationality nationality) {
		this.nationality = nationality;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	public int getAuthorID() {
		return authorID;
	}

	public void setAuthorID(int authorID) {
		this.authorID = authorID;
	}

	@Override
	public String toString() {
		return "AuthorDTO [authorID=" + authorID + ", name=" + name + ", nationality=" + nationality + ", birthDate="
				+ birthDate 
				+"]";
	}

	
}
