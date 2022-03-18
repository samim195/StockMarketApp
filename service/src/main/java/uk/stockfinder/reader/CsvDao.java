package uk.stockfinder.reader;

import uk.stockfinder.entity.Stock;

import java.util.List;

//Interface replaced with abstract class CsvReader
@Deprecated
public interface CsvDao {
    List<Stock> readStockFromFile(String file) throws Exception;
}
