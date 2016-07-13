package hu.uni.miskolc.webtech.librarian.persist.mysql.mapper;

import java.util.Collection;

import hu.uni.miskolc.webtech.librarian.model.Author;

public interface AuthorMapper {

	public Collection<Author> selectAuthors();
}
