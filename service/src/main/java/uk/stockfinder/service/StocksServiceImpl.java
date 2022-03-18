package uk.stockfinder.service;

import org.springframework.stereotype.Service;
import uk.stockfinder.entity.AlphaVantageStock;
import uk.stockfinder.factory.ReaderFactoryDao;
import uk.stockfinder.factory.ReaderFactoryImpl;
import uk.stockfinder.reader.CsvReader;
import uk.stockfinder.valueobject.FileConstant;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service("stocksService")
public class StocksServiceImpl implements StocksService {

    private static ReaderFactoryDao readerFactory;

    private CsvReader csvReader;

    public StocksServiceImpl(ReaderFactoryImpl readerFactory) {
        StocksServiceImpl.readerFactory = readerFactory;
    }

    @Override
    public List<AlphaVantageStock> getAllStocks() throws Exception {
        csvReader = readerFactory.makeCsvReader();
        return csvReader.readStockFromFile(FileConstant.ALPHA_VANTAGE_FILE_NAME);
    }

    @Override
    public List<AlphaVantageStock> getStockByName(String stockName) throws Exception {
        if(stockName.isEmpty()){
            return Collections.emptyList();
        }
        csvReader = readerFactory.makeCsvReader();
        List<AlphaVantageStock> stocks = csvReader.readStockFromFile(FileConstant.ALPHA_VANTAGE_FILE_NAME);
        return stocks.stream()
                .filter(stock -> stock.getName().equals(stockName))
                .collect(Collectors.toList());
    }

    @Override
    public List<AlphaVantageStock> getStockByUserRules(Double priceEarnings2022, Double price) throws Exception {
//            csvReader = readerFactory.makeCsvReader();
//        List<AlphaVantageStock> stocks = csvReader.readStockFromFile(FileConstant.FILE_NAME);
//        return stocks.stream()
//                .filter(stock -> !stock.getPE2022().isEmpty() && Double.parseDouble(stock.getPE2022()) > priceEarnings2022)
//                .filter(stock -> Double.parseDouble(stock.getPrice()) < price)
//                .collect(Collectors.toList());
        return null;
    }

}
