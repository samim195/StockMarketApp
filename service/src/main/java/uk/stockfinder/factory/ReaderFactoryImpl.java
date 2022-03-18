package uk.stockfinder.factory;

import org.springframework.stereotype.Component;
import uk.stockfinder.reader.AlphaVantageReader;
import uk.stockfinder.reader.CsvReader;

@Component
public class ReaderFactoryImpl implements ReaderFactoryDao {
    @Override
    public CsvReader makeCsvReader() {
        return new AlphaVantageReader();
    }
}
