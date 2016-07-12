package hu.uni.miskolc.webtech.librarian.service.impl;

import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import java.util.GregorianCalendar;

import hu.uni.miskolc.webtech.librarian.model.Author;
import hu.uni.miskolc.webtech.librarian.model.Book;
import hu.uni.miskolc.webtech.librarian.model.Nationality;
import hu.uni.miskolc.webtech.librarian.model.exceptions.IllegalPersonNameException;
import hu.uni.miskolc.webtech.librarian.service.BookManagerService;

public class BookManagerServiceImpl implements BookManagerService {

	public BookManagerServiceImpl() {
		// TODO Auto-generated constructor stub
	}

	public void addAuthor(Author author) {
		// TODO Auto-generated method stub

	}

	public void updateAuthor(Author author) {
		// TODO Auto-generated method stub

	}

	public Collection<Author> queryAuthors() {

		try{
		return Arrays.asList(
				new Author(1, "Madach Imre", Nationality.Hungarian	, new GregorianCalendar(1848, 12, 12).getTime()),
				new Author(1, "Madach Imre", Nationality.Hungarian	, new GregorianCalendar(1848, 12, 12).getTime())
				);
		}
		catch(IllegalPersonNameException ex){
			
		}
		return null;
	}

	public void addBook(Book book) {
		// TODO Auto-generated method stub

	}

	public void updateBook(Book book) {
		// TODO Auto-generated method stub

	}

	public Collection<Book> queryBooks() {
		// TODO Auto-generated method stub
		return null;
	}

	public Collection<Book> queryBooks(Author author) {
		// TODO Auto-generated method stub
		return null;
	}

}
