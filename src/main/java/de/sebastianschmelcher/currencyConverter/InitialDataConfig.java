package de.sebastianschmelcher.currencyConverter;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import de.sebastianschmelcher.currencyConverter.Model.Country;
import de.sebastianschmelcher.currencyConverter.Repositories.CountryRepository;

public class InitialDataConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	CountryRepository countryRepository;
	
	@Bean
	public void initialCountries(){
		Country countryDE = new Country();
		Country countryFR = new Country();
		Country countryGB = new Country();
		
		List<Country> initialCountries = new ArrayList<Country>();
		initialCountries.add(countryDE);
		initialCountries.add(countryFR);
		initialCountries.add(countryGB);
		countryRepository.save(initialCountries);
    }
}