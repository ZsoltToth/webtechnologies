package hu.uni.miskolc.webtech.librarian.controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Collection;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import hu.uni.miskolc.webtech.librarian.controller.dto.BookAssembler;
import hu.uni.miskolc.webtech.librarian.controller.dto.BookDTO;
import hu.uni.miskolc.webtech.librarian.model.Author;
import hu.uni.miskolc.webtech.librarian.model.Book;
import hu.uni.miskolc.webtech.librarian.model.Genre;
import hu.uni.miskolc.webtech.librarian.model.Nationality;
import hu.uni.miskolc.webtech.librarian.service.BookManagerService;

@Controller
public class BookAdministrationController {
	private static final Logger LOG = LogManager.getLogger();

	@Autowired
	private BookManagerService bookManager;

	public BookAdministrationController() {
		super();
	}

	public BookAdministrationController(BookManagerService bookManager) {
		super();
		this.bookManager = bookManager;
	}

	@RequestMapping("/books")
	public @ResponseBody Collection<Book> listBooks() {
		return bookManager.queryBooks();
	}

	@RequestMapping("/books/dto")
	public @ResponseBody BookDTO dummyBookDTO() {
		BookDTO result = null;
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		try{
		Book dummyBook = new Book(1, "Dummy Book #1",
				Arrays.asList(
						new Author(1, "Author 1", Nationality.American, dateFormat.parse("1900-01-01")),
						new Author(2, "Author 2", Nationality.British, dateFormat.parse("1900-02-02"))
						)
				);
		dummyBook.addGenre(Genre.Novel);
		dummyBook.addGenre(Genre.SciFi);
		result = BookAssembler.assembleDTO(dummyBook);
		}
		catch(Exception ex){
			LOG.warn(ex.getMessage());
		}
		return result;
	}
}
