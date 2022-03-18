package uk.stockfinder.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Component
@Getter
@Setter
public class CompanyOverview {
    @JsonProperty
    String Symbol;
    @JsonProperty
    String AssetType;
    @JsonProperty
    String Name;
    @JsonProperty
    String Description;
    @JsonProperty
    String CIK;
    @JsonProperty
    String Exchange;
    @JsonProperty
    String Currency;
    @JsonProperty
    String Country;
    @JsonProperty
    String Sector;
    @JsonProperty
    String Industry;
    @JsonProperty
    String Address;
    @JsonProperty
    String FiscalYearEnd;
    @JsonProperty
    String LatestQuarter;
    @JsonProperty
    String MarketCapitalization;
    @JsonProperty
    String EBITDA;
    @JsonProperty
    String PERatio;
    @JsonProperty
    String PEGRatio;
    @JsonProperty
    String BookValue;
    @JsonProperty
    String DividendPerShare;
    @JsonProperty
    String DividendYield;
    @JsonProperty
    String EPS;
    @JsonProperty
    String RevenuePerShareTTM;
    @JsonProperty
    String ProfitMargin;
    @JsonProperty
    String OperatingMarginTTM;
    @JsonProperty
    String ReturnOnAssetsTTM;
    @JsonProperty
    String ReturnOnEquityTTM;
    @JsonProperty
    String RevenueTTM;
    @JsonProperty
    String GrossProfitTTM;
    @JsonProperty
    String DilutedEPSTTM;
    @JsonProperty
    String QuarterlyEarningsGrowthYOY;
    @JsonProperty
    String QuarterlyRevenueGrowthYOY;
    @JsonProperty
    String AnalystTargetPrice;
    @JsonProperty
    String TrailingPE;
    @JsonProperty
    String ForwardPE;
    @JsonProperty
    String PriceToSalesRatioTTM;
    @JsonProperty
    String PriceToBookRatio;
    @JsonProperty
    String EVToRevenue;
    @JsonProperty
    String EVToEBITDA;
    @JsonProperty
    String Beta;
    @JsonProperty("52WeekHigh")
    String FiftyTwoWeekHigh;
    @JsonProperty("52WeekLow")
    String FiftyTwoWeekLow;
    @JsonProperty("50DayMovingAverage")
    String FiftyDayMovingAverage;
    @JsonProperty("200DayMovingAverage")
    String TwoHundredMovingAverage;
    @JsonProperty
    String SharesOutstanding;
    @JsonProperty
    String DividendDate;
    @JsonProperty
    String ExDividendDate;

    @Override
    public String toString() {
        return "Name: " + this.Name + ", PEG RATIO: " + this.PEGRatio + ", PB RATIO: " + this.PriceToBookRatio +
                ", ROE RATIO: " + this.ReturnOnEquityTTM + ", PE RATIO: " + this.PERatio + ", High: " + this.FiftyTwoWeekHigh
                + ", Low: " + this.getFiftyTwoWeekLow() + ", 200DayMovingAvg: " + this.getTwoHundredMovingAverage() +
                ", Dividend Per Share: " + this.getDividendPerShare() + ", Book Value: " + this.BookValue + ", Profit Margin: "
                + this.ProfitMargin;
    }

}
