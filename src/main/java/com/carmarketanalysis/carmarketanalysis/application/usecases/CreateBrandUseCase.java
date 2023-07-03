package com.carmarketanalysis.carmarketanalysis.application.usecases;

import com.carmarketanalysis.carmarketanalysis.application.usecases.commands.CreateBrandCommand;
import com.carmarketanalysis.carmarketanalysis.domain.entities.Brand;
import com.carmarketanalysis.carmarketanalysis.infrastructure.repositories.BrandRepository;

public class CreateBrandUseCase {
    private final BrandRepository brandRepository;

    public CreateBrandUseCase(BrandRepository brandRepository) {
        this.brandRepository = brandRepository;
    }

    public Brand handle(CreateBrandCommand createBrandCommand) {
        var brand = new Brand(createBrandCommand.name());
        return brandRepository.save(brand);
    }
}
