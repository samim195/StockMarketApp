package uk.stockfinder.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uk.stockfinder.entity.CsvReader;
import uk.stockfinder.valueobject.FileConstant;
import uk.stockfinder.entity.Stock;

import java.util.List;
import java.util.stream.Collectors;

@Service("stocksService")
public class StocksServiceImpl implements StocksService {

    @Autowired
    private static CsvReader csvReader;

    public StocksServiceImpl(CsvReader csvReader) {
        this.csvReader = csvReader;
    }


    @Override
    public List<Stock> getAllStocks() throws Exception {
        csvReader = new CsvReader();
        return csvReader.readStockFromFile(FileConstant.FILE_NAME);
    }

    @Override
    public List<Stock> getStockByName(String stockName) throws Exception {
        csvReader = new CsvReader();
        List<Stock> stocks = csvReader.readStockFromFile(FileConstant.FILE_NAME);
        return stocks.stream()
                .filter(stock -> stock.getName().equals(stockName))
                .collect(Collectors.toList());
    }

}
