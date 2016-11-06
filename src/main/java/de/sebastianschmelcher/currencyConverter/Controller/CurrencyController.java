package de.sebastianschmelcher.currencyConverter.Controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.client.HttpClientErrorException;

import de.sebastianschmelcher.currencyConverter.Form.ConversionForm;
import de.sebastianschmelcher.currencyConverter.Service.CurrencyService;

@Controller
public class CurrencyController {

	@Autowired
	CurrencyService currencyService;

	@RequestMapping(value="/convert", method=RequestMethod.GET)
	public String convert(Model model) {
		model.addAttribute("conversionForm",new ConversionForm());
		model.addAttribute("lastConversionResults",currencyService.getLastConversionResults());
		model.addAttribute("currencies", currencyService.getAllCurrenciesForForm());
		return "convert";
	}
	
    @RequestMapping(value="/convert", method=RequestMethod.POST)
    public String registerPost(Model model,
    		@Valid ConversionForm conversionForm, BindingResult bindingResult) {
    	model.addAttribute("currencies", currencyService.getAllCurrenciesForForm());
    	model.addAttribute("lastConversionResults",currencyService.getLastConversionResults());
    	if(bindingResult.hasErrors()){
    		return "convert";
    	}
    	try{
    		model.addAttribute("conversionResult",currencyService.convert(conversionForm));
    	}catch( HttpClientErrorException e)
    	{
    		model.addAttribute("errorMessage", "Either currency conversion factors are currently not available, or the requested conversion cannot be executed.");
    		return "convert";
    	}
    	return "convert";
    }
}
