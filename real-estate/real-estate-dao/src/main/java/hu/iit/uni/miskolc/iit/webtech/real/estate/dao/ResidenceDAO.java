package hu.iit.uni.miskolc.iit.webtech.real.estate.dao;

import java.util.Collection;
import java.util.Date;

import hu.iit.uni.miskolc.iit.webtech.real.estate.model.Residence;
import hu.iit.uni.miskolc.iit.webtech.real.estate.model.User;

/**
 * Contains CRUD methods for Residence objects.
 * 
 * @author zsolt
 *
 */
public interface ResidenceDAO {

	/**
	 * 
	 * @param residence 
	 * @throws ResidenceAlreadyExistsException 
	 */
	void createResidence(Residence residence) throws ResidenceAlreadyExistsException;
	
	/**
	 * 
	 * @return collection of each stored residence objects.
	 */
	Collection<Residence> readResidences();
	
	/**
	 * 
	 * @param user 
	 * @return a collection of each stored residences of the specified user.
	 */
	Collection<Residence> readResidencesByUser(User user);
	
	/**
	 * Selects the residences which were advertised within the given interval.
	 * 
	 * @param published 
	 * @param expired 
	 * @return a collection of the selected objects.
	 */
	Collection<Residence> readResidencesInInterval(Date published, Date expired);
	
	/**
	 * 
	 * @return a collection of the active advertisements.
	 */
	Collection<Residence> readResidencesCurrentlyPublished();
	
	/**
	 * Selects every advertisements which has at least one matching keyword.
	 * 
	 * @param keywords 
	 * @return a collection of the selected objects
	 */
	Collection<Residence> readResidencesByAnyKeyword(String[] keywords);
	
	/**
	 * A residence is selected if it contains all of the given keywords.
	 * 
	 * @param keywords 
	 * @return a collection of the selected objects.
	 */
	Collection<Residence> readResidencesByAllKeyword(String[] keywords);
	
	/**
	 * 
	 * @param residence 
	 * @throws ResidenceNotFoundException 
	 */
	void updateResidence(Residence residence) throws ResidenceNotFoundException;
	
	/**
	 * 
	 * @param residence 
	 * @throws ResidenceNotFoundException 
	 */
	void deleteResidence(Residence residence) throws ResidenceNotFoundException;
	
}
