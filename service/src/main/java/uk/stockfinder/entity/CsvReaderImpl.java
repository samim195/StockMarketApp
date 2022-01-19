package uk.stockfinder.entity;

import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.FileReader;
import java.net.URL;
import java.nio.file.Paths;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Component
public class CsvReaderImpl implements CsvReader {

    @Override
    public List<Stock> readStockFromFile(String file) throws Exception {

        URL resource = getClass().getClassLoader().getResource(file);
        File fileName = Paths.get(Objects.requireNonNull(resource).toURI()).toFile();

        CSVReader reader = new CSVReaderBuilder(new FileReader(fileName))
                .withSkipLines(1)
                .build();

        return reader.readAll()
                .stream()
                .map(data -> new Stock.StockBuilder()
                        .name(data[0])
                        .isin(data[1])
                        .epic(data[2])
                        .price(data[3])
                        .historicalPE(data[4])
                        .PE2022(data[5])
                        .historicalYield(data[6])
                        .forecastYield(data[7])
                        .ptbv(data[8])
                        .gearing(data[9])
                        .epsGrowth(data[10])
                        .forecastCover(data[11])
                        .capitalisation(data[14])
                        .index(data[15])
                        .sector(data[16])
                        .dividend2017(data[20])
                        .dividend2018(data[21])
                        .dividend2019(data[22])
                        .dividend2020(data[23])
                        .dividend2021(data[24])
                        .book(data[27])
                        .intangibles(data[28])
                        .cash(data[29])
                        .turnover(data[30])
                        .noOfShares(data[31])
                        .latestYield(data[33])
                        .build()).collect(Collectors.toList());
    }
}
