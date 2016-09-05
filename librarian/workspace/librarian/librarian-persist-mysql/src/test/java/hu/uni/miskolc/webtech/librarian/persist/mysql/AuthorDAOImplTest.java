package hu.uni.miskolc.webtech.librarian.persist.mysql;

import static org.junit.Assert.*;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.GregorianCalendar;
import java.util.List;

import org.hamcrest.Matchers;
import org.hamcrest.core.Is;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

import hu.uni.miskolc.webtech.librarian.model.Author;
import hu.uni.miskolc.webtech.librarian.model.Nationality;
import hu.uni.miskolc.webtech.librarian.model.exceptions.IllegalBirthDateException;
import hu.uni.miskolc.webtech.librarian.model.exceptions.IllegalPersonNameException;
import hu.uni.miskolc.webtech.librarian.persist.AuthorDAO;
import hu.uni.miskolc.webtech.librarian.persist.AuthorNotFoundException;
import hu.uni.miskolc.webtech.librarian.persist.ExistingAuthorException;

public class AuthorDAOImplTest extends SetupDBTests {

	private AuthorDAO dao;

	@Before
	public void setUp() {
		super.setUp();
		try {
			this.dao = new AuthorDAOImpl(SetupDBTests.MYBATIS_CONFIG_FILE, HOST, PORT, DATABASE, USER, PASSWORD);
		} catch (Exception ex) {
			fail(ex.getMessage());
		}
	}

	@Test
	public void testSelectAuthors() throws IllegalPersonNameException, IllegalBirthDateException, ParseException {
		Collection<Author> authors = dao.readAuthors();
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

		Author[] expectedAuthors = new Author[] {
				new Author(1, "Jozsef Attila", Nationality.Hungarian, dateFormat.parse("1905-04-11")),
				new Author(2, "William Shakespeare", Nationality.British, dateFormat.parse("1564-04-23")),
				new Author(3, "Ady Endre", Nationality.Hungarian, dateFormat.parse("1877-11-22")) };
		assertThat(authors, Matchers.containsInAnyOrder(expectedAuthors));
		// assertThat(authors, Matchers.contains(expectedAuthors));
	}

	@Test
	public void testSelectAuthorsByName() throws IllegalPersonNameException, IllegalBirthDateException, ParseException {
		Collection<Author> authors = dao.readAuthorByName("re");
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

		Author[] expectedAuthors = new Author[] {
				new Author(2, "William Shakespeare", Nationality.British, dateFormat.parse("1564-04-23")),
				new Author(3, "Ady Endre", Nationality.Hungarian, dateFormat.parse("1877-11-22")) };
		assertThat(authors, Matchers.containsInAnyOrder(expectedAuthors));
		// assertThat(authors, Matchers.contains(expectedAuthors));
	}

	@Test
	public void testSelectAuthorsByNationality()
			throws IllegalPersonNameException, IllegalBirthDateException, ParseException {
		Collection<Author> authors = dao.readAuthorByNationality(Nationality.Hungarian);
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

		Author[] expectedAuthors = new Author[] {
				new Author(1, "Jozsef Attila", Nationality.Hungarian, dateFormat.parse("1905-04-11")),
				new Author(3, "Ady Endre", Nationality.Hungarian, dateFormat.parse("1877-11-22")) };
		assertThat(authors, Matchers.containsInAnyOrder(expectedAuthors));

		// assertThat(authors, Matchers.contains(expectedAuthors));
	}

	@Test
	public void testSelectAuthor() throws IllegalPersonNameException, IllegalBirthDateException, ParseException, AuthorNotFoundException {
		Author author = dao.readAuthor(1);
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Author expected = new Author(1, "Jozsef Attila", Nationality.Hungarian, dateFormat.parse("1905-04-11"));
		assertEquals(expected, author);
	}
	
	@Test(expected=AuthorNotFoundException.class)
	public void testSelectAuthorNotFound() throws IllegalPersonNameException, IllegalBirthDateException, ParseException, AuthorNotFoundException {
		Author author = dao.readAuthor(-1);
	}
	
	@Test
	public void testCreateAuthor() throws IllegalPersonNameException, IllegalBirthDateException, ParseException, ExistingAuthorException{
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Author expected = new Author(0, "Tamas Frei", Nationality.Hungarian, dateFormat.parse("1966-05-21"));
		dao.createAuthor(expected);
		List<Author> actuals = new ArrayList<Author>(dao.readAuthorByName(expected.getName()));
		if(actuals.size() != 1){
			fail();
		}
		assertEquals(String.format("%s != %s", expected, actuals.get(0)),expected, actuals.get(0));
	}
	
	@Test
	public void testUpdateAuthor() throws IllegalPersonNameException, IllegalBirthDateException, ParseException, AuthorNotFoundException{
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Author expected = new Author(1, "Jozsef Pista", Nationality.Hungarian, dateFormat.parse("1905-04-11"));
		dao.updateAuthor(expected);
		Author actual = dao.readAuthor(expected.getAuthorID());
		
		assertEquals(String.format("%s not equals %s", expected, actual),expected, actual);
	}

//	@Test
//	public void testSelectAuthorsById() {
//		Collection<Author> authors = dao.readAuthors();
//		for (Author author : authors) {
//			System.out.println(author);
//		}
//
//		// assertThat(dao.readAuthors(), is(arrayContainingInAnyOrder()));
//
//	}

}
