package net.codejava.world.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.codejava.world.dto.BaseDTO;
import net.codejava.world.dto.CityDTO;
import net.codejava.world.dto.CountryDTO;
import net.codejava.world.dto.CountryLanguageDTO;
import net.codejava.world.model.City;
import net.codejava.world.model.Constants;
import net.codejava.world.model.Country;
import net.codejava.world.model.CountryLanguage;
import net.codejava.world.model.CountryLanguageId;
import net.codejava.world.repository.CityRepository;
import net.codejava.world.repository.CountryLanguageRepository;
import net.codejava.world.repository.CountryRepository;
import net.codejava.world.transform.CityDtoTransformer;
import net.codejava.world.transform.CountryDtoTransformer;
import net.codejava.world.transform.CountryLanguageDtoTransformer;

@Service
public class WorldService {

	private final CountryRepository countryRepository;
	private final CountryLanguageRepository countryLangRepository;
	private final CityRepository cityRepository;
	private final CountryDtoTransformer countryDtoTransformer;
	private final CityDtoTransformer cityDtoTransformer;
	private final CountryLanguageDtoTransformer countryLanguageDtoTransformer;

	public WorldService(@Autowired CountryRepository countryRepository, 
						@Autowired CityRepository cityRepository,
						@Autowired CountryLanguageRepository countryLanguageRepository) {
		this.countryRepository = countryRepository;
		this.cityRepository = cityRepository;
		this.countryLangRepository = countryLanguageRepository;
		this.cityDtoTransformer = new CityDtoTransformer();
		this.countryDtoTransformer = new CountryDtoTransformer();
		this.countryLanguageDtoTransformer = new CountryLanguageDtoTransformer();
	}

	public List<CityDTO> findAllCities() {
		return cityRepository.findAll().stream().map(cityDtoTransformer::transform).collect(Collectors.toList());
	}

	public Optional<CityDTO> findCityById(Long id) {
		return cityRepository.findById(id).map(cityDtoTransformer::transform);
	}

	public Optional<CountryDTO> findCountryById(String code) {
		return countryRepository.findById(code).map(countryDtoTransformer::transform);
	}

	public Optional<CountryLanguageDTO> findLanguageById(String langCode) {
		String[] codeLangSplit = langCode.split("_");
		return countryLangRepository.findByCountryLanguageId(new CountryLanguageId(codeLangSplit[0], codeLangSplit[1])).map(countryLanguageDtoTransformer::transform);
	}

	public List<BaseDTO> getSuggestions(String prefix) {
		List<BaseDTO> suggestions = new ArrayList<>();
		suggestions.addAll(suggestCities(prefix));
		suggestions.addAll(suggestCountry(prefix));
		suggestions.addAll(suggestCountryLang(prefix));
		return suggestions;
	}

	public List<CityDTO> suggestCities(String prefix) {
		return cityRepository.getCitiesByPrefix(prefix).stream().map(cityDtoTransformer::transform).collect(Collectors.toList());
	}

	public List<CountryDTO> suggestCountry(String prefix) {
		return countryRepository.getCountryByPrefix(prefix).stream().map(countryDtoTransformer::transform).collect(Collectors.toList());
	}

	public List<CountryLanguageDTO> suggestCountryLang(String prefix) {
		return countryLangRepository.getCountryLanguageByPrefix(prefix).stream().map(countryLanguageDtoTransformer::transform).collect(Collectors.toList());
	}

}
