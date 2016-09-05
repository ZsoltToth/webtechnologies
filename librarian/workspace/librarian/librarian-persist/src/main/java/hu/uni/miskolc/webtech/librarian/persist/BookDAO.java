package hu.uni.miskolc.webtech.librarian.persist;

import java.util.Collection;

import hu.uni.miskolc.webtech.librarian.model.Author;
import hu.uni.miskolc.webtech.librarian.model.Book;
import hu.uni.miskolc.webtech.librarian.model.Genre;

public interface BookDAO {
	
	public void createBook(Book book) throws BookAlreadyExistsException;
	
	public Collection<Book> readBooks();
	public Collection<Book> readBooks(String title);
	public Collection<Book> readBooks(Author author);
	public Collection<Book> readBooks(Genre genre);
	
	public void updateBook(Book book) throws BookNotFoundException;
	
	public void deleteBook(Book book) throws BookNotFoundException;
	public void deleteBook(int bookId) throws BookNotFoundException;

}
