package hu.uni.miskolc.webtech.librarian.model;

import java.util.Collection;

public class Book {

	private int bookId;
	private String title;
	private Collection<Genre> genres;
	private Collection<Author> authors;

	public Book() {
		super();
	}

	public Book(int bookId, String title, Collection<Genre> genres, Collection<Author> authors) {
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

	public Collection<Author> getAuthors() {
		return authors;
	}

	public void setAuthors(Collection<Author> authors) {
		this.authors = authors;
	}

}
