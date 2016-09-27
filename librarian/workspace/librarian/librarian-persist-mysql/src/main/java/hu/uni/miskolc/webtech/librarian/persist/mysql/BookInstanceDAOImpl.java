package hu.uni.miskolc.webtech.librarian.persist.mysql;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Collection;
import java.util.Properties;

import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import hu.uni.miskolc.webtech.librarian.model.Book;
import hu.uni.miskolc.webtech.librarian.model.BookInstance;
import hu.uni.miskolc.webtech.librarian.persist.BookInstanceAlreadyExistsException;
import hu.uni.miskolc.webtech.librarian.persist.BookInstanceDAO;
import hu.uni.miskolc.webtech.librarian.persist.BookInstanceNotFoundException;
import hu.uni.miskolc.webtech.librarian.persist.BookNotFoundException;

public class BookInstanceDAOImpl implements BookInstanceDAO {
	
	private Logger LOG = LogManager.getLogger();

	private static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";

	private SqlSessionFactory sqlSessionFactory;

	public BookInstanceDAOImpl(String mybatisConfigPath, String host, int port, String database, String user, String password)
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

	public void createBookInstance(BookInstance bookInstance) throws BookInstanceAlreadyExistsException {
		// TODO Auto-generated method stub

	}

	public Collection<BookInstance> readInstances(Book book) throws BookNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	public void updateBookInstance(BookInstance bookInstance) throws BookInstanceNotFoundException {
		// TODO Auto-generated method stub

	}

	public void deleteBookInstance(BookInstance bookInstance) throws BookInstanceNotFoundException {
		// TODO Auto-generated method stub

	}

}
