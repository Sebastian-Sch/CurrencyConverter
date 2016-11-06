package de.sebastianschmelcher.currencyConverter.Form;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Size;

import org.springframework.beans.factory.annotation.Autowired;

import de.sebastianschmelcher.currencyConverter.Model.Address;
import de.sebastianschmelcher.currencyConverter.Repositories.CountryRepository;


public class AddressForm {
	@Autowired
	CountryRepository countryRepository;
    
    @Size(min=2)
	private String street;
	private String zip;
	private String city;
	private String country;
	
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getZip() {
		return zip;
	}
	public void setZip(String zip) {
		this.zip = zip;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	
	public Address toAddress() {
		Address address = new Address();
		address.setCity(this.getCity());
		address.setCountry(countryRepository.findByIsocode(this.getCountry()));
		address.setStreet(this.getStreet());
		address.setZip(this.getZip());
		return address;
	} 
}
