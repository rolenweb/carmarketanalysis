package com.carmarketanalysis.carmarketanalysis.unit.doman.valueobjects;

import com.carmarketanalysis.carmarketanalysis.domain.valueobjects.EngineCapacity;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class EngineCapacityTest {
    @Test
    void testShouldCreateEngineCapacityObject() {
        var engineCapacity = new EngineCapacity(2);
        assertEquals(2, engineCapacity.getValue());
    }

    @Test
    void testShouldThrowExceptionIfEngineCapacityLessThanZeroPointTwo() {
        assertThrows(IllegalArgumentException.class, () -> {new EngineCapacity(0.1F);});
    }

    @Test
    void testShouldThrowExceptionIfEngineCapacityGreaterThanTen() {
        assertThrows(IllegalArgumentException.class, () -> {new EngineCapacity(10.1F);});
    }
}
