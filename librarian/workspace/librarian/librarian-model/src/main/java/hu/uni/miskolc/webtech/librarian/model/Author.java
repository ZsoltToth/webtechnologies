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
		if (authorID < 0) {
			throw new IllegalArgumentException(String.format("Author Id cannot be negative (%d)", authorID));
		}
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
		if (name == null || "".equals(name)) {
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
		if (birthDate == null || !birthDate.before(new GregorianCalendar().getTime())) {
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + authorID;
		result = prime * result + ((birthDate == null) ? 0 : birthDate.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((nationality == null) ? 0 : nationality.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Author other = (Author) obj;
		// if (authorID != other.authorID)
		// return false;
		if (birthDate == null) {
			if (other.birthDate != null)
				return false;
		} else if (!birthDate.equals(other.birthDate))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (nationality != other.nationality)
			return false;
		return true;
	}

}
