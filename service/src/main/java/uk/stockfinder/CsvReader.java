package uk.stockfinder;

import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.FileReader;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class CsvReader {


    public List<Stock> readStockFromFile(String fileName) throws Exception {

        File testFile = new File("");
        String currentPath = testFile.getAbsolutePath();
        System.out.println("current path is: " + currentPath);

        fileName = currentPath + "/src/main/resources/" + fileName;


        CSVReader reader = new CSVReaderBuilder(new FileReader(fileName))
                .withSkipLines(1)
                .build();
        List<Stock> stockList = reader.readAll()
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
                        .build()).collect(Collectors.toList());

        return stockList;
    }
}
