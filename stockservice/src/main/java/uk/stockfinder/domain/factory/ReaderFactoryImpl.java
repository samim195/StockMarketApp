package uk.stockfinder.domain.factory;

import uk.stockfinder.domain.reader.CsvDao;
import uk.stockfinder.domain.reader.CsvReaderDao;
import org.springframework.stereotype.Component;

@Component
public class ReaderFactoryImpl implements ReaderFactoryDao {
    @Override
    public CsvDao makeCsvReader() {
        return new CsvReaderDao();
    }
}
