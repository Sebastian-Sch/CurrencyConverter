package de.sebastianschmelcher.currencyConverter;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import de.sebastianschmelcher.currencyConverter.Repositories.CurrencyRepository;

@Component
public class InitializeCurrenciesRunner implements CommandLineRunner {

	@Autowired
	RestTemplate restTemplate;
	@Autowired
	CurrencyRepository currencyRepository;
	
	
    public void run(String... args) {
    	Map<String,String> currencies = restTemplate.getForObject("https://openexchangerates.org/api/currencies.json", Map.class);
    	currencies.forEach((isocode,name) -> {
    		de.sebastianschmelcher.currencyConverter.Model.Currency currencyModel = new de.sebastianschmelcher.currencyConverter.Model.Currency();
    		currencyModel.setIsocode(isocode);
    		currencyModel.setName(name);
    		currencyRepository.save(currencyModel);    		
    	});
    }

}