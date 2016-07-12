package hu.uni.miskolc.webtech.librarian.persist;

import java.util.Collection;

import hu.uni.miskolc.webtech.librarian.model.Author;

public interface AuthorDAO {

	public void createAuthor(Author author) throws ExistingAuthorException;
	
	public Collection<Author> readAuthors();
	public Collection<Author> readAuthorByName();
	public Collection<Author> readAuthorByNationality();
	
	public Author readAuthor(int id) throws AuthorNotFoundException;
	
	public void updateAuthor(Author author) throws AuthorNotFoundException;
	
	public void deleteAuthor(Author author) throws AuthorNotFoundException;
	
}
