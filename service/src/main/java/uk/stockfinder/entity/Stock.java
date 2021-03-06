package uk.stockfinder.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@AllArgsConstructor
@Deprecated
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
    private String epsGrowth; //EPS growth refers to the positive change between earnings per share values reported by the company
    private String forecastCover;
    private String capitalisation;
    private String index;
    private String sector;
    private String dividend2017;
    private String dividend2018;
    private String dividend2019;
    private String dividend2020;
    private String dividend2021;
    private String book;
    private String intangibles;
    private String cash;
    private String turnover;
    private String noOfShares;
    private String latestYield;

    public static Stock.StockBuilder builder() {return new Stock.StockBuilder();}
}
