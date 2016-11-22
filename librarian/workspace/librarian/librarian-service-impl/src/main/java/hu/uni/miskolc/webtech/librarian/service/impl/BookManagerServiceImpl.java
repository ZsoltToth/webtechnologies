package hu.uni.miskolc.webtech.librarian.service.impl;

import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import java.util.GregorianCalendar;

import hu.uni.miskolc.webtech.librarian.model.Author;
import hu.uni.miskolc.webtech.librarian.model.Book;
import hu.uni.miskolc.webtech.librarian.model.Nationality;
import hu.uni.miskolc.webtech.librarian.model.exceptions.IllegalBirthDateException;
import hu.uni.miskolc.webtech.librarian.model.exceptions.IllegalPersonNameException;
import hu.uni.miskolc.webtech.librarian.persist.AuthorDAO;
import hu.uni.miskolc.webtech.librarian.persist.AuthorNotFoundException;
import hu.uni.miskolc.webtech.librarian.persist.BookAlreadyExistsException;
import hu.uni.miskolc.webtech.librarian.persist.BookDAO;
import hu.uni.miskolc.webtech.librarian.persist.BookNotFoundException;
import hu.uni.miskolc.webtech.librarian.persist.ExistingAuthorException;
import hu.uni.miskolc.webtech.librarian.service.AuthorManipulationException;
import hu.uni.miskolc.webtech.librarian.service.BookManagerService;

public class BookManagerServiceImpl implements BookManagerService {

	private AuthorDAO authorDAO;
	private BookDAO bookDAO;

	public BookManagerServiceImpl(AuthorDAO authorDAO, BookDAO bookDAO) {
		super();
		this.authorDAO = authorDAO;
		this.bookDAO = bookDAO;
	}

	public void addAuthor(Author author) throws AuthorManipulationException {
		try {
			this.authorDAO.createAuthor(author);
		} catch (ExistingAuthorException e) {
			throw new AuthorManipulationException("Author cannot be created!", e);
		}
	}

	public void updateAuthor(Author author) throws AuthorManipulationException {
		try {
			this.authorDAO.updateAuthor(author);
		} catch (AuthorNotFoundException e) {
			throw new AuthorManipulationException("Author cannot be created!", e);
		}
	}

	public Collection<Author> queryAuthors() {
		return authorDAO.readAuthors();
	}

	public void addBook(Book book) {
		try {
			bookDAO.createBook(book);
		} catch (BookAlreadyExistsException e) {
			e.printStackTrace();
		}
	}

	public void updateBook(Book book) {
		try {
			bookDAO.updateBook(book);
		} catch (BookNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public Collection<Book> queryBooks() {
		return bookDAO.readBooks();
	}

	public Collection<Book> queryBooks(Author author) {
		return bookDAO.readBooks(author);
	}

}
