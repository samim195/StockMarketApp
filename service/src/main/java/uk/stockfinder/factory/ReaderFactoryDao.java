package uk.stockfinder.factory;

import uk.stockfinder.reader.CsvDao;

public interface ReaderFactoryDao {
    CsvDao makeCsvReader();
}
