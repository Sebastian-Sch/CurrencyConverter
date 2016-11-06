package de.sebastianschmelcher.currencyConverter.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import de.sebastianschmelcher.currencyConverter.Form.UserForm;
import de.sebastianschmelcher.currencyConverter.Model.User;
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
	
	public User getCurrentUser()
	{
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		Object principal = auth.getPrincipal();
		if(principal instanceof org.springframework.security.core.userdetails.User)
		{
			org.springframework.security.core.userdetails.User user = (org.springframework.security.core.userdetails.User)principal;
			return userRepository.findByUsername(user.getUsername());
		}
		return null;
	}
}
