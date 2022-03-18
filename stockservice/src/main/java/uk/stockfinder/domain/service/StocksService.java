package uk.stockfinder.domain.service;

import uk.stockfinder.domain.entity.Stock;

import java.util.List;

public interface StocksService {

    List<Stock> getAllStocks() throws Exception;

    List<Stock> getStockByName(String stockName) throws Exception;

}
