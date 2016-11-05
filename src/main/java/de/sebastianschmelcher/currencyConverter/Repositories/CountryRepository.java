package de.sebastianschmelcher.currencyConverter.Repositories;

import org.springframework.data.repository.CrudRepository;

import de.sebastianschmelcher.currencyConverter.Model.Country;

public interface CountryRepository extends CrudRepository<Country, Long> {
	public Country findByIsocode(String isocode);
}