package uk.stockfinder.factory;

import org.springframework.stereotype.Component;
import uk.stockfinder.reader.CsvReaderDao;
import uk.stockfinder.reader.CsvDao;

@Component
public class ReaderFactoryImpl implements ReaderFactoryDao {
    @Override
    public CsvDao makeCsvReader() {
        CsvDao csvReader = new CsvReaderDao();
        return csvReader;
    }
}
