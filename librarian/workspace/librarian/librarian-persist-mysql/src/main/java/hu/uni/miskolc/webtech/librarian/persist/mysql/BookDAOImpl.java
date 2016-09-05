package hu.uni.miskolc.webtech.librarian.persist.mysql;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Properties;
import java.util.Set;

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
		String url = String.format("jdbc:mysql://%s:%s/%s?allowMultiQueries=true", host, port, database);
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
		Collection<Book> result = new ArrayList<Book>();
		SqlSession session = sqlSessionFactory.openSession();
		try {
			BookMapper mapper = session.getMapper(BookMapper.class);
			result = mapper.selectBooks();
		} finally {
			session.close();
		}

		return result;
	}

	public Collection<Book> readBooks(String title) {
		Collection<Book> result = new ArrayList<Book>();
		SqlSession session = sqlSessionFactory.openSession();
		try {
			BookMapper mapper = session.getMapper(BookMapper.class);
			result = mapper.selectBooksByTitle("%"+title+"%");
		} finally {
			session.close();
		}

		return result;
	}

	public Collection<Book> readBooks(Author author) {
		Collection<Book> result = new ArrayList<Book>();
		SqlSession session = sqlSessionFactory.openSession();
		try {
			BookMapper mapper = session.getMapper(BookMapper.class);
			result = mapper.selectBooksByAuthor(author);
		} finally {
			session.close();
		}

		return result;
	}

	public Collection<Book> readBooks(Genre genre) {
		Collection<Book> result = new ArrayList<Book>();
		SqlSession session = sqlSessionFactory.openSession();
		try {
			BookMapper mapper = session.getMapper(BookMapper.class);
			result = mapper.selectBooksByGenre(genre);
		} finally {
			session.close();
		}

		return result;
	}

	public void updateBook(Book book) throws BookNotFoundException {
		SqlSession session = sqlSessionFactory.openSession();
		try {
			BookMapper mapper = session.getMapper(BookMapper.class);
			Book oldBook = mapper.selectBookById(book.getBookId()); 
			if( oldBook == null){
				throw new BookNotFoundException(String.format("The book %s cannot be found in the database", book));
			}
			Set<Author> removedAuthors = new HashSet<Author>(oldBook.getAuthors());
			removedAuthors.removeAll(book.getAuthors());
			for(Author author : removedAuthors){
				mapper.removeAuthorFromBook(book.getBookId(), author.getAuthorID());
			}
			//Check whether the Author exists or not. Existence of the author is assumed.
			Set<Author> addedAuthors = new HashSet<Author>(book.getAuthors());
			addedAuthors.removeAll(new HashSet<Author>(oldBook.getAuthors()));
			for(Author author : addedAuthors){
				mapper.insertAuthorForBook(book.getBookId(), author.getAuthorID());
			}
			Set<Genre> removedGenres = new HashSet<Genre>(oldBook.getGenres());
			removedAuthors.removeAll(book.getGenres());
			for(Genre genre : removedGenres){
				mapper.removeGenreFromBook(genre, book.getBookId());
			}
			Set<Genre> addedGenres = new HashSet<Genre>(book.getGenres());
			addedAuthors.removeAll(oldBook.getGenres());
			for(Genre genre : addedGenres){
				mapper.insertGenreForBook(genre, book.getBookId());
			}
			mapper.updateBook(book);
			
		} finally {
			session.close();
		}
	}

	public void deleteBook(Book book) throws BookNotFoundException {
		if(book == null){
			throw new BookNotFoundException("The book was null");
		}
		deleteBook(book.getBookId());
	}

	public void deleteBook(int bookId) throws BookNotFoundException {
		SqlSession session = sqlSessionFactory.openSession();
		try {
			BookMapper mapper = session.getMapper(BookMapper.class);
			if(mapper.selectBookById(bookId) == null){
				throw new BookNotFoundException(String.format("The book %s cannot be found in the database", bookId));
			}
			mapper.deleteBookById(bookId);
			session.commit();
		} finally {
			session.close();
		}

	}

}
