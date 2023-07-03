package com.carmarketanalysis.carmarketanalysis.unit.doman.valueobjects;

import com.carmarketanalysis.carmarketanalysis.domain.valueobjects.Odometer;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class OdometerTest {
    @Test
    void testShouldCreateOdometerObject() {
        var odometer = new Odometer(0);
        assertEquals(0, odometer.getValue());
    }

    @Test
    void testShouldThrowExceptionIfValueLessZero() {
        assertThrows(IllegalArgumentException.class, () ->{new Odometer(-1);});
    }
}
