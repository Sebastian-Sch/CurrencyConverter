package de.sebastianschmelcher.currencyConverter.Model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class User {
	
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    
    private String firstname;
    private String lastname;
    private String email;
    private Date dateOfBirth;
    private String username;
    private String password;
    
    @OneToOne(cascade = CascadeType.ALL)
    private Address address;
    
    public User(){
    }
    
    public User(String username, String password){//TODO: remove if unused
    	this.username = username;
    	this.password = password;
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
		this.password = password;
	}
}
