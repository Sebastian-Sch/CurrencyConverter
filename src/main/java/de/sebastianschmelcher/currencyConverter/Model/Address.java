package de.sebastianschmelcher.currencyConverter.Model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Address {
	
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    
	private String street;
	private String zip;
	private String city;
	
	@OneToOne(cascade = CascadeType.ALL)
	private Country country;
	@OneToOne(cascade = CascadeType.ALL)
	private User user;
	
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
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
	public Country getCountry() {
		return country;
	}
	public void setCountry(Country country) {
		this.country = country;
	}
	
}
