package uk.stockfinder.service;

import uk.stockfinder.entity.Stock;

import java.util.List;

public interface StocksService {

    List<Stock> getAllStocks() throws Exception;

    List<Stock> getStockByName(String stockName) throws Exception;

}
