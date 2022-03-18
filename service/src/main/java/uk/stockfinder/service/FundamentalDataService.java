package uk.stockfinder.service;

import uk.stockfinder.valueobject.AlphaVantageURLs;
import utils.HttpHelper;

import java.io.IOException;
import java.net.http.HttpResponse;

public class FundamentalDataService {

    public static String getCompanyOverview(String companySymbol) throws IOException, InterruptedException {
        HttpResponse<?> httpResponse = HttpHelper.queryService(AlphaVantageURLs.OVERVIEW.url + companySymbol + "&apikey=8EF1NN5F1939F1GN");
        return httpResponse.body().toString();
    }

}
