package hu.uni.miskolc.webtech.librarian.service;

import hu.uni.miskolc.webtech.librarian.model.User;

public interface UserManagementService {
	
	public void registerUser(User user);
	
	public void changePassword(User user, String newPassword);
	
	

}
