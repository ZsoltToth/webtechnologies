package hu.uni.miskolc.webtech.librarian.persist.mysql.mapper;

import java.util.Collection;
import java.util.Date;

import org.apache.ibatis.annotations.Param;

import hu.uni.miskolc.webtech.librarian.model.Author;

public interface AuthorMapper {

	public Collection<Author> selectAuthors();

	public Collection<Author> selectAuthorsByName(String name);

	public Collection<Author> selectAuthorsByNationality(String nationality);

	public Author selectAuthorById(Integer authorId);

	public void recordAuthor(@Param("name") String name, @Param("nationality") String nationality,
			@Param("birthDate") Date birthDate);

	public void updateAuthor(@Param("author") Author author);

	public void deleteAuthor(@Param("author") Author author);
}
