package de.sebastianschmelcher.currencyConverter.Repositories;

import org.springframework.data.repository.CrudRepository;

import de.sebastianschmelcher.currencyConverter.Model.ConversionResult;

public interface ConversionResultRepository extends CrudRepository<ConversionResult, Long> {
	
}