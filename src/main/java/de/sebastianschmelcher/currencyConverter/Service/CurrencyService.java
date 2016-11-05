package de.sebastianschmelcher.currencyConverter.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import de.sebastianschmelcher.currencyConverter.Model.ExchangeRates;

@Service
public class CurrencyService {
	
	@Autowired
	RestTemplate restTemplate;
	
	public Double get(String isocode) {
        ExchangeRates rates = restTemplate.getForObject("https://openexchangerates.org/api/latest.json?app_id=6c14be99a0db4e249861034380e42631", ExchangeRates.class);
		return rates.getRates().get(isocode);
	}
}
