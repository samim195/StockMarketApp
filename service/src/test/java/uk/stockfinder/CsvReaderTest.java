package uk.stockfinder;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class CsvReaderTest {

    @Test
    void test() throws Exception {
        //When
        CsvReader csvReader = new CsvReader();
        Stock build = new Stock.StockBuilder()
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
                .build();

        //Then
        List<Stock> stockList = csvReader.readStockFromFile(FileConstant.FILE_NAME);

        //Verify
        Assertions.assertEquals(build.getName(), stockList.get(0).getName());
        Assertions.assertEquals(build.getPrice(), stockList.get(0).getPrice());
        Assertions.assertEquals(build.getEpsGrowth(), stockList.get(0).getEpsGrowth());
    }
}
