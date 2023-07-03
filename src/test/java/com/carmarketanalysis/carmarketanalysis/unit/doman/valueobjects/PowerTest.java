package com.carmarketanalysis.carmarketanalysis.unit.doman.valueobjects;

import com.carmarketanalysis.carmarketanalysis.domain.valueobjects.Power;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class PowerTest {
    @Test
    void testShouldCreatePowerObject() {
        var power = new Power(100);
        assertEquals(100, power.getValue());
    }

    @Test
    void testShouldThrowExceptionIfPowerLessThanZero() {
        assertThrows(IllegalArgumentException.class, () -> {new Power(-1);});
    }

    @Test
    void testShouldThrowExceptionIfPowerGreaterThan1000() {
        assertThrows(IllegalArgumentException.class, () -> {new Power(1001);});
    }
}
