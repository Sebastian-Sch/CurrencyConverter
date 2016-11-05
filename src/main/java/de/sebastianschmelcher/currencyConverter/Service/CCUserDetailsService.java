package de.sebastianschmelcher.currencyConverter.Service;

import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import de.sebastianschmelcher.currencyConverter.Repositories.UserRepository;

@Service("userDetailsService")
public class CCUserDetailsService implements UserDetailsService {

	@Autowired
	private UserRepository userRepository;

	@Transactional(readOnly=true)
	@Override
	public UserDetails loadUserByUsername(final String username)
		throws UsernameNotFoundException {

		de.sebastianschmelcher.currencyConverter.Model.User user = userRepository.findByUsername(username);
		if(user == null) 
		{
			throw new UsernameNotFoundException(username);
		}
		return convertToUserDetails(user);

	}

	private User convertToUserDetails(de.sebastianschmelcher.currencyConverter.Model.User user) {
		return new User(user.getUsername(), user.getPassword(),
			true, true, true, true, Collections.<GrantedAuthority>emptyList());
	}

}