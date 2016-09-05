package hu.uni.miskolc.webtech.librarian.controller;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Collection;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
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
import hu.uni.miskolc.webtech.librarian.model.Nationality;
import hu.uni.miskolc.webtech.librarian.model.exceptions.IllegalBirthDateException;
import hu.uni.miskolc.webtech.librarian.model.exceptions.IllegalPersonNameException;
import hu.uni.miskolc.webtech.librarian.service.AuthorManipulationException;
import hu.uni.miskolc.webtech.librarian.service.BookManagerService;

@Controller
public class AuthorAdministrationController {
	
	private static final Logger LOG = LogManager.getLogger();

	
	
	@Autowired
	private BookManagerService bookManager;

	public AuthorAdministrationController() {
		super();
	}

	public AuthorAdministrationController(BookManagerService bookManager) {
		this.bookManager = bookManager;
	}

	@RequestMapping("/authors")
	public @ResponseBody Collection<Author> listAuthors() {
		return bookManager.queryAuthors();
	}

	@RequestMapping(value = { "/author/insert" }, method = RequestMethod.POST, consumes = "application/json")
	@ResponseBody
	public void createAuthor(@RequestBody AuthorDTO author) throws AuthorManipulationException {
//		LOG.info(author);
		try {
			bookManager.addAuthor(AuthorAssembler.assembleAuthor(author));
		} catch (IllegalPersonNameException e) {
			LOG.info(e.getMessage());
			throw new AuthorManipulationException(e.getMessage(), e);

		} catch (IllegalBirthDateException e) {
			LOG.info(e.getMessage());
			throw new AuthorManipulationException(e.getMessage(), e);
		}
	}

	@RequestMapping(
			value = { "/author/update" }, 
			method = RequestMethod.POST,
			consumes = {"application/json"}
			)
	@ResponseBody
	public void updateAuthor(@RequestBody AuthorDTO author) throws AuthorManipulationException {
//		LOG.info(author);
		try {
			Author a = AuthorAssembler.assembleAuthor(author);
			bookManager.updateAuthor(a);
//			LOG.info("update is done");
		} catch (IllegalPersonNameException e) {
			LOG.info(e.getMessage());
			throw new AuthorManipulationException(e.getMessage(), e);
		} catch (IllegalBirthDateException e) {
			LOG.info(e.getMessage());
			throw new AuthorManipulationException(e.getMessage(), e);
		}
	}

	
	@RequestMapping("/author/dto")
	@ResponseBody
	public AuthorDTO exampleAuthorDTO() throws IllegalPersonNameException, IllegalBirthDateException, ParseException{
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		return AuthorAssembler.assembleDTO(new Author(0, "John Doe", Nationality.American, dateFormat.parse("1234-12-21")));
	}

	// Exception handling methods

	@ResponseStatus(value = HttpStatus.CONFLICT)
	@ExceptionHandler(AuthorManipulationException.class)
	@ResponseBody
	public String authorManipulationExceptionHandler(Exception ex) {
		LOG.error(ex.getMessage() + "caused by " + ex.getCause().getMessage());
		return ex.getMessage();
	}

}
