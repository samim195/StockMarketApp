package uk.stockfinder.service;

import uk.stockfinder.entity.CompanyOverview;
import utils.PojoProducer;

import java.io.IOException;

public abstract class InvestmentStrategyService {

    PojoProducer pojoProducer;

    public boolean evaluateStockByCompanyOverview(String symbol) throws IOException, InterruptedException {

        pojoProducer = new PojoProducer();
        CompanyOverview companyOverview = pojoProducer.produceCompanyOverviewPojo(symbol);

        String priceToBookRatio = companyOverview.getPriceToBookRatio();
        String pegRatio = companyOverview.getPEGRatio();
        String symbol1 = companyOverview.getSymbol();
        String returnOnEquityTTM = companyOverview.getReturnOnEquityTTM();

        if (symbol1 == null) {
            return false;
        }

        if(priceToBookRatio.equals("None") && pegRatio.equals("None")) {
            return false;
        }

        if (priceToBookRatio.equals("None")) {
            priceToBookRatio = "0";
        }
        if (pegRatio.equals("None")) {
            pegRatio = "0";
        }
        if (symbol1 == "None") {
            symbol1 = "0";
        }

        if (symbol1 == null || priceToBookRatio.equals("-") || pegRatio.equals("-") ||
                returnOnEquityTTM.equals("-") ) {
            return false;
        }

        if(Double.parseDouble(priceToBookRatio) < 0 && Double.parseDouble(pegRatio) > 1) {
//            If the company has been losing money, PE will be negative but if it still has a high book ratio it means it can survive and turnaround
            return true;
        }

//        Applying rules to filter out bad stocks
        if ((Double.parseDouble(pegRatio) > 1) || (Double.parseDouble(priceToBookRatio) > 3)
            || (Double.parseDouble(returnOnEquityTTM) < 0.10)) {
//            Anything between 0 - 1 is good
//            Anything between 0 - 0.5 is great
//            System.out.println("------------------------ Failed to meet criteria ---------------------------");
//            System.out.println("| PEG Ratio: " + pegRatio + "  |   PB RATIO: "
//                    + priceToBookRatio + "  | ROE RATIO: "
//                    + returnOnEquityTTM + "  |");
//            System.out.println(companyOverview);
            return false;
        }

//        System.out.println("---------------- Succeeded In Meeting the Criteria");
        System.out.println(companyOverview);
        return true;
    }
}
