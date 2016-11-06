package de.sebastianschmelcher.currencyConverter.Converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import de.sebastianschmelcher.currencyConverter.Form.AddressForm;
import de.sebastianschmelcher.currencyConverter.Form.UserForm;
import de.sebastianschmelcher.currencyConverter.Model.User;

@Service
public class UserConverter {
	@Autowired
	AddressConverter addressConverter;
	@Autowired
	PasswordEncoder passwordEncoder;
	
	public User formToUser(UserForm form) {
		User user = new User();
		AddressForm addressForm = form.getAddress();
		if (addressForm != null) {
			user.setAddress(addressConverter.formToAddress(addressForm));
		}
		user.setDateOfBirth(form.getDateOfBirth());
		user.setEmail(form.getEmail());
		user.setFirstname(form.getFirstname());
		user.setLastname(form.getLastname());
		user.setPassword(passwordEncoder.encode(form.getPassword()));
		user.setUsername(form.getUsername());
		return user;
	}
}
