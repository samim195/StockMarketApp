package uk.stockfinder;

import org.junit.jupiter.api.Test;
import uk.stockfinder.entity.AlphaVantageStock;
import uk.stockfinder.entity.Stock;
import uk.stockfinder.factory.ReaderFactoryDao;
import uk.stockfinder.factory.ReaderFactoryImpl;
import uk.stockfinder.reader.CsvReader;
import uk.stockfinder.valueobject.FileConstant;

import java.util.List;

public class CsvReaderTest {

    @Test
    void givenStockListVerifyStockObjectContainsSpecificData() throws Exception {
        //Given
        ReaderFactoryDao readerFactoryDao = new ReaderFactoryImpl();
        CsvReader csvDao = readerFactoryDao.makeCsvReader();
//        List<Stock> stocks = new ArrayList<Stock>(new Stock("888 Holdings Plc",
//                "GI000A0F6407",
//                "888",
//                "382.80",
//                "38280.0",
//                "16.0",
//                "2.4%",
//                "3.4%",
//                "4.4",
//                "30.1%",
//                "239900%," +
//                        "1.8",
//                "1425",
//                "FTSE250",
//                "Travel",
//                "24",
//                "19.6",
//                "15.7",
//                "11",
//                "9",
//                "13","487", "487",
//                "164", "190",
//                "698", "3.4%"));
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

//        when(csvReader.readStockFromFile(any())).thenReturn(List<Stock>);
        List<AlphaVantageStock> stockList = csvDao.readStockFromFile(FileConstant.FILE_NAME);

        //Then
//        assertThat(stockList.get(0).getName()).isEqualTo(build.getName());
//        Assertions.assertEquals(build.getName(), stockList.get(0).getName());
//        Assertions.assertEquals(build.getPrice(), stockList.get(0).getPrice());
//        Assertions.assertEquals(build.getEpsGrowth(), stockList.get(0).getEpsGrowth());
//        Assertions.assertEquals(build.getBook(), stockList.get(0).getBook());
//        Assertions.assertEquals(build.getTurnover(), stockList.get(0).getTurnover());
//        Assertions.assertEquals(build.getLatestYield(), stockList.get(0).getLatestYield());
    }

}
