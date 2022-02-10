package uk.stockfinder.factory;

import uk.stockfinder.reader.CsvReaderDao;
import uk.stockfinder.reader.CsvDao;

public class ReaderFactoryImpl implements ReaderFactoryDao {
    @Override
    public CsvDao makeCsvReader() {
        CsvDao csvReader = new CsvReaderDao();
        return csvReader;
    }
}
