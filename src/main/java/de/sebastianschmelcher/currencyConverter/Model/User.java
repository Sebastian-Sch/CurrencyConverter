package de.sebastianschmelcher.currencyConverter.Model;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Transient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;

@Entity
public class User {
	
	@Transient
	@Autowired
	PasswordEncoder passwordEncoder;
	
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    
    private String firstname;
    private String lastname;
    private String email;
    private Date dateOfBirth;
    private String username;
    private String password;
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "user", targetEntity = ConversionResult.class)
    private List<ConversionResult> conversions;
	@OneToOne(cascade = CascadeType.ALL)
    private Address address;
       
    public List<ConversionResult> getConversions() {
    	return conversions;
    }
    public void setConversions(List<ConversionResult> conversions) {
    	this.conversions = conversions;
    }
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String fisrtname) {
		this.firstname = fisrtname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Date getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = passwordEncoder.encode(password);
	}
}
