package com.carmarketanalysis.carmarketanalysis.unit.infrastructure.services.carmarket.ru.auto;

import com.carmarketanalysis.carmarketanalysis.infrastructure.services.carmarket.Filter;
import com.carmarketanalysis.carmarketanalysis.infrastructure.services.carmarket.ru.auto.AutoCarMarketImpl;
import com.carmarketanalysis.carmarketanalysis.infrastructure.services.carmarket.ru.auto.AutoScraper;
import com.carmarketanalysis.carmarketanalysis.infrastructure.services.carmarket.ru.auto.AutoUrlProvider;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.internal.util.io.IOUtil;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClient.RequestHeadersUriSpec;
import org.springframework.web.reactive.function.client.WebClient.RequestBodySpec;
import org.springframework.web.reactive.function.client.WebClient.ResponseSpec;
import org.springframework.web.util.UriComponentsBuilder;
import reactor.core.publisher.Mono;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URI;
import java.nio.file.Files;
import java.util.Objects;
import java.util.Optional;

import static org.mockito.Mockito.when;
import static org.mockito.Mockito.anyString;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.eq;
import static org.mockito.Mockito.verify;

@SpringBootTest
public class AutoCarMarketImplTest {
    @Mock
    AutoScraper autoScraper;

    @Mock
    AutoUrlProvider autoUrlProvider;

    @InjectMocks
    AutoCarMarketImpl autoCarMarket;

    @Test
    public void testShouldReturnListOfCarsByFilter() throws IOException {
        var filter = new Filter();
        when(autoUrlProvider.generateByFilter(filter)).thenReturn(uri());
        //when(autoScraper.scrape(uri())).thenReturn(Optional.of(mockData()));
        autoCarMarket.findByFilter(filter);
    }

    private String mockData() throws IOException {
        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(Objects.requireNonNull(classLoader.getResource("auto_ru_list.html")).getFile());
        return new String(Files.readAllBytes(file.toPath()));
    }

    private URI uri() {
        return UriComponentsBuilder.fromUriString("/hyundai/elantra/all/?transmission=AUTOMATIC&year_from=2017&year_to=2018").build().toUri();
    }
}
