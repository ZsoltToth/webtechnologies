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
import hu.uni.miskolc.webtech.librarian.model.Nationality;
import hu.uni.miskolc.webtech.librarian.persist.AuthorDAO;
import hu.uni.miskolc.webtech.librarian.persist.AuthorNotFoundException;
import hu.uni.miskolc.webtech.librarian.persist.ExistingAuthorException;
import hu.uni.miskolc.webtech.librarian.persist.mysql.mapper.AuthorMapper;

public class AuthorDAOImpl implements AuthorDAO {

	private static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";

	private SqlSessionFactory sqlSessionFactory;

	public AuthorDAOImpl(String mybatisConfigPath, String host, int port, String database, String user, String password)
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

	@Override
	protected void finalize() throws Throwable {
		super.finalize();
	}

	public void createAuthor(Author author) throws ExistingAuthorException {
		Collection<Author> similarAuthors = readAuthorByName(author.getName());
		if(!similarAuthors.isEmpty()){
			throw new ExistingAuthorException(String.format("Author %s already exists in %s", author, similarAuthors));
		}
		SqlSession session = this.sqlSessionFactory.openSession();
		AuthorMapper authorMapper = session.getMapper(AuthorMapper.class);
		authorMapper.recordAuthor(author.getName(), author.getNationality().toString(), author.getBirthDate());
		session.commit();
		session.close();

	}

	public Collection<Author> readAuthors() {
		Collection<Author> result = new ArrayList<Author>();
		SqlSession session = this.sqlSessionFactory.openSession();
		AuthorMapper authorMapper = (AuthorMapper) session.getMapper(AuthorMapper.class);
		result = authorMapper.selectAuthors();
		session.commit();
		session.close();
		return result;
	}

	public Collection<Author> readAuthorByName(String name) {
		Collection<Author> result = new ArrayList<Author>();
		SqlSession session = this.sqlSessionFactory.openSession();
		AuthorMapper authorMapper = (AuthorMapper) session.getMapper(AuthorMapper.class);
		result = authorMapper.selectAuthorsByName("%" + name + "%");
		session.commit();
		session.close();
		return result;
	}

	public Collection<Author> readAuthorByNationality(Nationality nationality) {
		Collection<Author> result = new ArrayList<Author>();
		SqlSession session = this.sqlSessionFactory.openSession();
		AuthorMapper authorMapper = (AuthorMapper) session.getMapper(AuthorMapper.class);
		result = authorMapper.selectAuthorsByNationality(nationality.toString());
		session.commit();
		session.close();
		return result;
	}

	public Author readAuthor(int id) throws AuthorNotFoundException {
		Author result = null;
		SqlSession session = this.sqlSessionFactory.openSession();
		AuthorMapper authorMapper = (AuthorMapper) session.getMapper(AuthorMapper.class);
		result = authorMapper.selectAuthorById(id);
		session.commit();
		session.close();
		if(result == null){
			throw new AuthorNotFoundException(String.format("There is no author with id<%d>", id));
		}
		return result;
	}

	public void updateAuthor(Author author) throws AuthorNotFoundException {
		SqlSession session = this.sqlSessionFactory.openSession();
		try{
			AuthorMapper mapper = (AuthorMapper) session.getMapper(AuthorMapper.class);
			mapper.updateAuthor(author);
		}
		catch(Exception ex){
			throw new AuthorNotFoundException(ex);
		}
		session.commit();
		session.close();
	}

	public void deleteAuthor(Author author) throws AuthorNotFoundException {
		// TODO Auto-generated method stub

	}

}
