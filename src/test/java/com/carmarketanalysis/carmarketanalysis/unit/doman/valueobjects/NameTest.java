package com.carmarketanalysis.carmarketanalysis.unit.doman.valueobjects;

import com.carmarketanalysis.carmarketanalysis.domain.valueobjects.Name;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class NameTest {
    @Test
    void testCanCreateNameValueObject() {
        var name = new Name("name");
        assertEquals("name", name.getValue());
    }

    @Test
    void testShouldThrowExceptionIfNameValueIsNull() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Name(null);
        });
    }

    @Test
    void testShouldThrowExceptionIfNameValueIsEmpty() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Name("");
        });
    }
}
