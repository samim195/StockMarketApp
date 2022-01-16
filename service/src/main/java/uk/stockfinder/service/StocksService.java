package uk.stockfinder.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import uk.stockfinder.CsvReader;
import uk.stockfinder.FileConstant;
import uk.stockfinder.Stock;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class StocksService {

    @Autowired
    private CsvReader csvReader;

    public StocksService(CsvReader csvReader) {
        this.csvReader = csvReader;
    }

    public List<Stock> getAllStocks ()throws Exception {
        csvReader = new CsvReader();
        return csvReader.readStockFromFile(FileConstant.FILE_NAME);
    }

    public List<Stock> getStockByName(String stockName) throws Exception {
        csvReader = new CsvReader();
        List<Stock> stocks = csvReader.readStockFromFile(FileConstant.FILE_NAME);
        return stocks.stream().filter(stock -> stock.getName().equals(stockName)).collect(Collectors.toList());
    }

}
