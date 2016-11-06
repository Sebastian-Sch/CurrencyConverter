package de.sebastianschmelcher.currencyConverter.Repositories;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;

import de.sebastianschmelcher.currencyConverter.Model.Country;

public interface CountryRepository extends PagingAndSortingRepository<Country, Long> {
	public Country findByIsocode(String isocode);
	
	public List<Country> findAllByOrderByNameAsc();
}