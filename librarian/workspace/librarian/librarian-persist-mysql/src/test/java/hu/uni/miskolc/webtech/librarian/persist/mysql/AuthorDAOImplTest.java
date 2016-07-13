package hu.uni.miskolc.webtech.librarian.persist.mysql;

import static org.junit.Assert.*;

import java.util.Collection;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import hu.uni.miskolc.webtech.librarian.model.Author;
import hu.uni.miskolc.webtech.librarian.persist.AuthorDAO;

public class AuthorDAOImplTest extends SetupDBTests{

	private AuthorDAO dao;	

	@Before
	public void setUp()  {
		super.setUp();
		
		String url = String.format("jdbc:mysql://%s:%s/%s", HOST, PORT, DATABASE);
		try{
			this.dao = new AuthorDAOImpl(SetupDBTests.MYBATIS_CONFIG_FILE, "com.mysql.jdbc.Driver",
					url, USER, PASSWORD);
		}
		catch(Exception ex){
			fail(ex.getMessage());
		}
	}

	@Test
	public void testSelectAuthors() {
		Collection<Author> authors = dao.readAuthors();
		for (Author author : authors) {
			System.out.println(author);
		}

		// assertThat(dao.readAuthors(), is(arrayContainingInAnyOrder()));

	}

	@Test
	public void testSelectAuthorsById() {
		Collection<Author> authors = dao.readAuthors();
		for (Author author : authors) {
			System.out.println(author);
		}

		// assertThat(dao.readAuthors(), is(arrayContainingInAnyOrder()));

	}
}
