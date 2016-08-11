package hu.uni.miskolc.webtech.librarian.persist.mysql;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import hu.uni.miskolc.webtech.librarian.persist.BookDAO;

public class BookDAOImplTest extends SetupDBTests{
	
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
	public void test() {
		System.out.println("--------------start-----------------");
		this.dao.readBooks();
		System.out.println("--------------stop------------------");
	}

}
