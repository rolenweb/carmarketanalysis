package com.carmarketanalysis.carmarketanalysis.unit.infrastructure.services.carmarket.ru.auto;

import com.carmarketanalysis.carmarketanalysis.domain.entities.Brand;
import com.carmarketanalysis.carmarketanalysis.domain.entities.Model;
import com.carmarketanalysis.carmarketanalysis.domain.valueobjects.Name;
import com.carmarketanalysis.carmarketanalysis.infrastructure.services.carmarket.Filter;
import com.carmarketanalysis.carmarketanalysis.infrastructure.services.carmarket.ru.auto.AutoUrlProviderImpl;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.Year;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class AutoUrlProviderImplTest {
    @Test
    public void testShouldGenerateBaseUrlByFilterWithoutYear() {
        var brand = new Brand(new Name("Kia"));
        var model = new Model(new Name("Soul"));
        var filter = new Filter(1, brand, model);
        var urlProvider = new AutoUrlProviderImpl();
        var expectedUrl = "https://auto.ru/moskva/cars/kia/soul/used/";
        var actualUrl = urlProvider.generateByFilter(filter).toString();
        assertEquals(expectedUrl, actualUrl);
    }

    @Test
    public void testShouldGenerateBaseUrlByFilterWithYear() {
        var brand = new Brand(new Name("Kia"));
        var model = new Model(new Name("Soul"));
        var yearFrom = Year.parse("2012");
        var yearTo = Year.parse("2012");
        var filter = new Filter(1, brand, model);
        filter.setYearFrom(yearFrom);
        filter.setYearTo(yearTo);
        var urlProvider = new AutoUrlProviderImpl();
        var expectedUrl = "https://auto.ru/moskva/cars/kia/soul/2012-year/used/";
        var actualUrl = urlProvider.generateByFilter(filter).toString();
        assertEquals(expectedUrl, actualUrl);
    }
}
