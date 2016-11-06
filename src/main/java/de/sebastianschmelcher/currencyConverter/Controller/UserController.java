package de.sebastianschmelcher.currencyConverter.Controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import de.sebastianschmelcher.currencyConverter.Form.LoginForm;
import de.sebastianschmelcher.currencyConverter.Form.UserForm;
import de.sebastianschmelcher.currencyConverter.Service.CountryService;
import de.sebastianschmelcher.currencyConverter.Service.UserService;

@Controller
public class UserController {
	
	@Autowired
	UserService userService;
	@Autowired
	CountryService countryService;
	
	
    @RequestMapping(value="/")
	public String home(Model model) {
        return "home";
    }
    
    @RequestMapping(value="/login")
    public String login(Model model) {
    	model.addAttribute("loginForm", new LoginForm());
    	return "login";
    }

    @RequestMapping(value="/register", method=RequestMethod.GET)
    public String register(Model model) {
    	model.addAttribute("userForm", new UserForm());
    	model.addAttribute("countries", countryService.getAllCountriesForForm());
    	return "register";
    }

    @RequestMapping(value="/register", method=RequestMethod.POST)
    public String registerPost(Model model,
    		@Valid UserForm userForm, BindingResult bindingResult) {
    	if(bindingResult.hasErrors()){
    		model.addAttribute("countries", countryService.getAllCountriesForForm());
    		return "register";
    	}
    	userService.createUserFromForm(userForm);
    	return "registerSuccess";
    }
}
