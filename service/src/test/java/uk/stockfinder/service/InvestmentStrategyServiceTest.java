package uk.stockfinder.service;

import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class InvestmentStrategyServiceTest {

    @Test
    public void Test() throws IOException, InterruptedException {
        InvestmentStrategyService investmentStrategyService = new InvestmentStrategyBalanceSheet();
        investmentStrategyService.evaluateStockByCompanyOverview("AAA");

    }

}