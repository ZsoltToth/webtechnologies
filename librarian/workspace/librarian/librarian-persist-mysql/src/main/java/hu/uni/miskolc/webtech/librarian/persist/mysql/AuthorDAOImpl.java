package hu.uni.miskolc.webtech.librarian.persist.mysql;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Properties;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import hu.uni.miskolc.webtech.librarian.model.Author;
import hu.uni.miskolc.webtech.librarian.persist.AuthorDAO;
import hu.uni.miskolc.webtech.librarian.persist.AuthorNotFoundException;
import hu.uni.miskolc.webtech.librarian.persist.ExistingAuthorException;
import hu.uni.miskolc.webtech.librarian.persist.mysql.mapper.AuthorMapper;

public class AuthorDAOImpl implements AuthorDAO {
	
	private static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	
	private SqlSessionFactory sqlSessionFactory;
	
	
	public AuthorDAOImpl(String mybatisConfigPath, String host, int port, String database, String user, String password) throws FileNotFoundException{
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
	
	@Override
	protected void finalize() throws Throwable {
		super.finalize();
	}

	public void createAuthor(Author author) throws ExistingAuthorException {
		// TODO Auto-generated method stub

	}

	public Collection<Author> readAuthors() {
		Collection<Author> result = new ArrayList<Author>();
		SqlSession session = this.sqlSessionFactory.openSession();
		AuthorMapper authorMapper = (AuthorMapper)session.getMapper(AuthorMapper.class);
		result = authorMapper.selectAuthors();
		session.commit();
		session.close();
		return result;
	}

	public Collection<Author> readAuthorByName() {
		// TODO Auto-generated method stub
		return null;
	}

	public Collection<Author> readAuthorByNationality() {
		// TODO Auto-generated method stub
		return null;
	}

	public Author readAuthor(int id) throws AuthorNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	public void updateAuthor(Author author) throws AuthorNotFoundException {
		// TODO Auto-generated method stub

	}

	public void deleteAuthor(Author author) throws AuthorNotFoundException {
		// TODO Auto-generated method stub

	}

}
