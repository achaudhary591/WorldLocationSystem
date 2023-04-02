package net.codejava.world.model;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter(autoApply = true)
public class ContinentConverter implements AttributeConverter<Continent, String> {

	@Override
	public String convertToDatabaseColumn(Continent attribute) {
		return attribute.getName();
	}

	@Override
	public Continent convertToEntityAttribute(String name) {
		return Continent.fromString(name);
	}

	
	
}
