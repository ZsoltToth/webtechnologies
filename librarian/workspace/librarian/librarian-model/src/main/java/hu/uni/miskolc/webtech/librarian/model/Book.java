package hu.uni.miskolc.webtech.librarian.model;

import java.util.ArrayList;
import java.util.Collection;

public class Book {

	private final int bookId;
	private final String title;
	private Collection<Genre> genres;
	private Collection<Author> authors;

	public Book(int bookId, String title, Collection<Genre> genres, Collection<Author> authors) {
		super();
		this.bookId = bookId;
		this.title = title;
		this.genres = genres;
		this.authors = authors;
	}

	public Book(int bookId, String title, Collection<Author> authors) {
		this(bookId, title, new ArrayList<Genre>(), authors);
	}

	public int getBookId() {
		return bookId;
	}

	public String getTitle() {
		return title;
	}

	public Collection<Genre> getGenres() {
		return new ArrayList<Genre>(genres);
	}

	public void addGenre(Genre genre) {
		this.genres.add(genre);
	}

	public void removeGenre(Genre genre) {
		this.genres.remove(genre);
	}

	public Collection<Author> getAuthors() {
		return authors;
	}

	public void setAuthors(Collection<Author> authors) {
		this.authors = authors;
	}

	public void setGenres(Collection<Genre> genres) {
		this.genres = genres;
	}

}
