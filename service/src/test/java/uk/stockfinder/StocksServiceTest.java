package uk.stockfinder;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import uk.stockfinder.utils.HttpClientService;


import java.io.IOException;
import java.net.http.HttpResponse;

import static com.github.tomakehurst.wiremock.client.WireMock.*;

class StocksServiceTest {

    private final String url = "http://localhost:8080/stocks";

    @Autowired
    private WiremockServerInitialize wiremockServerInitialize;

    @Autowired
    private StocksData stocksData;

    @Autowired
    private HttpClientService httpClientService;

    @BeforeEach
    public void setup() {
        wiremockServerInitialize = new WiremockServerInitialize();
        wiremockServerInitialize.startWireMockServer();
        stocksData = new StocksData();
        httpClientService = new HttpClientService(url);
    }

    @Test
    void whenStocksEndpointIsQueriedShouldReturn200AndBody () throws IOException, InterruptedException {
        //Given
//        Name,ISIN,EPIC,Price,H P/E,2022 P/E,H Yield,F Yield,PTBV,Gearing,EPS Growth,F Cover,PSR,Incr Div,Cap (m),Index,Sector,Last Results,EPS,Feps 2021,Feps
//        888 Holdings Plc,GI000A0F6407,888,382.80,38280.0,16.0,2.4%,3.4%,4.4,30.1%,239900%,1.8,2.0,N,"1,425",FTSE250,Travel And Leisure,01/09/2021(Yearly),0.01,20,24,19.6,15.7,11,9,16
        Stock stock = new Stock.StockBuilder()
                .name("888 Holdings Plc")
                .isin("GI000A0F6407")
                .epic("888")
                .price("382.80")
                .historicalPE("38280.0")
                .PE2022("16.0")
                .historicalYield("2.4%")
                .forecastYield("3.4%")
                .ptbv("4.4")
                .gearing("30.1%")
                .epsGrowth("239900%")
                .forecastCover("1.8")
                .capitalisation("1,425")
                .index("FTSE250")
                .sector("Travel And Leisure")
                .build();

        String expectedResponseBody = "{\"name\":\"888 Holdings Plc\",\"isin\":\"GI000A0F6407\",\"epic\":\"888\",\"price\":\"382.80\",\"historicalPE\":\"38280.0\",\"historicalYield\":\"2.4%\",\"forecastYield\":\"3.4%\",\"ptbv\":\"4.4\",\"gearing\":\"30.1%\",\"epsGrowth\":\"239900%\",\"forecastCover\":\"1.8\",\"capitalisation\":\"1,425\",\"index\":\"FTSE250\",\"sector\":\"Travel And Leisure\",\"pe2022\":\"16.0\"}";

        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode node = objectMapper.convertValue(stock, JsonNode.class);

        stubFor(get(urlEqualTo("/stocks")).willReturn(aResponse().withStatus(200)));
        stubFor(get(urlEqualTo("/stocks")).willReturn(aResponse().withJsonBody(node)));

        //When
        HttpResponse response = httpClientService.getRequest();
        String actualResponseBody = response.body().toString();
        int statusCode = response.statusCode();


        //Then
        Assertions.assertEquals(200, statusCode);
        Assertions.assertEquals(expectedResponseBody, actualResponseBody);
    }

}