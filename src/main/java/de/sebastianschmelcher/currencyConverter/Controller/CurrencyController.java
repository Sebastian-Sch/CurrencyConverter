package de.sebastianschmelcher.currencyConverter.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import de.sebastianschmelcher.currencyConverter.Service.CurrencyService;

@Controller
public class CurrencyController {

	@Autowired
	CurrencyService currencyService;
	
    @RequestMapping("/convert")
    public String convert(Model model) {
    	model.addAttribute("factor",currencyService.get("EUR"));
    	return "convert";
    }
}
