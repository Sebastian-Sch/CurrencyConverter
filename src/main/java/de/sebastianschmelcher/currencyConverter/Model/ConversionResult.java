package de.sebastianschmelcher.currencyConverter.Model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;

@Entity
public class ConversionResult {
	
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    
    private Date created;

	private Date conversionDate;
	private String sourceCurrencyIsocode;
	private String targetCurrencyIsocode;
	private Double sourceAmount;
	private Double targetAmount;
	@ManyToOne
	private User user;
	
	@PrePersist
	protected void onCreate() {
		setCreated(new Date());
	}

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Date getConversionDate() {
		return conversionDate;
	}
	public void setConversionDate(Date date) {
		this.conversionDate = date;
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
	public Double getSourceAmount() {
		return sourceAmount;
	}
	public void setSourceAmount(Double sourceAmount) {
		this.sourceAmount = sourceAmount;
	}
	public Double getTargetAmount() {
		return targetAmount;
	}
	public void setTargetAmount(Double targetAmount) {
		this.targetAmount = targetAmount;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Date getCreated() {
		return created;
	}
	public void setCreated(Date created) {
		this.created = created;
	}
	
}
