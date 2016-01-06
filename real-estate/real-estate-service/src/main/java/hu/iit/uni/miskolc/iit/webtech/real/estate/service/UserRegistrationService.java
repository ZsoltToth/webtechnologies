package hu.iit.uni.miskolc.iit.webtech.real.estate.service;

import hu.iit.uni.miskolc.iit.webtech.real.estate.model.User;

public interface UserRegistrationService {
	
	public void register(String nickName, String email, String phone) throws AlreadyRegisteredUserException, InvalidEmailAddressException;
	public void deregister(User user);

}
