package hu.uni.miskolc.webtech.librarian.model;

import java.util.Date;
import java.util.GregorianCalendar;

import hu.uni.miskolc.webtech.librarian.model.exceptions.IllegalBirthDateException;
import hu.uni.miskolc.webtech.librarian.model.exceptions.IllegalPersonNameException;

/**
 * 
 * @author zsolt
 *
 */
public class Author {

	private final int authorID;
	private String name;
	private Nationality nationality;
	private Date birthDate;

	public Author(Integer authorID, String name, Nationality nationality, Date birthDate)
			throws IllegalPersonNameException, IllegalBirthDateException {
		super();
		this.authorID = authorID;
		this.setName(name);
		this.nationality = nationality;
		this.setBirthDate(birthDate);
	}
	
	public Author(Integer authorID, String name, String nationality, Date birthDate)
			throws IllegalPersonNameException, IllegalBirthDateException {
		this(authorID, name, Nationality.valueOf(nationality), birthDate);
	}
	
	public Author(Integer authorID, String name, String nationality, java.sql.Date birthDate)
			throws IllegalPersonNameException, IllegalBirthDateException {
		this(authorID, name, Nationality.valueOf(nationality), birthDate);
	}

	public String getName() {

		return name;
	}

	private void setName(String name) throws IllegalPersonNameException {
		if ("".equals(name)) {
			throw new IllegalPersonNameException(String.format("The %s name is not valid", name));
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

	public void setBirthDate(Date birthDate) throws IllegalBirthDateException {
		if(birthDate == null || !birthDate.before(new GregorianCalendar().getTime())){
			throw new IllegalBirthDateException(String.format("Date <%s> is not in the past!", birthDate));
		}
		this.birthDate = birthDate;
	}

	public int getAuthorID() {
		return authorID;
	}

	@Override
	public String toString() {
		return "Author [authorID=" + authorID + ", name=" + name + ", nationality=" + nationality + ", birthDate="
				+ birthDate + "]";
	}

}
