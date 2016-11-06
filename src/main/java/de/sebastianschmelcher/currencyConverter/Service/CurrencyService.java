package de.sebastianschmelcher.currencyConverter.Service;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.ObjectMapper;

import de.sebastianschmelcher.currencyConverter.Exception.ConversionNotPossibleException;
import de.sebastianschmelcher.currencyConverter.Form.ConversionForm;
import de.sebastianschmelcher.currencyConverter.Mapper.ErrorMessage;
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
	ObjectMapper objectMapper;
	@Autowired
	ConversionResultRepository conversionResultRepository;
	@Autowired
	CurrencyRepository currencyRepository;
	@Autowired
	UserService userService;
	
	DateFormat df = new SimpleDateFormat("YYYY-MM-dd");
	
	public Double get(String isocode) {
        ExchangeRates rates = restTemplate.getForObject("https://openexchangerates.org/api/latest.json?app_id=6c14be99a0db4e249861034380e42631", ExchangeRates.class);
		return rates.getRates().get(isocode).doubleValue();
	}

	public ConversionResult convert(ConversionForm conversionForm) {
		ExchangeRates rates = getRates(conversionForm);
	
		User currentUser = userService.getCurrentUser();
		ConversionResult result = conversionForm.toConversionResult(currentUser, rates.getRates());
		conversionResultRepository.save(result);
		return result;
	}

	private ExchangeRates getRates(ConversionForm conversionForm){
		ExchangeRates rates = null;
		Date date = conversionForm.getDate();
		try{			
			if(date == null)
			{
				rates = restTemplate.getForObject("https://openexchangerates.org/api/latest.json?app_id=6c14be99a0db4e249861034380e42631", ExchangeRates.class);
			}else{
					String url = "https://openexchangerates.org/api/historical/"+ df.format(date) +".json?app_id=6c14be99a0db4e249861034380e42631";
					rates = restTemplate.getForObject(url, ExchangeRates.class);
			}
			
			return rates;
		}catch(RestClientException e){
			if(e instanceof HttpStatusCodeException){
				String responseBody = ((HttpStatusCodeException)e).getResponseBodyAsString();
				try {
					ErrorMessage errorMessage = objectMapper.readValue(responseBody, ErrorMessage.class);
					if("not_available".equals(errorMessage.getMessage())){
						throw new ConversionNotPossibleException("No conversion rates for the requested date. Please try another date.");
					}
				} catch (IOException e1) {
					//Nothing to do here.
				}
			}
			e.printStackTrace();
			throw new ConversionNotPossibleException("Conversion currently not available. Please try agein later.");
		}
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
