package com.carmarketanalysis.carmarketanalysis.infrastructure.services.carmarket.ru.auto;

import com.carmarketanalysis.carmarketanalysis.domain.entities.Car;
import com.carmarketanalysis.carmarketanalysis.infrastructure.services.carmarket.CarItem;
import com.carmarketanalysis.carmarketanalysis.infrastructure.services.carmarket.ScraperResponse;
import reactor.core.publisher.Mono;

import java.net.URI;
import java.util.List;
import java.util.Optional;

public interface AutoScraper {
    ScraperResponse scrape(URI uri);
}
