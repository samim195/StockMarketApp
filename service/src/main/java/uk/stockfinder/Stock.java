package uk.stockfinder;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class Stock {
    private String name;
    private String isin;
    private String epic;
    private String price;
    private String historicalPE;
    private String PE2022;
    private String historicalYield;
    private String forecastYield;
    private String ptbv;
    private String gearing;
    private String epsGrowth;
    private String forecastCover;
    private String capitalisation;
    private String index;
    private String sector;
}
