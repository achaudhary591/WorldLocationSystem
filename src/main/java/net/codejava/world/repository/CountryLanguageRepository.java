package net.codejava.world.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import net.codejava.world.model.CountryLanguage;
import net.codejava.world.model.CountryLanguageId;

public interface CountryLanguageRepository extends JpaRepository<CountryLanguage, String> {

	@Query(nativeQuery = true, value = "select * from countrylanguage where lower(language) like %:prefix%")
	List<CountryLanguage> getCountryLanguageByPrefix(@Param("prefix") String prefix);

	Optional<CountryLanguage> findByCountryLanguageId(CountryLanguageId countryLanguageId);
}
