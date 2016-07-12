package hu.uni.miskolc.webtech.librarian.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import hu.uni.miskolc.webtech.librarian.model.Author;
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
	public @ResponseBody Collection<Author> listAuthors(){
		return bookManager.queryAuthors();
	}

}
