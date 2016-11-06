package de.sebastianschmelcher.currencyConverter.Controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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
    	if(bindingResult.hasErrors()){
    		model.addAttribute("currencies", currencyService.getAllCurrenciesForForm());
    		return "convert";
    	}
    	model.addAttribute("conversionResult",currencyService.convert(conversionForm));
    	return convert(model);
    }
}
