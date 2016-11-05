package de.sebastianschmelcher.currencyConverter.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import de.sebastianschmelcher.currencyConverter.Model.ConversionFactor;
import de.sebastianschmelcher.currencyConverter.Service.CurrencyService;

@Controller
public class CurrencyController {

	@Autowired
	CurrencyService currencyService;

	@RequestMapping("/convert")
	public String convert(Model model) {
		return "convert";
	}

	@RequestMapping(value = "/conversionFactor/{isocode}",produces=MediaType.APPLICATION_JSON_VALUE )
    public @ResponseBody ConversionFactor conversionFactor( @PathVariable String isocode) {
		ConversionFactor factor = new ConversionFactor();
		factor.setIsocode(isocode);
		factor.setFactor(currencyService.get(isocode));
    	return factor;
    }

}
