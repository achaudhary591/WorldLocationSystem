package net.codejava.world.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import net.codejava.world.model.Country;

public interface CountryRepository extends JpaRepository<Country, String> {

	@Query(nativeQuery = true, value = "select * from country where lower(name) like %:prefix%")
	List<Country> getCountryByPrefix(@Param("prefix") String prefix);
}
