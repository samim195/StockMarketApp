package uk.stockfinder.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.method.RequestMappingInfo;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;
import uk.stockfinder.entity.AlphaVantageStock;
import uk.stockfinder.factory.StockServiceFactory;
import uk.stockfinder.service.InvestmentStrategyBalanceSheet;
import uk.stockfinder.service.InvestmentStrategyService;
import uk.stockfinder.service.StocksService;

import java.io.IOException;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/stocks")
public class StocksController {

    protected Logger logger = Logger.getLogger(StocksController.class.getName());

    @Autowired
    private RequestMappingHandlerMapping requestMappingHandlerMapping;

    private final StocksService stocksService = StockServiceFactory.createStockService();

    @GetMapping("")
//    public List<AlphaVantageStock> getStocks() throws Exception {
    public void getStocks() throws Exception {
        logger.info("Stocks get all invoked");
//        return stocksService.getAllStocks();
        InvestmentStrategyService investmentStrategyService = new InvestmentStrategyBalanceSheet();
        List<AlphaVantageStock> allStocks = stocksService.getAllStocks();
        allStocks.forEach(stock -> {
            try {
                investmentStrategyService.evaluateStockByCompanyOverview(stock.getSymbol());
                TimeUnit.SECONDS.sleep(15);
            } catch (IOException | InterruptedException e) {
                e.printStackTrace();
            }
        });
    }

    @GetMapping("/name/{name}")
    public @ResponseBody
    List<AlphaVantageStock> getStockByName(@PathVariable("name") String name) throws Exception {
        if (name.isEmpty()) {
            return Collections.emptyList();
        }
        logger.info("Stocks find by name: " + name + " invoked");
        return stocksService.getStockByName(name);
    }

    @GetMapping("/peterlynch")
    public @ResponseBody
    List<AlphaVantageStock> getStockByRules(@RequestParam Optional<String> priceEarnings2022, @RequestParam Optional<String> price) throws Exception {
//        logger.info("Stocks find by name: " + name + " invoked");
        return stocksService.getStockByUserRules(Double.parseDouble(priceEarnings2022.get()), Double.parseDouble(price.get()));
    }

    @GetMapping("endpoints")
    public ResponseEntity<List<String>> getEndpoints() {
        return new ResponseEntity<>(
                requestMappingHandlerMapping
                        .getHandlerMethods()
                        .keySet()
                        .stream()
                        .map(RequestMappingInfo::toString)
                        .collect(Collectors.toList()),
                HttpStatus.OK
        );
    }
}
