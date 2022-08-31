package com.example.galeria.util;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.time.Year;

@Converter(autoApply = true)
public class YearConverter implements AttributeConverter<Year, Integer> {

    @Override
    public Integer convertToDatabaseColumn(Year attribute) {
        return attribute.getValue();
    }

    @Override
    public Year convertToEntityAttribute(Integer dbValue) {
        return Year.of(dbValue);
    }
}
