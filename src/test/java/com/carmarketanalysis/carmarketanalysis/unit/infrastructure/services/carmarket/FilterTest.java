package com.carmarketanalysis.carmarketanalysis.unit.infrastructure.services.carmarket;

import com.carmarketanalysis.carmarketanalysis.domain.entities.Brand;
import com.carmarketanalysis.carmarketanalysis.domain.entities.Model;
import com.carmarketanalysis.carmarketanalysis.domain.valueobjects.Name;
import com.carmarketanalysis.carmarketanalysis.infrastructure.services.carmarket.Filter;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.Year;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class FilterTest {
    @Test
    void testShouldCreateFilterObject() {
        new Filter(
                1,
                new Brand(new Name("Kia")),
                new Model(new Name("Soul"))
        );
        assertTrue(true);
    }

    @Test
    void testShouldReturnTrueIfYearFromAndToEqual() {
        var filterOne = new Filter(
                1,
                new Brand(new Name("Kia")),
                new Model(new Name("Soul"))
        );
        filterOne.setYearFrom(Year.of(2020));
        filterOne.setYearTo(Year.of(2020));
        assertTrue(filterOne.isOneYear());

        var filterTwo = new Filter(
                1,
                new Brand(new Name("Kia")),
                new Model(new Name("Soul"))
        );
        filterTwo.setYearFrom(Year.of(2021));
        filterTwo.setYearTo(Year.of(2020));
        assertFalse(filterTwo.isOneYear());

        var filterThree = new Filter(
                1,
                new Brand(new Name("Kia")),
                new Model(new Name("Soul"))
        );

        assertFalse(filterThree.isOneYear());

        var filterFour = new Filter(
                1,
                new Brand(new Name("Kia")),
                new Model(new Name("Soul"))
        );
        filterFour.setYearFrom(Year.of(2020));
        assertFalse(filterFour.isOneYear());

        var filterFive = new Filter(
                1,
                new Brand(new Name("Kia")),
                new Model(new Name("Soul"))
        );
        filterFive.setYearTo(Year.of(2020));
        assertFalse(filterFive.isOneYear());
    }
}
