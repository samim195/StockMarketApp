package uk.stockfinder.service;

import uk.stockfinder.entity.AlphaVantageStock;

import java.util.List;

public interface StocksService {

    List<AlphaVantageStock> getAllStocks() throws Exception;

    List<AlphaVantageStock> getStockByName(String stockName) throws Exception;

    List<AlphaVantageStock> getStockByUserRules(Double priceEarnings2022, Double price) throws Exception;

}
