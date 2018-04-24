package com.wyden.nis.core.model.commons.converter;

import javax.persistence.AttributeConverter;

public class BooleanConverter implements AttributeConverter<Boolean, String> {

	@Override
	public String convertToDatabaseColumn(Boolean attribute) {
		if (attribute == null)
			return null;
		return (attribute) ? "1" : "0";
	}

	@Override
	public Boolean convertToEntityAttribute(String dbData) {
		return "1".equals(dbData) || "S".equalsIgnoreCase(dbData);
	}

}
