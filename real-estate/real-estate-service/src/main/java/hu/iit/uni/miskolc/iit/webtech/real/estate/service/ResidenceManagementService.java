package hu.iit.uni.miskolc.iit.webtech.real.estate.service;

import java.io.File;
import java.util.Date;

import hu.iit.uni.miskolc.iit.webtech.real.estate.model.Address;
import hu.iit.uni.miskolc.iit.webtech.real.estate.model.Price;
import hu.iit.uni.miskolc.iit.webtech.real.estate.model.Residence;
import hu.iit.uni.miskolc.iit.webtech.real.estate.model.User;

public interface ResidenceManagementService {

	public void publish(String name, String description, Address address, Price price, Date published, Date expire,
			File mainPhotoPath, File[] phathOfPhotos, User contact);

	public void delete(Residence residence);

	public void update(Residence residence, String description, Price price);
}
