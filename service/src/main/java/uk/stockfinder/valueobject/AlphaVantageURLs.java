package uk.stockfinder.valueobject;

public enum AlphaVantageURLs {

    OVERVIEW("https://www.alphavantage.co/query?function=OVERVIEW&symbol=");

    public final String url;

    private AlphaVantageURLs(String url) {
        this.url = url;
    }
}
