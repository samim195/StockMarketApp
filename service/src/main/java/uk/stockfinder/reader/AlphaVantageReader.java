package uk.stockfinder.reader;

import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import uk.stockfinder.entity.AlphaVantageStock;

import java.io.File;
import java.io.FileReader;
import java.util.List;
import java.util.stream.Collectors;

public class AlphaVantageReader extends CsvReader {
    @Override
    public List<AlphaVantageStock> mapStockBuilder(File fileName) throws Exception {
        CSVReader reader = new CSVReaderBuilder(new FileReader(fileName))
                .withSkipLines(1)
                .build();

        return reader.readAll()
                .stream()
                .map(data -> AlphaVantageStock.builder()
                        .symbol(data[0])
                        .name(data[1])
                        .exchange(data[2])
                        .assetType(data[3])
                        .ipoDate(data[4])
                        .delistingDate(data[5])
                        .status(data[6])
                        .build()).collect(Collectors.toList());
    }

}
