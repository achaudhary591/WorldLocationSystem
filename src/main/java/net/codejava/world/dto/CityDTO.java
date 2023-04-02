package net.codejava.world.dto;

import net.codejava.world.model.Constants;

public class CityDTO extends BaseDTO{

	private static final long serialVersionUID = -6800823868391549229L;

	private Long id;

	private String name;

	private String countryCode;

	private String district;

	private Integer population;


	public CityDTO(Long id, String name, String countryCode, String district, Integer population) {
		super(Constants.URL_CITY+id);
		this.id = id;
		this.name = name;
		this.countryCode = countryCode;
		this.district = district;
		this.population = population;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getCountryCode() {
		return countryCode;
	}


	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}


	public String getDistrict() {
		return district;
	}


	public void setDistrict(String district) {
		this.district = district;
	}


	public Integer getPopulation() {
		return population;
	}


	public void setPopulation(Integer population) {
		this.population = population;
	}


	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
}
