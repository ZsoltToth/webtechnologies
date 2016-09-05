package hu.uni.miskolc.webtech.librarian.persist.mysql;

import static org.junit.Assert.*;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import hu.uni.miskolc.webtech.librarian.model.Author;
import hu.uni.miskolc.webtech.librarian.model.Book;
import hu.uni.miskolc.webtech.librarian.model.Genre;
import hu.uni.miskolc.webtech.librarian.model.Nationality;
import hu.uni.miskolc.webtech.librarian.model.exceptions.IllegalBirthDateException;
import hu.uni.miskolc.webtech.librarian.model.exceptions.IllegalPersonNameException;
import hu.uni.miskolc.webtech.librarian.persist.BookDAO;
import hu.uni.miskolc.webtech.librarian.persist.BookNotFoundException;

public class BookDAOImplTest extends SetupDBTests {

	private BookDAO dao;

	@Before
	public void setUp() {
		super.setUp();
		try {
			this.dao = new BookDAOImpl(SetupDBTests.MYBATIS_CONFIG_FILE, HOST, PORT, DATABASE, USER, PASSWORD);
		} catch (Exception ex) {
			fail(ex.getMessage());
		}
	}

	@Test
	public void testReadBooks() throws IllegalPersonNameException, IllegalBirthDateException, ParseException {
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Author wShakespeare = new Author(2, "William Shakespeare", Nationality.British, dateFormat.parse("1564-04-23"));
		Book romeoAndJuliet = new Book(1, "Romeo and Juliet", Arrays.asList(Genre.Romance),
				Arrays.asList(wShakespeare));

		Collection<Book> expected = Arrays.asList(romeoAndJuliet);
		Collection<Book> actual = this.dao.readBooks();

		assertEquals(expected, actual);
	}

	@Test
	public void testReadBooksByTitle() throws IllegalPersonNameException, IllegalBirthDateException, ParseException {
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Author wShakespeare = new Author(2, "William Shakespeare", Nationality.British, dateFormat.parse("1564-04-23"));
		Book romeoAndJuliet = new Book(1, "Romeo and Juliet", Arrays.asList(Genre.Romance),
				Arrays.asList(wShakespeare));

		Collection<Book> expected = Arrays.asList(romeoAndJuliet);
		Collection<Book> actual = this.dao.readBooks("romeo");

		assertEquals(expected, actual);
	}

	@Test
	public void testReadBooksByTitleNoMatching()
			throws IllegalPersonNameException, IllegalBirthDateException, ParseException {

		Collection<Book> expected = new ArrayList<Book>();
		Collection<Book> actual = this.dao.readBooks("Not matching title");

		assertEquals(expected, actual);
	}

	@Test
	public void testReadBooksByAuthor() throws IllegalPersonNameException, IllegalBirthDateException, ParseException {
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Author wShakespeare = new Author(2, "William Shakespeare", Nationality.British, dateFormat.parse("1564-04-23"));
		Book romeoAndJuliet = new Book(1, "Romeo and Juliet", Arrays.asList(Genre.Romance),
				Arrays.asList(wShakespeare));

		Collection<Book> expected = Arrays.asList(romeoAndJuliet);
		Collection<Book> actual = this.dao.readBooks(wShakespeare);

		assertEquals(expected, actual);
	}

	@Test
	public void testReadBooksByAuthorNoBookFoundForAuthor()
			throws IllegalPersonNameException, IllegalBirthDateException, ParseException {
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Author jDoe = new Author(123, "John Doe", Nationality.British, dateFormat.parse("1564-04-23"));
		// Book romeoAndJuliet= new Book(1, "Romeo and Juliet",
		// Arrays.asList(Genre.Romance), Arrays.asList(wShakespeare));

		Collection<Book> expected = new ArrayList<Book>();
		Collection<Book> actual = this.dao.readBooks(jDoe);

		assertEquals(expected, actual);
	}

	@Test
	public void testReadBooksByGenre() throws IllegalPersonNameException, IllegalBirthDateException, ParseException {
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Author wShakespeare = new Author(2, "William Shakespeare", Nationality.British, dateFormat.parse("1564-04-23"));
		Book romeoAndJuliet = new Book(1, "Romeo and Juliet", Arrays.asList(Genre.Romance),
				Arrays.asList(wShakespeare));

		Collection<Book> expected = Arrays.asList(romeoAndJuliet);
		Collection<Book> actual = this.dao.readBooks(Genre.Romance);

		assertEquals(expected, actual);
	}

	@Test
	public void testReadBooksByGenreNoBookInTheGenreFound()
			throws IllegalPersonNameException, IllegalBirthDateException, ParseException {
		Collection<Book> expected = new ArrayList<Book>();
		Collection<Book> actual = this.dao.readBooks(Genre.SciFi);

		assertEquals(expected, actual);
	}

	@Test(expected = BookNotFoundException.class)
	public void testDeleteBookNoBookFoundDueToNull() throws BookNotFoundException {
		dao.deleteBook(null);
	}

	@Test(expected = BookNotFoundException.class)
	public void testDeleteBookNoBookFoundInvalidBookNo() throws BookNotFoundException {
		dao.deleteBook(-1);
	}

	@Test
	public void testDeleteBookByBookObject()
			throws BookNotFoundException, IllegalPersonNameException, IllegalBirthDateException, ParseException {
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Author wShakespeare = new Author(2, "William Shakespeare", Nationality.British, dateFormat.parse("1564-04-23"));
		Book romeoAndJuliet = new Book(1, "Romeo and Juliet", Arrays.asList(Genre.Romance),
				Arrays.asList(wShakespeare));
		dao.deleteBook(romeoAndJuliet);

		Collection<Book> expected = new ArrayList<Book>();
		Collection<Book> actual = this.dao.readBooks();
		assertEquals(expected, actual);
	}
	
	@Test
	public void testDeleteBookByBookId()
			throws BookNotFoundException{
		final int ROMEO_AND_JULIET_BOOK_ID = 1;
		dao.deleteBook(ROMEO_AND_JULIET_BOOK_ID);

		Collection<Book> expected = new ArrayList<Book>();
		Collection<Book> actual = this.dao.readBooks();
		assertEquals(expected, actual);
	}
	
	@Ignore("Tested manually in debug mode")
	@Test
	public void testUpdateBook() throws IllegalPersonNameException, IllegalBirthDateException, ParseException, BookNotFoundException{
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Author wShakespeare = new Author(2, "William Shakespeare", Nationality.British, dateFormat.parse("1564-04-23"));
//		Author jDoe = new Author(123, "John Doe", Nationality.British, dateFormat.parse("1564-04-23"));
		Book romeoAndJuliet = new Book(1, "Romeo and Juliet", Arrays.asList(Genre.Romance, Genre.Novel),
				Arrays.asList(wShakespeare));
		dao.updateBook(romeoAndJuliet);
	}
}
