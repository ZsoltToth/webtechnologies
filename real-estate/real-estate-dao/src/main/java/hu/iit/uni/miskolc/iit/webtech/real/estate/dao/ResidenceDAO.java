package hu.iit.uni.miskolc.iit.webtech.real.estate.dao;

import java.util.Collection;
import java.util.Date;

import hu.iit.uni.miskolc.iit.webtech.real.estate.model.Residence;
import hu.iit.uni.miskolc.iit.webtech.real.estate.model.User;

public interface ResidenceDAO {

	public void createResidence(Residence residence) throws ResidenceAlreadyExistsException;
	
	public Collection<Residence> readResidences();
	public Collection<Residence> readResidencesByUser(User user);
	public Collection<Residence> readResidencesInInterval(Date published, Date expired);
	public Collection<Residence> readResidencesCurrentlyPublished();
	public Collection<Residence> readResidencesByAnyKeyword(String[] keywords);
	public Collection<Residence> readResidencesByAllKeyword(String[] keywords);
	
	public void updateResidence(Residence residence) throws ResidenceNotFoundException;
	
	public void deleteResidence(Residence residence) throws ResidenceNotFoundException;
	
}
