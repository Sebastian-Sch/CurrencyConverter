package de.sebastianschmelcher.currencyConverter.Service;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import de.sebastianschmelcher.currencyConverter.Model.ExchangeRates;

@Service
public class CurrencyService {
	public String get(String isocode) {
		RestTemplate restTemplate = new RestTemplate();
        ExchangeRates rates = restTemplate.getForObject("https://openexchangerates.org/api/latest.json?app_id=6c14be99a0db4e249861034380e42631 ", ExchangeRates.class);
		return rates.getRates().get(isocode);
	}
}
