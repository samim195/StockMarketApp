package utils;

import org.springframework.stereotype.Component;
import uk.stockfinder.entity.CompanyOverview;
import uk.stockfinder.service.FundamentalDataService;

import java.io.IOException;

@Component
public class PojoProducer {

    private final DataObjectMapper dataObjectMapper;

    public PojoProducer() {
        this.dataObjectMapper = new DataObjectMapperImpl();
    }

    public CompanyOverview produceCompanyOverviewPojo(String symbol) throws IOException, InterruptedException {
        String companyOverview = FundamentalDataService.getCompanyOverview(symbol);
        return dataObjectMapper.mapDataToObject(companyOverview, CompanyOverview.class);
    }
}
