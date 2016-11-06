package de.sebastianschmelcher.currencyConverter.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

import de.sebastianschmelcher.currencyConverter.Model.User;
import de.sebastianschmelcher.currencyConverter.Service.UserService;

@ControllerAdvice
public class UserAdvice {
	@Autowired
	UserService userService;
	
	@ModelAttribute(name = "loggedInUser")
	public boolean isLoggedInUser()
	{
		return userService.getCurrentUser() != null;
	}
	
	@ModelAttribute(name = "currentUser")
	public User getCurrentUser()
	{
		return userService.getCurrentUser();
	}
}
