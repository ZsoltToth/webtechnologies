package hu.iit.uni.miskolc.iit.webtech.real.estate.service.impl;

import java.util.Collection;
import java.util.regex.Pattern;

import hu.iit.uni.miskolc.iit.webtech.real.estate.dao.ResidenceDAO;
import hu.iit.uni.miskolc.iit.webtech.real.estate.dao.ResidenceNotFoundException;
import hu.iit.uni.miskolc.iit.webtech.real.estate.dao.UserAlreadyExistsException;
import hu.iit.uni.miskolc.iit.webtech.real.estate.dao.UserDAO;
import hu.iit.uni.miskolc.iit.webtech.real.estate.dao.UserNotFoundException;
import hu.iit.uni.miskolc.iit.webtech.real.estate.model.Residence;
import hu.iit.uni.miskolc.iit.webtech.real.estate.model.User;
import hu.iit.uni.miskolc.iit.webtech.real.estate.service.AlreadyRegisteredUserException;
import hu.iit.uni.miskolc.iit.webtech.real.estate.service.InvalidEmailAddressException;
import hu.iit.uni.miskolc.iit.webtech.real.estate.service.UserRegistrationService;

public class UserRegistrationServiceImpl implements UserRegistrationService {

	private static final String EMAIL_PATTERN = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
			+ "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

	private UserDAO userDAO;
	private ResidenceDAO residenceDAO;

	public UserRegistrationServiceImpl(UserDAO userDAO, ResidenceDAO residenceDAO) {
		super();
		this.userDAO = userDAO;
		this.residenceDAO = residenceDAO;
	}

	public void register(String nickName, String email, String phone)
			throws AlreadyRegisteredUserException, InvalidEmailAddressException {
		if (!checkNickName(nickName)) {
			throw new AlreadyRegisteredUserException();
		}
		if (!checkEmailAddress(email)) {
			throw new InvalidEmailAddressException();
		}
		User user = new User(nickName, email, phone);
		try {
			userDAO.createUser(user);
		} catch (UserAlreadyExistsException e) {
			throw new AlreadyRegisteredUserException();
		}
	}

	private boolean checkNickName(String nickName) {
		try {
			userDAO.readUserByNickName(nickName);
		} catch (UserNotFoundException e) {
			return true;
		}
		return false;
	}

	private boolean checkEmailAddress(String email) {
		try {
			userDAO.readUserByEMail(email);
		} catch (UserNotFoundException e) {
			return Pattern.compile(EMAIL_PATTERN).matcher(email).matches();
		}
		return false;
	}

	public void deregister(User user) {
		try {
			userDAO.deleteUser(user);
		} catch (UserNotFoundException e) {
			return;
		}
		Collection<Residence> residencesOfUser = residenceDAO.readResidencesByUser(user);
		for (Residence residence : residencesOfUser) {
			try {
				residenceDAO.deleteResidence(residence);
			} catch (ResidenceNotFoundException e) {
				e.printStackTrace();
			}
		}
	}

}
