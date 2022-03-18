package uk.stockfinder.domain.service;

import uk.stockfinder.domain.entity.Stock;
import uk.stockfinder.domain.factory.ReaderFactoryDao;
import uk.stockfinder.domain.reader.CsvDao;
import uk.stockfinder.infrastructure.valueobject.FileConstant;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class StocksServiceImpl implements StocksService {

    private static ReaderFactoryDao readerFactory;

    private CsvDao csvDao;


    @Override
    public List<Stock> getAllStocks() throws Exception {
        csvDao = readerFactory.makeCsvReader();
        return csvDao.readStockFromFile(FileConstant.FILE_NAME);
    }

    @Override
    public List<Stock> getStockByName(String stockName) throws Exception {
        if(stockName.isEmpty()){
            return Collections.emptyList();
        }
        csvDao = readerFactory.makeCsvReader();
        List<Stock> stocks = csvDao.readStockFromFile(FileConstant.FILE_NAME);
        return stocks.stream()
                .filter(stock -> stock.getName().equals(stockName))
                .collect(Collectors.toList());
    }

}