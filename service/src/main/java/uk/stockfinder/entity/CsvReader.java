package uk.stockfinder.entity;

import java.util.List;

public interface CsvReader {
    List<Stock> readStockFromFile(String file) throws Exception;
}
