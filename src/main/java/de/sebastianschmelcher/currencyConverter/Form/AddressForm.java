package de.sebastianschmelcher.currencyConverter.Form;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class AddressForm {
    
    @Size(min=2)
	private String street;
    @NotNull
	private String zip;
    @NotNull
	private String city;
    @NotNull
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
}
