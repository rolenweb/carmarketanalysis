package com.carmarketanalysis.carmarketanalysis.infrastructure.services.carmarket.ru.auto;

import com.carmarketanalysis.carmarketanalysis.infrastructure.services.carmarket.Filter;

import java.net.URI;

public interface AutoUrlProvider {
    URI generateByFilter(Filter filter);
}
