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

        return uriBuilder.build().toUri();
    }

    private UriComponentsBuilder baseUri(Filter filter) {
        if (filter.getYearFrom() == null || filter.getYearTo() == null || !filter.getYearFrom().equals(filter.getYearTo())) {
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
        if (filter.getOdometerFrom() != null) {
            queryParams.add("km_age_from", String.valueOf(filter.getOdometerFrom().getValue()));
        }
        if (filter.getOdometerTo() != null) {
            queryParams.add("km_age_to", String.valueOf(filter.getOdometerTo().getValue()));
        }
        if (filter.getEngineCapacityFrom() != null) {
            queryParams.add("displacement_from", String.valueOf(filter.getEngineCapacityFrom().getValue()));
        }
        if (filter.getEngineCapacityTo() != null) {
            queryParams.add("displacement_to", String.valueOf(filter.getEngineCapacityTo().getValue()));
        }
        return queryParams;
    }

}
