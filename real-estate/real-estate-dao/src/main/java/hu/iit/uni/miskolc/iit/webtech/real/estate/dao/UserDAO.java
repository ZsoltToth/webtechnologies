package hu.iit.uni.miskolc.iit.webtech.real.estate.dao;

import java.util.Collection;

import hu.iit.uni.miskolc.iit.webtech.real.estate.model.User;

public interface UserDAO {

	
	public void createUser(User user) throws UserAlreadyExistsException;
	
	public Collection<User> readUsers();
	public User readUserByNickName(String nickName) throws UserNotFoundException;
	public User readUserByEMail(String email) throws UserNotFoundException;
	
	public void updateUser(User user) throws UserNotFoundException;
	
	public void deleteUser(User user) throws UserNotFoundException;
	
}
