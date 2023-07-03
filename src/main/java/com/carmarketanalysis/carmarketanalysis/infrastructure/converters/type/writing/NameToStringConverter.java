package com.carmarketanalysis.carmarketanalysis.infrastructure.converters.type.writing;

import com.carmarketanalysis.carmarketanalysis.domain.valueobjects.Name;
import org.springframework.core.convert.converter.Converter;
import org.springframework.data.convert.WritingConverter;

@WritingConverter
public class NameToStringConverter implements Converter<Name, String> {
    @Override
    public String convert(Name source) {
        return source.getValue();
    }
}
