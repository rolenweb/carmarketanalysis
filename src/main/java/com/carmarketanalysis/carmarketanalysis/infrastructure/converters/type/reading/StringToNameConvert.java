package com.carmarketanalysis.carmarketanalysis.infrastructure.converters.type.reading;

import com.carmarketanalysis.carmarketanalysis.domain.valueobjects.Name;
import org.springframework.core.convert.converter.Converter;
import org.springframework.data.convert.ReadingConverter;

@ReadingConverter
public class StringToNameConvert implements Converter<String, Name> {
    @Override
    public Name convert(String source) {
        return new Name(source);
    }
}
