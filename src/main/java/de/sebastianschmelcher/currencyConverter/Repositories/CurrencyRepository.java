package de.sebastianschmelcher.currencyConverter.Repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import de.sebastianschmelcher.currencyConverter.Model.Currency;

public interface CurrencyRepository extends CrudRepository<Currency, Long> {
	public Currency findByIsocode(String isocode);
	
	public List<Currency> findAllByOrderByNameAsc();

}