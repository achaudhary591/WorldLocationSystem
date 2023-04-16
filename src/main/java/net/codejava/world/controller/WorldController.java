package net.codejava.world.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import net.codejava.world.dto.BaseDTO;
import net.codejava.world.dto.CityDTO;
import net.codejava.world.dto.CountryDTO;
import net.codejava.world.dto.CountryLanguageDTO;
import net.codejava.world.model.City;
import net.codejava.world.model.Country;
import net.codejava.world.model.CountryLanguage;
import net.codejava.world.service.WorldService;

@RestController
@RequestMapping("/world")
public class WorldController {

	@Autowired
	private WorldService worldService;

	@GetMapping("/city/{id}")
	public Optional<CityDTO> getCityById(@PathVariable Long id) {
		return worldService.findCityById(id);
	}

	@GetMapping("/country/{id}")
	public Optional<CountryDTO> getCountryById(@PathVariable String code) {
		return worldService.findCountryById(code);
	}

	@GetMapping("/language/{id}")
	public Optional<CountryLanguageDTO> getLanguageById(@PathVariable String langCode) {
		return worldService.findLanguageById(langCode);
	}

	@GetMapping("/suggests")
	public List<BaseDTO> suggest(@RequestParam("prefix") String prefix) {
		return worldService.getSuggestions(prefix.toLowerCase());
	}
}
