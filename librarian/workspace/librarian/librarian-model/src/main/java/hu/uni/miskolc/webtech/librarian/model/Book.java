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

	private Book(Integer bookId, String title) {
		super();
		this.bookId = bookId;
		this.title = title;
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
	
	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((authors == null) ? 0 : authors.hashCode());
		result = prime * result + bookId;
		result = prime * result + ((genres == null) ? 0 : genres.hashCode());
		result = prime * result + ((title == null) ? 0 : title.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Book other = (Book) obj;
		if (authors == null) {
			if (other.authors != null)
				return false;
		} else if (!authors.equals(other.authors))
			return false;
		if (bookId != other.bookId)
			return false;
		if (genres == null) {
			if (other.genres != null)
				return false;
		} else if (!genres.equals(other.genres))
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Book [bookId=" + bookId + ", title=" + title + ", genres=" + genres + ", authors=" + authors + "]";
	}
	
	

}
