package uk.stockfinder;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import uk.stockfinder.entity.Stock;
import uk.stockfinder.entity.CsvReader;
import uk.stockfinder.valueobject.FileConstant;

import java.util.List;

public class CsvReaderTest {

    @Test
    void test() throws Exception {
        //When
        CsvReader csvReader = new CsvReader();
        Stock build = Stock.builder()
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
                .sector("Travel")
                .dividend2017("24")
                .dividend2018("19.6")
                .dividend2019("15.7")
                .dividend2020("11")
                .dividend2021("9")
                .book("13")
                .intangibles("487")
                .cash("164")
                .turnover("190")
                .noOfShares("698")
                .latestYield("3.4%")
                .build();

        //Then
        List<Stock> stockList = csvReader.readStockFromFile(FileConstant.FILE_NAME);

        //Verify
        Assertions.assertEquals(build.getName(), stockList.get(0).getName());
        Assertions.assertEquals(build.getPrice(), stockList.get(0).getPrice());
        Assertions.assertEquals(build.getEpsGrowth(), stockList.get(0).getEpsGrowth());
        Assertions.assertEquals(build.getBook(), stockList.get(0).getBook());
        Assertions.assertEquals(build.getTurnover(), stockList.get(0).getTurnover());
        Assertions.assertEquals(build.getLatestYield(), stockList.get(0).getLatestYield());
    }
}
