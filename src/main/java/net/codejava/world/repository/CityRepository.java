package net.codejava.world.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import net.codejava.world.model.City;

public interface CityRepository extends JpaRepository<City, Long> {

	@Query(nativeQuery = true, value = "select * from city where lower(name) like %:prefix%")
	List<City> getCitiesByPrefix(@Param("prefix") String prefix);
}
