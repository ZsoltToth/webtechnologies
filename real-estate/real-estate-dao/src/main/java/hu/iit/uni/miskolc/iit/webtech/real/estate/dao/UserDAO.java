package hu.iit.uni.miskolc.iit.webtech.real.estate.dao;

import java.util.Collection;

import hu.iit.uni.miskolc.iit.webtech.real.estate.model.User;

/**
 * It contains the CRUD methods for User objects.
 * 
 * @author zsolt
 *
 */
public interface UserDAO {

	/**
	 * Persists the given user.
	 * {@link UserAlreadyExistsException} is thrown is the user has been persisted earlier.
	 * 
	 * @param user 
	 * @throws UserAlreadyExistsException if the user has been stored earlier
	 */
	void createUser(final User user) throws UserAlreadyExistsException;
	
	/**
	 * Returns with a copy of each stored User objects.
	 * 
	 * @return collection of users
	 */
	Collection<User> readUsers();
	
	/**
	 * Returns with the user which nick name was specified.
	 * It should not return with null.
	 * 
	 * @param nickName nick name of the user.
	 * @return user object which nickName was specified. 
	 * @throws UserNotFoundException if there is no user with the given nick name.
	 */
	User readUserByNickName(String nickName) throws UserNotFoundException;
	
	/**
	 * Returns with the user which email address was given.
	 * It should not return with null.
	 * 
	 * @param email 
	 * @return specified user.
	 * @throws UserNotFoundException if there is no user with the given email address.
	 */
	User readUserByEMail(String email) throws UserNotFoundException;
	
	/**
	 * Updates the user in the database.
	 * 
	 * @param user 
	 * @throws UserNotFoundException if there is no user with the given nick name in the database.
	 */
	void updateUser(User user) throws UserNotFoundException;
	
	/**
	 * 
	 * @param user 
	 * @throws UserNotFoundException if there is no such user. 
	 */
	void deleteUser(User user) throws UserNotFoundException;
	
}
