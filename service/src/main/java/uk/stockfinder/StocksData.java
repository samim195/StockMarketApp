package uk.stockfinder;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.util.List;

@Getter
@Setter
@Component
public class StocksData {
    private List<Stock> data;
}
