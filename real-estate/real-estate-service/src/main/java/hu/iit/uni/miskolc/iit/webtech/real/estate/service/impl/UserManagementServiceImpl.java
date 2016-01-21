package hu.iit.uni.miskolc.iit.webtech.real.estate.service.impl;

import java.util.Collection;

import hu.iit.uni.miskolc.iit.webtech.real.estate.dao.UserDAO;
import hu.iit.uni.miskolc.iit.webtech.real.estate.dao.UserNotFoundException;
import hu.iit.uni.miskolc.iit.webtech.real.estate.model.User;
import hu.iit.uni.miskolc.iit.webtech.real.estate.service.UserManagementService;

public class UserManagementServiceImpl implements UserManagementService {

	private UserDAO userDAO;

	public UserManagementServiceImpl(UserDAO userDAO) {
		super();
		this.userDAO = userDAO;
	}

	public void changeEmail(User user, String newEmail) {
		user.setEmail(newEmail);
		try {
			userDAO.updateUser(user);
		} catch (UserNotFoundException e) {
			e.printStackTrace();
		}
	}

	public void changePhone(User user, String newPhone) {	
		user.setPhone(newPhone);
		try {
			userDAO.updateUser(user);
		} catch (UserNotFoundException e) {
			e.printStackTrace();
		}
	}

	public void changePassword(User user, String newPassword) {
		System.out.println("Not implemented yet");
	}

	public Collection<User> listUsers() {
		return userDAO.readUsers();
	}

}
