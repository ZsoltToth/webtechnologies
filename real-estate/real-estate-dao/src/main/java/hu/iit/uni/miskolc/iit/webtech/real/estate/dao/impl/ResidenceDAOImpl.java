package hu.iit.uni.miskolc.iit.webtech.real.estate.dao.impl;

import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import hu.iit.uni.miskolc.iit.webtech.real.estate.dao.ResidenceAlreadyExistsException;
import hu.iit.uni.miskolc.iit.webtech.real.estate.dao.ResidenceDAO;
import hu.iit.uni.miskolc.iit.webtech.real.estate.dao.ResidenceNotFoundException;
import hu.iit.uni.miskolc.iit.webtech.real.estate.model.Residence;
import hu.iit.uni.miskolc.iit.webtech.real.estate.model.User;

/**
 * A Collections based implementation.
 * The objects are stored in the memory.
 * 
 * @author zsolt
 *
 */
public class ResidenceDAOImpl implements ResidenceDAO {

	private static Collection<Residence> residenceDatabase;

	static {
		residenceDatabase = new HashSet<Residence>();
	}

	public void createResidence(Residence residence) throws ResidenceAlreadyExistsException {
		if (residenceDatabase.contains(residence) == true) {
			throw new ResidenceAlreadyExistsException();
		}
		residenceDatabase.add(residence);
	}

	public Collection<Residence> readResidences() {
		Collection<Residence> result = new HashSet<Residence>();
		for (Residence residence : residenceDatabase) {
			try {
				result.add((Residence) residence.clone());
			} catch (CloneNotSupportedException e) {
				e.printStackTrace();
			}
		}
		return result;
	}

	public Collection<Residence> readResidencesByUser(User user) {
		Collection<Residence> result = new HashSet<Residence>();
		if (user == null) {
			return result;
		}
		for (Residence residence : residenceDatabase) {
			if (!user.equals(residence.getContact())) {
				continue;
			}
			try {
				result.add((Residence) residence.clone());
			} catch (CloneNotSupportedException e) {
				e.printStackTrace();
			}
		}
		return result;
	}

	public Collection<Residence> readResidencesInInterval(Date published, Date expired) {
		if (published != null && expired != null) {
			Set<Residence> result = new HashSet<Residence>(readResidencesFromDate(published));
			result.retainAll(readResidencesToDate(expired));
			return result;
			// return readResidencesBetweenDates(published, expired);
		}
		if (published == null && expired != null) {
			return readResidencesToDate(expired);
		}
		if (published != null && expired == null) {
			return readResidencesFromDate(published);
		}
		return readResidences();
	}

	private Collection<Residence> readResidencesToDate(Date expire) {
		Collection<Residence> result = new HashSet<Residence>();
		for (Residence residence : residenceDatabase) {
			if (residence.getExpire().before(expire)) {
				try {
					result.add((Residence) residence.clone());
				} catch (CloneNotSupportedException e) {
					e.printStackTrace();
				}
			}
		}
		return result;
	}

	private Collection<Residence> readResidencesFromDate(Date published) {
		Collection<Residence> result = new HashSet<Residence>();
		for (Residence residence : residenceDatabase) {
			if (residence.getPublished().after(published)) {
				try {
					result.add((Residence) residence.clone());
				} catch (CloneNotSupportedException e) {
					e.printStackTrace();
				}
			}
		}
		return result;
	}

	public Collection<Residence> readResidencesCurrentlyPublished() {
		Collection<Residence> result = new HashSet<Residence>();
		Date now = new Date();
		for (Residence residence : residenceDatabase) {
			if (residence.getExpire().after(now)) {
				try {
					result.add((Residence) residence.clone());
				} catch (CloneNotSupportedException e) {
					e.printStackTrace();
				}
			}
		}
		return result;
	}

	public Collection<Residence> readResidencesByAnyKeyword(String[] keywords) {
		Collection<Residence> result = new HashSet<Residence>();
		for (Residence residence : residenceDatabase) {
			if (containsAnyKeyword(residence.getName(), keywords)
					|| containsAnyKeyword(residence.getDescription(), keywords)
					|| containsAnyKeyword(residence.getAddress().toString(), keywords)) {
				try {
					result.add((Residence) residence.clone());
				} catch (CloneNotSupportedException e) {
					e.printStackTrace();
				}
			}
		}
		return result;
	}

	private boolean containsAnyKeyword(String text, String[] keywords) {
		for (String keyword : keywords) {
			if (text.contains(keyword)) {
				return true;
			}
		}
		return false;
	}

	public Collection<Residence> readResidencesByAllKeyword(String[] keywords) {
		Collection<Residence> result = new HashSet<Residence>();
		for (Residence residence : residenceDatabase) {
			boolean isEachKeywordContained = true;
			String text = residence.getName() + " " + residence.getDescription() + " "
					+ residence.getAddress().toString();
			for(String keyword : keywords){
				if(containsAnyKeyword(text, new String[] {keyword}) == false){
					isEachKeywordContained = false;
					break;
				}
			}
			if (isEachKeywordContained) {
				try {
					result.add((Residence) residence.clone());
				} catch (CloneNotSupportedException e) {
					e.printStackTrace();
				}
			}
		}
		return result;
	}

	public void updateResidence(Residence residence) throws ResidenceNotFoundException {
		deleteResidence(residence);
		residenceDatabase.add(residence);
	}

	public void deleteResidence(Residence residence) throws ResidenceNotFoundException {
		if(residenceDatabase.contains(residence) == false){
			throw new ResidenceNotFoundException();
		}
		residenceDatabase.remove(residence);
	}

}
