package hu.uni.miskolc.webtech.librarian.persist.mysql.mapper;

import java.util.Collection;

import org.apache.ibatis.annotations.Param;

import hu.uni.miskolc.webtech.librarian.model.Author;
import hu.uni.miskolc.webtech.librarian.model.Book;
import hu.uni.miskolc.webtech.librarian.model.Genre;

public interface BookMapper {
	
	Collection<Genre> queryGenresOfBook(@Param("bookId") int book);
	
	Collection<Author> queryAuthorsOfBook(@Param("bookId") int book);
	
	Collection<Book> selectBooks();
}
