package de.sebastianschmelcher.currencyConverter.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import de.sebastianschmelcher.currencyConverter.Model.User;
import de.sebastianschmelcher.currencyConverter.Repositories.UserRepository;

@Service("userService")
public class UserService {
	
	@Autowired
	UserRepository userRepository;
	@Autowired
	PasswordEncoder passwordEncoder;
	
	public User createUser(String username, String password){
		return userRepository.save(new User(username,passwordEncoder.encode(password)));	
	}
}
