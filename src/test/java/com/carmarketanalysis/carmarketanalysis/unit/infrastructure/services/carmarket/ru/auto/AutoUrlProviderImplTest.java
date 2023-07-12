package com.carmarketanalysis.carmarketanalysis.unit.infrastructure.services.carmarket.ru.auto;

import com.carmarketanalysis.carmarketanalysis.domain.entities.Brand;
import com.carmarketanalysis.carmarketanalysis.domain.entities.Model;
import com.carmarketanalysis.carmarketanalysis.domain.valueobjects.EngineCapacity;
import com.carmarketanalysis.carmarketanalysis.domain.valueobjects.Name;
import com.carmarketanalysis.carmarketanalysis.domain.valueobjects.Odometer;
import com.carmarketanalysis.carmarketanalysis.domain.valueobjects.Transmission;
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

    @Test
    public void testShouldGenerateUrlByFilterWithParams() {
        var urlProvider = new AutoUrlProviderImpl();
        var brand = new Brand(new Name("Kia"));
        var model = new Model(new Name("Soul"));

        var filter1 = new Filter(1, brand, model);
        filter1.setTransmission(Transmission.AUTOMATIC);
        var expectedUrl1 = "https://auto.ru/moskva/cars/kia/soul/used/?transmission=AUTOMATIC";
        var actualUrl1 = urlProvider.generateByFilter(filter1).toString();
        assertEquals(expectedUrl1, actualUrl1);

        var filter2 = new Filter(1, brand, model);
        filter2.setTransmission(Transmission.AUTOMATIC);
        filter2.setYearFrom(Year.of(2013));
        var expectedUrl2 = "https://auto.ru/moskva/cars/kia/soul/used/?year_from=2013&transmission=AUTOMATIC";
        var actualUrl2 = urlProvider.generateByFilter(filter2).toString();
        assertEquals(expectedUrl2, actualUrl2);

        var filter3 = new Filter(1, brand, model);
        filter3.setTransmission(Transmission.AUTOMATIC);
        filter3.setYearFrom(Year.of(2013));
        filter3.setYearTo(Year.of(2014));
        var expectedUrl3 = "https://auto.ru/moskva/cars/kia/soul/used/?year_from=2013&year_to=2014&transmission=AUTOMATIC";
        var actualUrl3 = urlProvider.generateByFilter(filter3).toString();
        assertEquals(expectedUrl3, actualUrl3);

        var filter4 = new Filter(1, brand, model);
        filter4.setTransmission(Transmission.AUTOMATIC);
        filter4.setYearFrom(Year.of(2013));
        filter4.setYearTo(Year.of(2014));
        filter4.setOdometerFrom(new Odometer(10000));
        var expectedUrl4 = "https://auto.ru/moskva/cars/kia/soul/used/?year_from=2013&year_to=2014&km_age_from=10000&transmission=AUTOMATIC";
        var actualUrl4 = urlProvider.generateByFilter(filter4).toString();
        assertEquals(expectedUrl4, actualUrl4);

        var filter5 = new Filter(1, brand, model);
        filter5.setTransmission(Transmission.AUTOMATIC);
        filter5.setYearFrom(Year.of(2013));
        filter5.setYearTo(Year.of(2014));
        filter5.setOdometerFrom(new Odometer(10000));
        filter5.setOdometerTo(new Odometer(100000));
        var expectedUrl5 = "https://auto.ru/moskva/cars/kia/soul/used/?year_from=2013&year_to=2014&km_age_from=10000&km_age_to=100000&transmission=AUTOMATIC";
        var actualUrl5 = urlProvider.generateByFilter(filter5).toString();
        assertEquals(expectedUrl5, actualUrl5);

        var filter6 = new Filter(1, brand, model);
        filter6.setTransmission(Transmission.AUTOMATIC);
        filter6.setYearFrom(Year.of(2013));
        filter6.setYearTo(Year.of(2014));
        filter6.setOdometerFrom(new Odometer(10000));
        filter6.setOdometerTo(new Odometer(100000));
        filter6.setEngineCapacityFrom(new EngineCapacity(0.5F));
        var expectedUrl6 = "https://auto.ru/moskva/cars/kia/soul/used/?year_from=2013&year_to=2014&km_age_from=10000&km_age_to=100000&displacement_from=500&transmission=AUTOMATIC";
        var actualUrl6 = urlProvider.generateByFilter(filter6).toString();
        assertEquals(expectedUrl6, actualUrl6);

        var filter7 = new Filter(1, brand, model);
        filter7.setTransmission(Transmission.AUTOMATIC);
        filter7.setYearFrom(Year.of(2013));
        filter7.setYearTo(Year.of(2014));
        filter7.setOdometerFrom(new Odometer(10000));
        filter7.setOdometerTo(new Odometer(100000));
        filter7.setEngineCapacityFrom(new EngineCapacity(0.5F));
        filter7.setEngineCapacityTo(new EngineCapacity(4.5F));
        var expectedUrl7 = "https://auto.ru/moskva/cars/kia/soul/used/?year_from=2013&year_to=2014&km_age_from=10000&km_age_to=100000&displacement_from=500&displacement_to=4500&transmission=AUTOMATIC";
        var actualUrl7 = urlProvider.generateByFilter(filter7).toString();
        assertEquals(expectedUrl7, actualUrl7);

        var filter8 = new Filter(2, brand, model);
        filter8.setTransmission(Transmission.AUTOMATIC);
        filter8.setYearFrom(Year.of(2013));
        filter8.setYearTo(Year.of(2014));
        filter8.setOdometerFrom(new Odometer(10000));
        filter8.setOdometerTo(new Odometer(100000));
        filter8.setEngineCapacityFrom(new EngineCapacity(0.5F));
        filter8.setEngineCapacityTo(new EngineCapacity(4.5F));
        var expectedUrl8 = "https://auto.ru/moskva/cars/kia/soul/used/?year_from=2013&year_to=2014&km_age_from=10000&km_age_to=100000&displacement_from=500&displacement_to=4500&transmission=AUTOMATIC&page=2";
        var actualUrl8 = urlProvider.generateByFilter(filter8).toString();
        assertEquals(expectedUrl8, actualUrl8);
    }
}
