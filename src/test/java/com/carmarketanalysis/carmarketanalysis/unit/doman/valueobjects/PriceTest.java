package com.carmarketanalysis.carmarketanalysis.unit.doman.valueobjects;

import com.carmarketanalysis.carmarketanalysis.domain.valueobjects.Price;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class PriceTest {
    @Test
    void testShouldCreatePriceObject() {
        var price = new Price(1);
        assertEquals(1, price.getValue());
    }

    @Test
    void  testShouldThrowExceptionIfValueLessThanZero() {
        assertThrows(IllegalArgumentException.class, () -> {new Price(-1);});
    }
}
