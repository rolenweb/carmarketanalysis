package com.carmarketanalysis.carmarketanalysis.config;

import com.carmarketanalysis.carmarketanalysis.infrastructure.converters.type.reading.StringToNameConvert;
import com.carmarketanalysis.carmarketanalysis.infrastructure.converters.type.writing.NameToStringConverter;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jdbc.repository.config.AbstractJdbcConfiguration;

import java.util.Arrays;
import java.util.List;

@Configuration
public class JdbcConfiguration extends AbstractJdbcConfiguration {
    @Override
    protected List<?> userConverters() {
        return Arrays.asList(
                new NameToStringConverter(),
                new StringToNameConvert()
        );
    }
}
