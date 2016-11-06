package de.sebastianschmelcher.currencyConverter.Form;

import java.util.Date;

import javax.validation.Valid;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.springframework.format.annotation.DateTimeFormat;

public class UserForm {
	private static final String SIZE_MIN_2_Message = "must have min. 2 char.";

	@Size(min = 2, message = SIZE_MIN_2_Message)
	private String firstname;
	@Size(min = 2, message = SIZE_MIN_2_Message)
	private String lastname;
	@Email
	private String email;
	@Past
	@DateTimeFormat(pattern = "dd/MM/YYYY")
	private Date dateOfBirth;
	@Size(min = 2, message = SIZE_MIN_2_Message)
	private String username;
	@Size(min = 2, message = SIZE_MIN_2_Message)
	private String password;

	@Valid
	private AddressForm address;

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

	public AddressForm getAddress() {
		return address;
	}

	public void setAddress(AddressForm address) {
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
