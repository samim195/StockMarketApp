package uk.stockfinder.domain.service;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConfigurationService {

    @Bean(name="stocksService")
    public StocksService createServiceBean() {
        StocksService bean = new StocksServiceImpl();
        return bean;
    }
}
