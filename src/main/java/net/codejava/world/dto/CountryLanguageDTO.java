package net.codejava.world.dto;

import net.codejava.world.model.Constants;

public class CountryLanguageDTO extends BaseDTO {

	private String countryCode;
	private String language;
	private String isOfficial;
	private Double percentage;

	public CountryLanguageDTO(String countryCode, String language, String isOfficial, Double percentage) {
		super(Constants.URL_LANGUAGE + String.join("_", countryCode, language));
		this.countryCode = countryCode;
		this.language = language;
		this.isOfficial = isOfficial;
		this.percentage = percentage;
	}

	public String getCountryCode() {
		return countryCode;
	}

	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
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
