package uk.stockfinder.reader;

import org.springframework.stereotype.Component;

@Component
@Deprecated
public class FidelityCsvReader {
//
//    public FidelityCsvReader() {
//    }
//
//    @Override
//    public List<Stock> mapStockBuilder(File fileName) throws Exception {
//
//        CSVReader reader = new CSVReaderBuilder(new FileReader(fileName))
//                .withSkipLines(1)
//                .build();
//
//        return reader.readAll()
//                .stream()
//                .map(data -> Stock.builder()
//                        .name(data[0])
//                        .isin(data[1])
//                        .epic(data[2])
//                        .price(data[3])
//                        .historicalPE(data[4])
//                        .PE2022(data[5])
//                        .historicalYield(data[6])
//                        .forecastYield(data[7])
//                        .ptbv(data[8])
//                        .gearing(data[9])
//                        .epsGrowth(data[10])
//                        .forecastCover(data[11])
//                        .capitalisation(data[14])
//                        .index(data[15])
//                        .sector(data[16])
//                        .dividend2017(data[20])
//                        .dividend2018(data[21])
//                        .dividend2019(data[22])
//                        .dividend2020(data[23])
//                        .dividend2021(data[24])
//                        .book(data[27])
//                        .intangibles(data[28])
//                        .cash(data[29])
//                        .turnover(data[30])
//                        .noOfShares(data[31])
//                        .latestYield(data[33])
//                        .build()).collect(Collectors.toList());
//    }
}
