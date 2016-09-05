package hu.uni.miskolc.webtech.librarian.persist;

import java.util.Collection;

import hu.uni.miskolc.webtech.librarian.model.User;

public interface UserDAO {

	public void createUser(User user) throws ExistingUserException;
	
	public Collection<User> readUsers();
	public Collection<User> readUsersByName(String name);
	
	public User readUserByEmail() throws UserNotFoundException;
	public User readUserById() throws UserNotFoundException;
	
	public void updateUser(User user) throws UserNotFoundException;
	
	public void deleteUser(User user) throws UserNotFoundException;
	public void deleteUser(String email) throws UserNotFoundException;
	public void deleteUser(int id) throws UserNotFoundException;
}
