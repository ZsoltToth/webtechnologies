package hu.uni.miskolc.webtech.librarian.service;

import java.util.Collection;

import hu.uni.miskolc.webtech.librarian.model.Author;
import hu.uni.miskolc.webtech.librarian.model.Book;

public interface BookManagerService {
	
	public void addAuthor(Author author) throws AuthorManipulationException;
	public void updateAuthor(Author author) throws AuthorManipulationException;
	
	public Collection<Author> queryAuthors();
	
	public void addBook(Book book);
	public void updateBook(Book book);
	
	public Collection<Book> queryBooks();
	public Collection<Book> queryBooks(Author author);
	

}
