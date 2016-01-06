package hu.iit.uni.miskolc.iit.webtech.real.estate.service;

import java.util.Collection;
import java.util.Currency;
import java.util.Date;

import hu.iit.uni.miskolc.iit.webtech.real.estate.model.Price;
import hu.iit.uni.miskolc.iit.webtech.real.estate.model.Residence;

public interface ResidenceSearchService {

	public Collection<Residence> searchAll();
	public Collection<Residence> search();
	public Collection<Residence> search(String address);
	public Collection<Residence> search(Price maximumPrice);
	public Collection<Residence> search(Currency currency);
	public Collection<Residence> search(Date publish, Date expire);
}
