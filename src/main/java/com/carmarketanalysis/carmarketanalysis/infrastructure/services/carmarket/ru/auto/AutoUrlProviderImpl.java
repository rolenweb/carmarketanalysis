package com.carmarketanalysis.carmarketanalysis.infrastructure.services.carmarket.ru.auto;

import com.carmarketanalysis.carmarketanalysis.infrastructure.services.carmarket.Filter;
import org.springframework.stereotype.Service;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@Service
public class AutoUrlProviderImpl implements AutoUrlProvider{
    @Override
    public URI generateByFilter(Filter filter) {
        return UriComponentsBuilder.fromUriString("/hyundai/elantra/all/?transmission=AUTOMATIC&year_from=2017&year_to=2018").build().toUri();
    }
}
