package de.sebastianschmelcher.currencyConverter.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import de.sebastianschmelcher.currencyConverter.Form.AddressForm;
import de.sebastianschmelcher.currencyConverter.Form.UserForm;
import de.sebastianschmelcher.currencyConverter.Model.Address;
import de.sebastianschmelcher.currencyConverter.Model.User;
import de.sebastianschmelcher.currencyConverter.Repositories.CountryRepository;
import de.sebastianschmelcher.currencyConverter.Repositories.UserRepository;

@Service
public class UserService {
	
	@Autowired
	UserRepository userRepository;
	@Autowired
	PasswordEncoder passwordEncoder;

	public User createUserFromForm(UserForm userForm) {
		return userRepository.save(userForm.toUser());	
	}
}
