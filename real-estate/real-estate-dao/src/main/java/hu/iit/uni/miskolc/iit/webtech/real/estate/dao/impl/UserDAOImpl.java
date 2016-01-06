package hu.iit.uni.miskolc.iit.webtech.real.estate.dao.impl;

import java.util.Collection;
import java.util.HashSet;

import hu.iit.uni.miskolc.iit.webtech.real.estate.dao.UserAlreadyExistsException;
import hu.iit.uni.miskolc.iit.webtech.real.estate.dao.UserDAO;
import hu.iit.uni.miskolc.iit.webtech.real.estate.dao.UserNotFoundException;
import hu.iit.uni.miskolc.iit.webtech.real.estate.model.User;

public class UserDAOImpl implements UserDAO {

	private static Collection<User> userDatabase;

	static {
		userDatabase = new HashSet<User>();
	}

	public void createUser(User user) throws UserAlreadyExistsException {
		if (userDatabase.contains(user)) {
			throw new UserAlreadyExistsException();
		}
		userDatabase.add(user);
	}

	/**
	 * It performs deep copy of the "database".
	 */
	public Collection<User> readUsers() {
		Collection<User> result = new HashSet<User>();
		for (User user : userDatabase) {
			try {
				result.add((User) user.clone());
			} catch (CloneNotSupportedException e) {
				e.printStackTrace();
			}
		}
		return result;
	}

	public User readUserByNickName(String nickName) throws UserNotFoundException {
		User result = null;
		for (User user : userDatabase) {
			if (nickName.equals(user.getNickName())) {
				result = user;
				break;
			}
		}
		try {
			result = (User) result.clone();
		} catch (CloneNotSupportedException ex) {
			result = null;
			ex.printStackTrace();
		}

		if (result == null) {
			throw new UserNotFoundException();
		}

		return result;
	}

	public User readUserByEMail(String email) throws UserNotFoundException {
		User result = null;
		for (User user : userDatabase) {
			if (email.equals(user.getEmail())) {
				result = user;
				break;
			}
		}
		try {
			result = (User) result.clone();
		} catch (CloneNotSupportedException e) {
			result = null;
			e.printStackTrace();
		}

		if (result == null) {
			throw new UserNotFoundException();
		}
		return result;
	}

	public void updateUser(User user) throws UserNotFoundException {
		if (userDatabase.contains(user) == false) {
			throw new UserNotFoundException();
		}
		for(User storedUser : userDatabase){
			if(storedUser == user){
				storedUser.setEmail(user.getEmail());
				storedUser.setPhone(user.getPhone());
			}
		}
	}

	public void deleteUser(User user) throws UserNotFoundException {
		if(userDatabase.contains(user) == false){
			throw new UserNotFoundException();
		}
		userDatabase.remove(user);
	}

}
