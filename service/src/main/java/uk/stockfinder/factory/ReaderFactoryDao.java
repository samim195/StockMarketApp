package uk.stockfinder.factory;

import uk.stockfinder.reader.CsvReader;

public interface ReaderFactoryDao {
    public CsvReader makeCsvReader();
}
