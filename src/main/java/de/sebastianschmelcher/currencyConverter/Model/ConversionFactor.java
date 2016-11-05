package de.sebastianschmelcher.currencyConverter.Model;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

public class ConversionFactor {
	private String isocode;
	private Double factor;

	public String getIsocode() {
		return isocode;
	}
	public void setIsocode(String isocode) {
		this.isocode = isocode;
	}
	public Double getFactor() {
		return factor;
	}
	public void setFactor(Double factor) {
		this.factor = factor;
	}
}