package com.carmarketanalysis.carmarketanalysis.infrastructure.repositories;

import com.carmarketanalysis.carmarketanalysis.domain.entities.Brand;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BrandRepository extends CrudRepository<Brand, Long> {
}
