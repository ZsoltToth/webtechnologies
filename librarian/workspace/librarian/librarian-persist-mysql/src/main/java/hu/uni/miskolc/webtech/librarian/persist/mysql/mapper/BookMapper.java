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
	
	Collection<Book> selectBooksByTitle(@Param("title") String title);
	
	Collection<Book> selectBooksByAuthor(@Param("author") Author author);
	
	Collection<Book> selectBooksByGenre(@Param("genre") Genre genre);
	
	Book selectBookById(@Param("bookId") int bookId);
	
	void deleteBookById(@Param("bookId") int bookId);
	
	void removeAuthorFromBook(@Param("bookId")int bookId, @Param("authorId") int authorId);
	void removeGenreFromBook(@Param("genre")Genre genre, @Param("bookId") int bookId);
	
	void insertAuthorForBook(@Param("bookId") int bookId, @Param("authorId") int authorId);
	void insertGenreForBook(@Param("genre") Genre genre, @Param("bookId") int bookId);
	void updateBook(@Param("book") Book book);
	
}
