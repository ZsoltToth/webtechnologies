package hu.uni.miskolc.webtech.librarian.persist;

import java.util.Collection;

import hu.uni.miskolc.webtech.librarian.model.Book;
import hu.uni.miskolc.webtech.librarian.model.BookInstance;

public interface BookInstanceDAO {

	public void createBookInstance(BookInstance bookInstance) throws BookInstanceAlreadyExistsException;

	public Collection<BookInstance> readInstances(Book book) throws BookNotFoundException;

	public void updateBookInstance(BookInstance bookInstance) throws BookInstanceNotFoundException;

	public void deleteBookInstance(BookInstance bookInstance) throws BookInstanceNotFoundException;
}
