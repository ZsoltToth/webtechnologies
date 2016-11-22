package hu.uni.miskolc.webtech.librarian.controller.dto;

import java.util.Collection;

import hu.uni.miskolc.webtech.librarian.model.Author;
import hu.uni.miskolc.webtech.librarian.model.Genre;

public class BookDTO {

	private int bookId;
	private String title;
	private Collection<Genre> genres;
	private Collection<AuthorDTO> authors;

	public BookDTO() {
		super();
	}

	public BookDTO(int bookId, String title, Collection<Genre> genres, Collection<AuthorDTO> authors) {
		super();
		this.bookId = bookId;
		this.title = title;
		this.genres = genres;
		this.authors = authors;
	}

	public int getBookId() {
		return bookId;
	}

	public void setBookId(int bookId) {
		this.bookId = bookId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Collection<Genre> getGenres() {
		return genres;
	}

	public void setGenres(Collection<Genre> genres) {
		this.genres = genres;
	}

	public Collection<AuthorDTO> getAuthors() {
		return authors;
	}

	public void setAuthors(Collection<AuthorDTO> authors) {
		this.authors = authors;
	}

	@Override
	public String toString() {
		return "BookDTO [bookId=" + bookId + ", title=" + title + ", genres=" + genres + ", authors=" + authors + "]";
	}

}
