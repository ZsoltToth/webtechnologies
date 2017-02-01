package hu.uni.miskolc.webtech.librarian.persist.mysql;

import static org.junit.Assert.*;

import java.io.FileNotFoundException;

import org.junit.Assume;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import hu.uni.miskolc.webtech.librarian.model.Book;
import hu.uni.miskolc.webtech.librarian.persist.BookInstanceDAO;
import hu.uni.miskolc.webtech.librarian.persist.BookNotFoundException;

@Ignore
public class BookInstanceDAOImplIT extends SetupDBTests {

	private BookInstanceDAO dao;
	
	@Before
	public void setUp(){
		super.setUp();
		try {
			this.dao = new BookInstanceDAOImpl(MYBATIS_CONFIG_FILE, HOST, PORT, DATABASE, USER, PASSWORD);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			Assume.assumeNoException(e);
		}
	}
	
	@Test
	public void testBookInstanceDAOImpl() throws BookNotFoundException {
		System.out.println(dao.readInstances(new Book(1,"asdf",null)));
	}

	@Ignore
	@Test
	public void testCreateBookInstance() {
		fail("Not yet implemented");
	}

	@Ignore
	@Test
	public void testReadInstances() {
		fail("Not yet implemented");
	}

	@Ignore
	@Test
	public void testUpdateBookInstance() {
		fail("Not yet implemented");
	}
	
	@Ignore
	@Test
	public void testDeleteBookInstance() {
		fail("Not yet implemented");
	}

}
