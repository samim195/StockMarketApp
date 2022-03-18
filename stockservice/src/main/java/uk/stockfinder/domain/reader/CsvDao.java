package uk.stockfinder.domain.reader;

import uk.stockfinder.domain.entity.Stock;

import java.util.List;

public interface CsvDao {
    List<Stock> readStockFromFile(String file) throws Exception;
}
