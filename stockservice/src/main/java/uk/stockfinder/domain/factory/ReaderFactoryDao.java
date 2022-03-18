package uk.stockfinder.domain.factory;

import uk.stockfinder.domain.reader.CsvDao;

public interface ReaderFactoryDao {
    CsvDao makeCsvReader();
}
