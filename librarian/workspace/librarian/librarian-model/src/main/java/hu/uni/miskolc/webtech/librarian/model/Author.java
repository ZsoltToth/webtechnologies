package hu.uni.miskolc.webtech.librarian.model;

import java.util.Date;

import hu.uni.miskolc.webtech.librarian.model.exceptions.IllegalBirthDateException;
import hu.uni.miskolc.webtech.librarian.model.exceptions.IllegalPersonNameException;

/**
 * 
 * @author zsolt
 *
 */
public class Author {

	private int authorID;
	private String name;
	private Nationality nationality;
	private Date birthDate;

	public Author() {
		super();
	}

	public Author(int authorID, String name, Nationality nationality, Date birthDate) throws IllegalPersonNameException {
		super();
		this.authorID = authorID;
		this.setName(name);
		this.nationality = nationality;
		this.birthDate = birthDate;
	}

	public int getAuthorID() {
		return authorID;
	}

	public void setAuthorID(int authorID) {
		this.authorID = authorID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) throws IllegalPersonNameException {
		if(name.isEmpty()){
			throw new IllegalPersonNameException("Authors name is empty!");
		}
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

	public void setBirthDate(Date birthDate) throws IllegalBirthDateException{
		if(birthDate.after(new Date())){
			throw new IllegalBirthDateException("Birth date is in the future!");
		}
		this.birthDate = birthDate;
	}

}
