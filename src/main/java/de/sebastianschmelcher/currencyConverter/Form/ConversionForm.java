package de.sebastianschmelcher.currencyConverter.Form;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

import de.sebastianschmelcher.currencyConverter.Model.ConversionResult;
import de.sebastianschmelcher.currencyConverter.Model.User;


public class ConversionForm {
    
	@DateTimeFormat(pattern = "dd/MM/YYYY")
	@Past
	private Date date;
	@Size(min = 3, max =3)
	private String sourceCurrencyIsocode;
	@Size(min = 3, max =3)
	private String targetCurrencyIsocode;
	@NotNull
	private Double amount;
	
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getSourceCurrencyIsocode() {
		return sourceCurrencyIsocode;
	}
	public void setSourceCurrencyIsocode(String sourceCurrencyIsocode) {
		this.sourceCurrencyIsocode = sourceCurrencyIsocode;
	}
	public String getTargetCurrencyIsocode() {
		return targetCurrencyIsocode;
	}
	public void setTargetCurrencyIsocode(String targetCurrencyIsocode) {
		this.targetCurrencyIsocode = targetCurrencyIsocode;
	}
	public Double getAmount() {
		return amount;
	}
	public void setAmount(Double amount) {
		this.amount = amount;
	}
	
	public ConversionResult toConversionResult(User user, Map<String,BigDecimal> rates)
	{
		ConversionResult result = new ConversionResult();
		result.setDate(this.getDate() != null ? this.getDate() : new Date());
		result.setSourceAmount(this.getAmount());
		
		if(rates.containsKey(this.getSourceCurrencyIsocode()) && rates.containsKey(this.getTargetCurrencyIsocode()))
		{
			BigDecimal sourceFactor = rates.get(getSourceCurrencyIsocode());
			BigDecimal targetFactor = rates.get(getTargetCurrencyIsocode());
			BigDecimal factor = targetFactor.setScale(5).divide(sourceFactor, BigDecimal.ROUND_HALF_UP);
			result.setTargetAmount(BigDecimal.valueOf(this.getAmount()).multiply(factor).setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue());
		}
		
		result.setSourceCurrencyIsocode(this.getSourceCurrencyIsocode());
		result.setTargetCurrencyIsocode(this.getTargetCurrencyIsocode());
		
		result.setUser(user);
		return result;
	}
}
