package uk.stockfinder.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import uk.stockfinder.entity.CompanyOverview;
import utils.DataObjectMapper;
import utils.DataObjectMapperImpl;

import java.io.IOException;

import static org.assertj.core.api.Assertions.assertThat;

class FundamentalDataServiceTest {


    @Autowired
    private CompanyOverview companyOverview;

    DataObjectMapper objectMapper = new DataObjectMapperImpl();

    @BeforeEach
    void setup() {
    }

    @Test
    public void assertThatCompanyOverviewIsReturned() throws IOException, InterruptedException {
        String ibm = FundamentalDataService.getCompanyOverview("IBM");

        System.out.println(ibm);

        companyOverview = objectMapper.mapDataToObject(ibm, CompanyOverview.class);

        assertThat(companyOverview.getSymbol()).isEqualTo("IBM");
        assertThat(companyOverview.getAssetType()).isEqualTo("Common Stock");
        assertThat(companyOverview.getPERatio()).isEqualTo("19.52");
    }
}