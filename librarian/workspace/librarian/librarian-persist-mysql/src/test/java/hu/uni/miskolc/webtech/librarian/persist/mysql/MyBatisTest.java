package hu.uni.miskolc.webtech.librarian.persist.mysql;

import static org.junit.Assert.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Properties;

import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Ignore;
import org.junit.Test;

@Ignore
public class MyBatisTest {

	private static final String MYBATIS_CONFIG_PATH = "src/main/resources/mybatis-configuration.xml";

	@Test
	public void testFindMyBatisConfigFile() {
		File mybatisConfigFile = new File(MYBATIS_CONFIG_PATH);
		assertTrue(mybatisConfigFile.exists());
	}

	@Test
	public void testBuildSqlSessionFactory() throws FileNotFoundException {
		File configFile = new File(MYBATIS_CONFIG_PATH);
		InputStream inputStream = new FileInputStream(configFile);
		SqlSessionFactory sqlSessionFactory = (new SqlSessionFactoryBuilder()).build(inputStream);
		// System.out.println(sqlSessionFactory.toString());
		// System.out.println(String.format("Session object: %s",
		// sqlSessionFactory.openSession()));
	}

	
	@Test
	public void testBuildSqlSessionFactoryWithProperties() throws FileNotFoundException {
		File configFile = new File(MYBATIS_CONFIG_PATH);
		InputStream inputStream = new FileInputStream(configFile);
		Properties props = new Properties();
		props.put("driver", "com.mysql.jdbc.Driver");
		props.put("url", "jdbc:mysql://localhost:3306/librarian");
		props.put("username", "lily");
		props.put("password", "lily");

		SqlSessionFactory sqlSessionFactory = (new SqlSessionFactoryBuilder()).build(inputStream, props);
		// System.out.println(sqlSessionFactory.toString());
		// System.out.println(String.format("Session object: %s",
		// sqlSessionFactory.openSession()));

	}

}
