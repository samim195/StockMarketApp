package uk.stockfinder.service;

import org.springframework.stereotype.Service;
import uk.stockfinder.entity.Stock;
import uk.stockfinder.factory.ReaderFactoryDao;
import uk.stockfinder.factory.ReaderFactoryImpl;
import uk.stockfinder.reader.CsvDao;
import uk.stockfinder.valueobject.FileConstant;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service("stocksService")
public class StocksServiceImpl implements StocksService {

    private static ReaderFactoryDao readerFactory;

    private CsvDao csvDao;

    public StocksServiceImpl(ReaderFactoryImpl readerFactory) {
        StocksServiceImpl.readerFactory = readerFactory;
    }

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
