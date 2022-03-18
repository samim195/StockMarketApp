package uk.stockfinder.entity;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class AlphaVantageStock {
    public String symbol;
    public String name;
    public String exchange;
    public String assetType;
    public String ipoDate;
    public String delistingDate;
    public String status;
}
