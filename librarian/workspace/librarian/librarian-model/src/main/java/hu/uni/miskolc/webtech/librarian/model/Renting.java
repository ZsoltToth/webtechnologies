package hu.uni.miskolc.webtech.librarian.model;

import java.util.Date;

public class Renting {

	private User reader;
	private BookInstance bookInstance;
	private Date rentDate;
	private Date expireDate;
	private Date returnDate;

	public Renting() {
		super();
	}

	public Renting(User reader, BookInstance bookInstance, Date rentDate, Date expireDate, Date returnDate) {
		super();
		this.reader = reader;
		this.bookInstance = bookInstance;
		this.rentDate = rentDate;
		this.expireDate = expireDate;
		this.returnDate = returnDate;
	}

	public User getReader() {
		return reader;
	}

	public void setReader(User reader) {
		this.reader = reader;
	}

	public BookInstance getBookInstance() {
		return bookInstance;
	}

	public void setBookInstance(BookInstance bookInstance) {
		this.bookInstance = bookInstance;
	}

	public Date getRentDate() {
		return rentDate;
	}

	public void setRentDate(Date rentDate) {
		this.rentDate = rentDate;
	}

	public Date getExpireDate() {
		return expireDate;
	}

	public void setExpireDate(Date expireDate) {
		this.expireDate = expireDate;
	}

	public Date getReturnDate() {
		return returnDate;
	}

	public void setReturnDate(Date returnDate) {
		this.returnDate = returnDate;
	}

}
