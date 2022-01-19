package uk.stockfinder.entity;

import java.util.List;

@FunctionalInterface  interface OpenFileReaderFunction {
    List<Stock> readStockFromFile(String file) throws Exception;
}
