package uk.stockfinder.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uk.stockfinder.daoimplementations.CsvReaderDao;
import uk.stockfinder.entity.CsvReader;
import uk.stockfinder.entity.Stock;
import uk.stockfinder.valueobject.FileConstant;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service("stocksService")
public class StocksServiceImpl implements StocksService {

    @Autowired
    private static CsvReader csvReader;

    public StocksServiceImpl(CsvReader csvReader) {
        StocksServiceImpl.csvReader = csvReader;
    }

    @Override
    public List<Stock> getAllStocks() throws Exception {
        csvReader = new CsvReader(new CsvReaderDao());
        return csvReader.readStock(FileConstant.FILE_NAME);
    }

    @Override
    public List<Stock> getStockByName(String stockName) throws Exception {
        if(stockName.isEmpty()){
            return Collections.emptyList();
        }
        csvReader = new CsvReader(new CsvReaderDao());
        List<Stock> stocks = csvReader.readStock(FileConstant.FILE_NAME);
        return stocks.stream()
                .filter(stock -> stock.getName().equals(stockName))
                .collect(Collectors.toList());
    }

}
