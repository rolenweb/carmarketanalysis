package com.carmarketanalysis.carmarketanalysis.infrastructure.services.carmarket.ru.auto;

import com.carmarketanalysis.carmarketanalysis.infrastructure.services.carmarket.Filter;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@Service
public class AutoUrlProviderImpl implements AutoUrlProvider{
    @Override
    public URI generateByFilter(Filter filter) {
        var uriBuilder = baseUri(filter);

        return uriBuilder.queryParams(getQueryParams(filter)).build().toUri();
    }

    private UriComponentsBuilder baseUri(Filter filter) {
        if (!filter.isOneYear()) {
            return UriComponentsBuilder.fromHttpUrl(
                    String.format(
                            "https://auto.ru/moskva/cars/%s/%s/used/",
                            filter.getBrand().getName().getValue().toLowerCase(),
                            filter.getModel().getName().getValue().toLowerCase()
                    )
            );
        }
        return UriComponentsBuilder.fromHttpUrl(
                String.format(
                        "https://auto.ru/moskva/cars/%s/%s/%s-year/used/",
                        filter.getBrand().getName().getValue().toLowerCase(),
                        filter.getModel().getName().getValue().toLowerCase(),
                        filter.getYearTo().getValue()
                )
        );

    }

    private MultiValueMap<String, String> getQueryParams(Filter filter) {
        MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<>();
        if (!filter.isOneYear()) {
            if (filter.getYearFrom() != null) {
                queryParams.add("year_from", filter.getYearFrom().toString());
            }
            if (filter.getYearTo() != null) {
                queryParams.add("year_to", filter.getYearTo().toString());
            }
        }
        if (filter.getOdometerFrom() != null) {
            queryParams.add("km_age_from", String.valueOf(filter.getOdometerFrom().getValue()));
        }
        if (filter.getOdometerTo() != null) {
            queryParams.add("km_age_to", String.valueOf(filter.getOdometerTo().getValue()));
        }
        if (filter.getEngineCapacityFrom() != null) {
            queryParams.add("displacement_from", String.valueOf(filter.getEngineCapacityFrom().getValueInMl()));
        }
        if (filter.getEngineCapacityTo() != null) {
            queryParams.add("displacement_to", String.valueOf(filter.getEngineCapacityTo().getValueInMl()));
        }
        if (filter.getTransmission() != null) {
            queryParams.add("transmission", filter.getTransmission().getValue().toUpperCase());
        }
        if (filter.getPage() > 1) {
            queryParams.add("page", String.valueOf(filter.getPage()));
        }
        return queryParams;
    }

}
