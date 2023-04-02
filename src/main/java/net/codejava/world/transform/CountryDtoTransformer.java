package net.codejava.world.transform;

import net.codejava.world.dto.CountryDTO;
import net.codejava.world.model.Country;

public class CountryDtoTransformer implements DtoTransformer<CountryDTO, Country> {

	@Override
	public CountryDTO transform(Country obj) {
		return new CountryDTO(obj.getCode(), obj.getName(), obj.getContinent(), obj.getRegion(), obj.getSurfaceArea(),
				obj.getIndepYear(), obj.getPopulation(), obj.getLifeExpectancy(), obj.getGnp(), obj.getGnpOld(),
				obj.getLocalName(), obj.getGovernmentForm(), obj.getHeadOfState(), obj.getCapital(), obj.getCode2());
	}

}
