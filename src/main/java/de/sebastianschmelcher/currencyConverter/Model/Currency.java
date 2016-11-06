package de.sebastianschmelcher.currencyConverter.Model;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Currency {

	@Id
	private String isocode;
	private String name;
	
	public String getIsocode() {
		return isocode;
	}
	public void setIsocode(String isocode) {
		this.isocode = isocode;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}