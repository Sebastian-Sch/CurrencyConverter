package de.sebastianschmelcher.currencyConverter.Converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import de.sebastianschmelcher.currencyConverter.Form.AddressForm;
import de.sebastianschmelcher.currencyConverter.Model.Address;
import de.sebastianschmelcher.currencyConverter.Repositories.CountryRepository;

@Service
public class AddressConverter {
	@Autowired
	CountryRepository countryRepository;
	
	public Address formToAddress(AddressForm form) {
		Address address = new Address();
		address.setCity(form.getCity());
		address.setCountry(countryRepository.findByIsocode(form.getCountry()));
		address.setStreet(form.getStreet());
		address.setZip(form.getZip());
		return address;
	} 
}
