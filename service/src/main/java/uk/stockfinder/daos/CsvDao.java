package uk.stockfinder.daos;

import uk.stockfinder.entity.Stock;

import java.util.List;

public interface CsvDao {
    List<Stock> readStockFromFile(String file) throws Exception;
}
