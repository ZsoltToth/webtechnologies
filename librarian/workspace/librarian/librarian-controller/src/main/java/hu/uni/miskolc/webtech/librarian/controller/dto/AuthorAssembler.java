package hu.uni.miskolc.webtech.librarian.controller.dto;

import hu.uni.miskolc.webtech.librarian.model.Author;
import hu.uni.miskolc.webtech.librarian.model.exceptions.IllegalBirthDateException;
import hu.uni.miskolc.webtech.librarian.model.exceptions.IllegalPersonNameException;

public class AuthorAssembler {

	public static Author assembleAuthor(AuthorDTO dto) throws IllegalPersonNameException, IllegalBirthDateException{
		return new Author(dto.getAuthorID(), dto.getName(), dto.getNationality(), dto.getBirthDate());
	}
	
	public static AuthorDTO assembleDTO(Author author){
		AuthorDTO result = new AuthorDTO();
		result.setAuthorID(author.getAuthorID());
		result.setName(author.getName());
		result.setNationality(author.getNationality());
		result.setBirthDate(author.getBirthDate());
		return result;
	}

}
