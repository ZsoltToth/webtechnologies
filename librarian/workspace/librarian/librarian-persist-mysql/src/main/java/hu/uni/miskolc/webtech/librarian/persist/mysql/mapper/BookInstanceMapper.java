package hu.uni.miskolc.webtech.librarian.persist.mysql.mapper;

import java.util.Collection;

import hu.uni.miskolc.webtech.librarian.model.BookInstance;

public interface BookInstanceMapper {

	
	Collection<BookInstance> selectAllBookInstances();
}
