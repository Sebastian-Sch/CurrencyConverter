package de.sebastianschmelcher.currencyConverter.Service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import de.sebastianschmelcher.currencyConverter.Model.Country;
import de.sebastianschmelcher.currencyConverter.Repositories.CountryRepository;

@Service
public class CountryService {
	
	@Autowired
	CountryRepository countryRepository;
	
	public Map<String,String> getAllCountriesForForm(){
		Iterable<Country> countries = countryRepository.findAll();
		Map<String,String> allCountries = new HashMap<String,String>();
		
		countries.forEach( country -> {
			allCountries.put(country.getIsocode(), country.getName());
		});
		
		return allCountries;
	}
}
