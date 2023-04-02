package net.codejava.world.model;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "countrylanguage")
public class CountryLanguage {

	@EmbeddedId
	private CountryLanguageId countryLanguageId;

	@Column
	private String isOfficial;

	@Column
	private Double percentage;

	public CountryLanguageId getCountryLanguageId() {
		return countryLanguageId;
	}

	public void setCountryLanguageId(CountryLanguageId countryLanguageId) {
		this.countryLanguageId = countryLanguageId;
	}

	public String getIsOfficial() {
		return isOfficial;
	}

	public void setIsOfficial(String isOfficial) {
		this.isOfficial = isOfficial;
	}

	public Double getPercentage() {
		return percentage;
	}

	public void setPercentage(Double percentage) {
		this.percentage = percentage;
	}

}
