package com.carmarketanalysis.carmarketanalysis.unit.infrastructure.services.carmarket;

import com.carmarketanalysis.carmarketanalysis.domain.entities.Brand;
import com.carmarketanalysis.carmarketanalysis.domain.entities.Model;
import com.carmarketanalysis.carmarketanalysis.domain.valueobjects.Name;
import com.carmarketanalysis.carmarketanalysis.infrastructure.services.carmarket.Filter;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class FilterTest {
    @Test
    void testShouldCreateFilterObject() {
        var filter = new Filter(
                1,
                new Brand(new Name("Kia")),
                new Model()
        );
        assertTrue(true);
    }
}
