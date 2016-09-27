package hu.uni.miskolc.webtech.librarian.model;

import static org.junit.Assert.*;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import org.junit.Ignore;
import org.junit.Test;

import hu.uni.miskolc.webtech.librarian.model.exceptions.IllegalBirthDateException;
import hu.uni.miskolc.webtech.librarian.model.exceptions.IllegalPersonNameException;

public class AuthorTest {

	@Test
	public void testAuthorConstructorWithValidValues()
			throws ParseException, IllegalPersonNameException, IllegalBirthDateException {
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date birthDate = dateFormat.parse("1000-01-01");
		new Author(0, "John Doe", Nationality.American, birthDate);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testAuthorConstructorWithNegativeId()
			throws ParseException, IllegalPersonNameException, IllegalBirthDateException {
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date birthDate = dateFormat.parse("1000-01-01");
		new Author(-1, "John Doe", Nationality.American, birthDate);
	}
	
	@Test(expected = IllegalPersonNameException.class)
	public void testAuthorConstructorWithNullName()
			throws ParseException, IllegalPersonNameException, IllegalBirthDateException {
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date birthDate = dateFormat.parse("1000-01-01");
		new Author(0, null, Nationality.American, birthDate);
	}
	
	@Test(expected = IllegalPersonNameException.class)
	public void testAuthorConstructorWithEmpltyName()
			throws ParseException, IllegalPersonNameException, IllegalBirthDateException {
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date birthDate = dateFormat.parse("1000-01-01");
		new Author(0, "", Nationality.American, birthDate);
	}
	
	@Test(expected = IllegalBirthDateException.class)
	public void testAuthorConstructorWithFutureBirthDate()
			throws ParseException, IllegalPersonNameException, IllegalBirthDateException {
		Date birthDate = new Date((long) (System.currentTimeMillis() + 1e10));
		new Author(0, "John Doe", Nationality.American, birthDate);
	}

	

	
	@Test
	public void testAuthorIntegerStringStringDate() throws ParseException, IllegalPersonNameException, IllegalBirthDateException {
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date birthDate = dateFormat.parse("1000-01-01");
		new Author(0, "John Doe", "American", birthDate);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testAuthorIntegerStringStringDateUnkonwNationality() throws ParseException, IllegalPersonNameException, IllegalBirthDateException {
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date birthDate = dateFormat.parse("1000-01-01");
		new Author(0, "John Doe", "NoNationality", birthDate);
	}

	@Ignore
	@Test
	public void testAuthorIntegerStringStringDate1() {
		fail("Not yet implemented");
	}

	@Ignore
	@Test
	public void testGetName() {
		fail("Not yet implemented");
	}

	@Ignore
	@Test
	public void testGetNationality() {
		fail("Not yet implemented");
	}

	@Ignore
	@Test
	public void testSetNationality() {
		fail("Not yet implemented");
	}

	@Ignore
	@Test
	public void testGetBirthDate() {
		fail("Not yet implemented");
	}

	@Ignore
	@Test
	public void testSetBirthDate() {
		fail("Not yet implemented");
	}

	@Ignore
	@Test
	public void testGetAuthorID() {
		fail("Not yet implemented");
	}

	@Ignore
	@Test
	public void testEqualsObject() {
		fail("Not yet implemented");
	}

	@Ignore
	@Test
	public void testObject() {
		fail("Not yet implemented");
	}

	@Ignore
	@Test
	public void testGetClass() {
		fail("Not yet implemented");
	}

	@Ignore
	@Test
	public void testEqualsObject1() {
		fail("Not yet implemented");
	}

	@Ignore
	@Test
	public void testClone() {
		fail("Not yet implemented");
	}

	@Ignore
	@Test
	public void testToString() {
		fail("Not yet implemented");
	}

	@Ignore
	@Test
	public void testNotify() {
		fail("Not yet implemented");
	}

	@Ignore
	@Test
	public void testNotifyAll() {
		fail("Not yet implemented");
	}

	@Ignore
	@Test
	public void testWaitLong() {
		fail("Not yet implemented");
	}

	@Ignore
	@Test
	public void testWaitLongInt() {
		fail("Not yet implemented");
	}

	@Ignore
	@Test
	public void testWait() {
		fail("Not yet implemented");
	}
}
