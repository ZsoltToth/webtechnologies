package hu.uni.miskolc.webtech.librarian.controller.dto;

import java.util.Collection;
import java.util.HashSet;

import hu.uni.miskolc.webtech.librarian.model.Author;
import hu.uni.miskolc.webtech.librarian.model.Book;
import hu.uni.miskolc.webtech.librarian.model.Genre;
import hu.uni.miskolc.webtech.librarian.model.exceptions.IllegalBirthDateException;
import hu.uni.miskolc.webtech.librarian.model.exceptions.IllegalPersonNameException;

public class BookAssembler {

	public static Book assembleAuthor(BookDTO dto) {
		Book result;
		int bookId = dto.getBookId();
		String title = dto.getTitle();
		Collection<Genre> genres = dto.getGenres();
		Collection<Author> authors = new HashSet<>();
		for (AuthorDTO authorDTO : dto.getAuthors()) {
			try {
				authors.add(AuthorAssembler.assembleAuthor(authorDTO));
			} catch (IllegalPersonNameException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalBirthDateException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		result = new Book(bookId, title, authors);
		result.setGenres(genres);
		return result;
	}

	public static BookDTO assembleDTO(Book book) {
		BookDTO result = new BookDTO();
		result.setBookId(book.getBookId());
		result.setTitle(book.getTitle());
		result.setGenres(book.getGenres());
		Collection<AuthorDTO> authorDTOs = new HashSet<>();
		for (Author author : book.getAuthors()) {
			authorDTOs.add(AuthorAssembler.assembleDTO(author));
		}
		result.setAuthors(authorDTOs);
		return result;
	}
}
