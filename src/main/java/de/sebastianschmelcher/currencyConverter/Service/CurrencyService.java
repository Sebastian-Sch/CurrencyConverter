package de.sebastianschmelcher.currencyConverter.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import de.sebastianschmelcher.currencyConverter.Form.ConversionForm;
import de.sebastianschmelcher.currencyConverter.Mapper.ExchangeRates;
import de.sebastianschmelcher.currencyConverter.Model.ConversionResult;
import de.sebastianschmelcher.currencyConverter.Model.Currency;
import de.sebastianschmelcher.currencyConverter.Model.User;
import de.sebastianschmelcher.currencyConverter.Repositories.ConversionResultRepository;
import de.sebastianschmelcher.currencyConverter.Repositories.CurrencyRepository;

@Service
public class CurrencyService {
	
	@Autowired
	RestTemplate restTemplate;
	@Autowired
	ConversionResultRepository conversionResultRepository;
	@Autowired
	CurrencyRepository currencyRepository;
	@Autowired
	UserService userService;
	
	public Double get(String isocode) {
        ExchangeRates rates = restTemplate.getForObject("https://openexchangerates.org/api/latest.json?app_id=6c14be99a0db4e249861034380e42631", ExchangeRates.class);
		return rates.getRates().get(isocode).doubleValue();
	}

	public ConversionResult convert(ConversionForm conversionForm) {
		ExchangeRates rates = restTemplate.getForObject("https://openexchangerates.org/api/latest.json?app_id=6c14be99a0db4e249861034380e42631", ExchangeRates.class);
		User currentUser = userService.getCurrentUser();
		ConversionResult result = conversionForm.toConversionResult(currentUser, rates.getRates());
		conversionResultRepository.save(result);
		return result;
	}
	
	public List<ConversionResult> getLastConversionResults(){
		User currentUser = userService.getCurrentUser();
		return currentUser.getConversions();
	}
	
	public Map<String,String> getAllCurrenciesForForm()
	{
		Iterable<Currency> currencies = currencyRepository.findAll();
		Map<String,String> allCurrencies = new HashMap<String,String>();
		
		currencies.forEach( currency -> {
			allCurrencies.put(currency.getIsocode(), currency.getName());
		});
		
		return allCurrencies;	}
}
