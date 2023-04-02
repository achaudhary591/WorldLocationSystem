package net.codejava.world.transform;

import net.codejava.world.dto.CountryLanguageDTO;
import net.codejava.world.model.CountryLanguage;

public class CountryLanguageDtoTransformer implements DtoTransformer<CountryLanguageDTO, CountryLanguage> {

	@Override
	public CountryLanguageDTO transform(CountryLanguage obj) {
		return new CountryLanguageDTO(obj.getCountryLanguageId().getCountryCode(),
				obj.getCountryLanguageId().getLanguage(), obj.getIsOfficial(), obj.getPercentage());
	}

}
