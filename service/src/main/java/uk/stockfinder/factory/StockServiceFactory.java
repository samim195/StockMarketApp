package uk.stockfinder.factory;

import uk.stockfinder.service.StocksService;
import uk.stockfinder.service.StocksServiceImpl;

public class StockServiceFactory {
    public static StocksService createStockService() {
        return new StocksServiceImpl(new ReaderFactoryImpl());
    }
}
