package hu.uni.miskolc.webtech.librarian.persist;

import java.util.Collection;

import hu.uni.miskolc.webtech.librarian.model.Author;
import hu.uni.miskolc.webtech.librarian.model.Nationality;

public interface AuthorDAO {

	public void createAuthor(Author author) throws ExistingAuthorException;
	
	public Collection<Author> readAuthors();
	public Collection<Author> readAuthorByName(String name);
	public Collection<Author> readAuthorByNationality(Nationality nationality);
	
	public Author readAuthor(int id) throws AuthorNotFoundException;
	
	public void updateAuthor(Author author) throws AuthorNotFoundException;
	
	public void deleteAuthor(Author author) throws AuthorNotFoundException;
	
}
