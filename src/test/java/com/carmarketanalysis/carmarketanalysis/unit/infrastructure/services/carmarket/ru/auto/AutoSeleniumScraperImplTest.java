package com.carmarketanalysis.carmarketanalysis.unit.infrastructure.services.carmarket.ru.auto;

import com.carmarketanalysis.carmarketanalysis.infrastructure.services.carmarket.CarItem;
import com.carmarketanalysis.carmarketanalysis.infrastructure.services.carmarket.ru.auto.AutoSeleniumScraperImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.util.UriComponentsBuilder;
import java.net.URI;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class AutoSeleniumScraperImplTest {

    @Autowired
    AutoSeleniumScraperImpl autoSeleniumScraper;
    @Test
    public void testShouldScrapeReturnResponse() {
        var scraperResponse = autoSeleniumScraper.scrape(firstPageUri());
        var carItem = scraperResponse.getItems().get(0);
        assertEquals(37, scraperResponse.getTotal());
        assertTrue(scraperResponse.isNextPage());
        assertInstanceOf(CarItem.class, carItem);
        assertEquals("Hyundai Elantra VII (CN7)", carItem.getTitle());
        assertEquals("https://auto.ru/cars/used/sale/hyundai/elantra/1119407526-f0fdf550/", carItem.getUrl());
        assertEquals("2 228 000 ₽", carItem.getPrice());
        assertEquals("36 427 км", carItem.getKmAge());
        assertEquals("2021", carItem.getYear());
    }

    @Test
    public void testShouldScrapeLastPageUrlReturnResponse() {
        var scraperResponse = autoSeleniumScraper.scrape(lastPageUri());
        assertEquals(37, scraperResponse.getTotal());
        assertFalse(scraperResponse.isNextPage());
    }

    private URI firstPageUri() {
        return UriComponentsBuilder
                .fromUriString("http://wiremock-server:8080/auto_list")
                .build()
                .toUri();
    }
    private URI lastPageUri() {
        return UriComponentsBuilder
                .fromUriString("http://wiremock-server:8080/auto_list_page_2")
                .build()
                .toUri();
    }
}
