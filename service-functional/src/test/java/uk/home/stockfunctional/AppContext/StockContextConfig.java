package uk.home.stockfunctional.AppContext;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan("uk.home.stockfunctional")
public class StockContextConfig {
    @Value("${RUNNING_LOCALLY:false}")
    private boolean isLocal;

    @Bean
    public boolean getIsLocal() {
        return isLocal;
    }
}
