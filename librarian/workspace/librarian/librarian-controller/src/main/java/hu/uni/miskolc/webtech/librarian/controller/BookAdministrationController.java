package hu.uni.miskolc.webtech.librarian.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import hu.uni.miskolc.webtech.librarian.controller.dto.AuthorAssembler;
import hu.uni.miskolc.webtech.librarian.controller.dto.AuthorDTO;
import hu.uni.miskolc.webtech.librarian.model.Author;
import hu.uni.miskolc.webtech.librarian.model.exceptions.IllegalBirthDateException;
import hu.uni.miskolc.webtech.librarian.model.exceptions.IllegalPersonNameException;
import hu.uni.miskolc.webtech.librarian.service.AuthorManipulationException;
import hu.uni.miskolc.webtech.librarian.service.BookManagerService;

@Controller
public class BookAdministrationController {

	@Autowired
	private BookManagerService bookManager;

	public BookAdministrationController() {
		super();
	}

	public BookAdministrationController(BookManagerService bookManager) {
		this.bookManager = bookManager;
	}

	@RequestMapping("/authors")
	public @ResponseBody Collection<Author> listAuthors() {
		return bookManager.queryAuthors();
	}

	@RequestMapping(value = { "/author/insert" }, method = RequestMethod.POST)
	public void createAuthor(@RequestBody AuthorDTO author) throws AuthorManipulationException {
		try {
			bookManager.addAuthor(AuthorAssembler.assembleAuthor(author));
		} catch (IllegalPersonNameException e) {
			throw new AuthorManipulationException(e.getMessage(), e);

		} catch (IllegalBirthDateException e) {
			throw new AuthorManipulationException(e.getMessage(), e);
		}
	}

	@RequestMapping(value = { "/author/update" }, method = RequestMethod.POST)
	public void updateAuthor(@RequestBody AuthorDTO author) throws AuthorManipulationException {

		try {
			Author a = AuthorAssembler.assembleAuthor(author);
			bookManager.updateAuthor(a);

		} catch (IllegalPersonNameException e) {
			throw new AuthorManipulationException(e.getMessage(), e);
		} catch (IllegalBirthDateException e) {
			throw new AuthorManipulationException(e.getMessage(), e);
		}
	}

	// Exception handling methods

	@ResponseStatus(value = HttpStatus.CONFLICT)
	@ExceptionHandler(AuthorManipulationException.class)
	public void authorManipulationExceptionHandler() {

	}

}
