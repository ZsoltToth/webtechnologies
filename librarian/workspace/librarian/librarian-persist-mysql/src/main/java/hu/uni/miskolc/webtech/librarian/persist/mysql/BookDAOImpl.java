package hu.uni.miskolc.webtech.librarian.persist.mysql;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Properties;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import hu.uni.miskolc.webtech.librarian.model.Author;
import hu.uni.miskolc.webtech.librarian.model.Book;
import hu.uni.miskolc.webtech.librarian.model.Genre;
import hu.uni.miskolc.webtech.librarian.model.Nationality;
import hu.uni.miskolc.webtech.librarian.model.exceptions.IllegalBirthDateException;
import hu.uni.miskolc.webtech.librarian.model.exceptions.IllegalPersonNameException;
import hu.uni.miskolc.webtech.librarian.persist.BookAlreadyExistsException;
import hu.uni.miskolc.webtech.librarian.persist.BookDAO;
import hu.uni.miskolc.webtech.librarian.persist.BookNotFoundException;
import hu.uni.miskolc.webtech.librarian.persist.mysql.mapper.BookMapper;

public class BookDAOImpl implements BookDAO {

	private Logger LOG = LogManager.getLogger();

	private static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";

	private SqlSessionFactory sqlSessionFactory;

	public BookDAOImpl(String mybatisConfigPath, String host, int port, String database, String user, String password)
			throws FileNotFoundException {
		File configFile = new File(mybatisConfigPath);
		InputStream inputStream = new FileInputStream(configFile);
		String url = String.format("jdbc:mysql://%s:%s/%s", host, port, database);
		Properties props = new Properties();
		props.put("driver", JDBC_DRIVER);
		props.put("url", url);
		props.put("username", user);
		props.put("password", password);
		this.sqlSessionFactory = (new SqlSessionFactoryBuilder()).build(inputStream, props);
	}

	public void createBook(Book book) throws BookAlreadyExistsException {
		// TODO Auto-generated method stub

	}

	public Collection<Book> readBooks() {
		// TODO Auto-generated method stub
		SqlSession session = sqlSessionFactory.openSession();
		BookMapper mapper = session.getMapper(BookMapper.class);

		Collection<Genre> genres = mapper
				.queryGenresOfBook(new Book(1, "Romeo and Juliette", new ArrayList<Genre>(), new ArrayList<Author>()));
		System.out.println(genres);

		session.close();

		return null;
	}

	public Collection<Book> readBooks(String title) {
		// TODO Auto-generated method stub
		return null;
	}

	public Collection<Book> readBooks(Author author) {
		// TODO Auto-generated method stub
		return null;
	}

	public Collection<Book> readBooks(Genre genre) {
		// TODO Auto-generated method stub
		return null;
	}

	public void updateBook(Book book) throws BookNotFoundException {
		// TODO Auto-generated method stub

	}

	public void deleteBook(Book book) throws BookNotFoundException {
		// TODO Auto-generated method stub

	}

	public void deleteBook(int bookId) throws BookNotFoundException {
		// TODO Auto-generated method stub

	}

}
