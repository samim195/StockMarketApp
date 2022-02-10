package uk.home.stockfunctional.AppContext;

import io.cucumber.spring.CucumberContextConfiguration;
import org.springframework.test.context.ContextConfiguration;

@ContextConfiguration(classes = StockContextConfig.class)
@CucumberContextConfiguration
public class CucumberConfig {
}

