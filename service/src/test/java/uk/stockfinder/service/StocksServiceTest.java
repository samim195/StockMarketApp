package uk.stockfinder.service;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.checkerframework.checker.units.qual.C;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import uk.stockfinder.Stock;
import uk.stockfinder.StocksData;
import uk.stockfinder.WiremockServerInitialize;

import java.io.IOException;

import static com.github.tomakehurst.wiremock.client.WireMock.*;

class StocksServiceTest {

    @Autowired
    private WiremockServerInitialize wiremockServerInitialize;

    @Autowired
    StocksData stocksData;

    @BeforeEach
    public void setup() {
        wiremockServerInitialize = new WiremockServerInitialize();
        stocksData = new StocksData();
    }

    @Test
    void whenStocksEndpointIsQueriedShouldReturn200 () throws IOException {
        wiremockServerInitialize.startWireMockServer();
        stubFor(get(urlEqualTo("/stocks")).willReturn(aResponse().withBody("OK")));
        stubFor(get(urlEqualTo("/stocks")).willReturn(aResponse().withStatus(200)));

        CloseableHttpClient closeableHttpClient = HttpClients.createDefault();
        HttpGet request = new HttpGet("http://localhost:8080/stocks");
        HttpResponse httpResponse = closeableHttpClient.execute(request);
        int statusCode = httpResponse.getStatusLine().getStatusCode();

        Assertions.assertEquals(200, statusCode);
//        stocksData.getData().forEach(stock -> System.out.println(stock.getName()));
    }

}