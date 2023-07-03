package com.carmarketanalysis.carmarketanalysis.integration.infrastructure.repositories;

import com.carmarketanalysis.carmarketanalysis.PostgresContainer;
import com.carmarketanalysis.carmarketanalysis.domain.entities.Brand;
import com.carmarketanalysis.carmarketanalysis.domain.valueobjects.Name;
import com.carmarketanalysis.carmarketanalysis.infrastructure.repositories.BrandRepository;
import com.github.javafaker.Faker;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.testcontainers.junit.jupiter.Testcontainers;

import static org.junit.jupiter.api.Assertions.*;

@Testcontainers
@SpringBootTest
public class BrandRepositoryTest extends PostgresContainer {

    @Autowired
    BrandRepository brandRepository;

    @Test
    public void testShouldCreateNewBrand() {
        var faker = new Faker();
        var name = faker.name().username();
        var brand = brandRepository.save(new Brand(new Name(name)));
        assertEquals(name, brand.getName().getValue());
        assertNotNull(brand.getCreatedAt());
        assertNotNull(brand.getUpdatedAt());
    }

    @Test
    public void testShouldThrowExceptionIfNotUniqueNameIsCreated() {
        assertThrows(Exception.class, () -> {
            var faker = new Faker();
            var name = faker.name().username();
            brandRepository.save(new Brand(new Name(name)));
            brandRepository.save(new Brand(new Name(name)));
        });
    }
}
