package net.codejava.world.transform;

import net.codejava.world.dto.CityDTO;
import net.codejava.world.model.City;

public class CityDtoTransformer implements DtoTransformer<CityDTO, City>{

	@Override
	public CityDTO transform(City city) {
		return new CityDTO(city.getId(), city.getName(), city.getCountryCode(), city.getDistrict(), city.getPopulation());
	}

}
