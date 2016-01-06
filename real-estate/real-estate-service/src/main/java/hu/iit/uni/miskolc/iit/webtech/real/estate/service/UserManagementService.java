package hu.iit.uni.miskolc.iit.webtech.real.estate.service;

import java.util.Collection;

import hu.iit.uni.miskolc.iit.webtech.real.estate.model.User;

public interface UserManagementService {

	public void changeEmail(User user, String newEmail);

	public void changePhone(User user, String newPhone);

	public void changePassword(User user, String newPassword);
	
	public Collection<User> listUsers();

}
