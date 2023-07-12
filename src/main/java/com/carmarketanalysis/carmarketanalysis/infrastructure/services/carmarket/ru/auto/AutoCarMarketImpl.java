package com.carmarketanalysis.carmarketanalysis.infrastructure.services.carmarket.ru.auto;

import com.carmarketanalysis.carmarketanalysis.domain.entities.Car;
import com.carmarketanalysis.carmarketanalysis.domain.valueobjects.Name;
import com.carmarketanalysis.carmarketanalysis.infrastructure.services.carmarket.CarItem;
import com.carmarketanalysis.carmarketanalysis.infrastructure.services.carmarket.CarMarket;
import com.carmarketanalysis.carmarketanalysis.infrastructure.services.carmarket.Filter;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import reactor.core.publisher.Mono;


import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class AutoCarMarketImpl implements CarMarket {
    private static final Logger logger = LoggerFactory.getLogger(AutoCarMarketImpl.class);
    private final AutoScraper autoScraper;
    private final AutoUrlProvider autoUrlProvider;

    @Autowired
    public AutoCarMarketImpl(AutoScraper autoScraper, AutoUrlProvider autoUrlProvider) {
        this.autoScraper = autoScraper;
        this.autoUrlProvider = autoUrlProvider;
    }

    @Override
    public List<Car> findByFilter(Filter filter) {
        List<Car> cars = new ArrayList<>();
        boolean nextPage = true;
        while (nextPage) {
            try {
                var uri = autoUrlProvider.generateByFilter(filter);
                logger.info("Generated URI: {}", uri);
                var scraperResponse = autoScraper.scrape(uri);
                scraperResponse.getItems().forEach(carItem -> {
                    try {
                        cars.add(new Car(new Name(carItem.getTitle()), new URL(carItem.getUrl())));
                    } catch (MalformedURLException e) {
                        throw new RuntimeException(e);
                    }
                });
                nextPage = scraperResponse.isNextPage();
                logger.info("Next page exists: {}", nextPage);
                filter.nextPage();
            } catch (Exception e) {
                nextPage = false;
                logger.error(e.getMessage());
            }
        }

        return cars;
    }
}
