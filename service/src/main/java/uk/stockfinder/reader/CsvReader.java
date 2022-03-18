package uk.stockfinder.reader;

import uk.stockfinder.entity.AlphaVantageStock;

import java.io.File;
import java.net.URL;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public abstract class CsvReader {

    public List<AlphaVantageStock> readStockFromFile(String file) throws Exception {
        if (file.isEmpty()) {
            return Collections.emptyList();
        }

        URL resource = getClass().getClassLoader().getResource(Objects.requireNonNull(file));
        File fileName;
        try {
            fileName = Paths.get(Objects.requireNonNull(resource).toURI()).toFile();
        } catch (Exception e) {
            throw new NullPointerException("Resource was null check value of resource: " + file);
        }

        return mapStockBuilder(fileName);
    }

    public abstract List<AlphaVantageStock> mapStockBuilder(File fileName) throws Exception;
}
