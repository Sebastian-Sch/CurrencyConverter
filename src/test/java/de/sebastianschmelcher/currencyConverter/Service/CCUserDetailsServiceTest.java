package de.sebastianschmelcher.currencyConverter.Service;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.fail;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import de.sebastianschmelcher.currencyConverter.Model.User;
import de.sebastianschmelcher.currencyConverter.Repositories.UserRepository;

@RunWith(MockitoJUnitRunner.class)
public class CCUserDetailsServiceTest {

	private static final String PASSWORT = "passwort";

	private static final String USERNAME = "username";

	@Mock
	UserRepository userRepository;
	
	@Mock
	User user;
	
	@InjectMocks
	CCUserDetailsService serviceUnderTest = new CCUserDetailsService();
	
	@Test
	public void testUserNotFound() {
		Mockito.when(userRepository.findByUsername(USERNAME)).thenReturn(null);
		try{			
			serviceUnderTest.loadUserByUsername(USERNAME);
		}catch( UsernameNotFoundException e){
			return;
		}
		fail("must throw UsernameNotFoundException.");
	}

	@Test
	public void testConversionToUserDetails() {
		Mockito.when(userRepository.findByUsername(USERNAME)).thenReturn(user);
		Mockito.when(user.getUsername()).thenReturn(USERNAME);
		Mockito.when(user.getPassword()).thenReturn(PASSWORT);
		
		UserDetails userDetails = serviceUnderTest.loadUserByUsername(USERNAME);
		
		assertThat(userDetails.getUsername(),is(USERNAME));
		assertThat(userDetails.getPassword(),is(PASSWORT));
	}
}
