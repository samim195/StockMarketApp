package uk.stockfinder.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.method.RequestMappingInfo;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;
import uk.stockfinder.Stock;
import uk.stockfinder.StocksData;
import uk.stockfinder.service.StocksService;

import java.util.List;
import java.util.stream.Collectors;


@RestController
@RequestMapping("/stocks")
public class StocksController {

    @Autowired
    private StocksService stocksService;

    @Autowired
    StocksData stocksData;

    @Autowired
    private RequestMappingHandlerMapping requestMappingHandlerMapping;

    public StocksController(StocksService stocksService) {
        this.stocksService = stocksService;
    }

    @GetMapping("")
    public List<Stock> getStocks() throws Exception {
        List<Stock> allStocks = stocksService.getAllStocks();
        return allStocks;
    }

    @GetMapping("/name/{name}")
    public @ResponseBody List<Stock> getStockByName(@PathVariable("name") String name) throws Exception {
        return stocksService.getStockByName(name);
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
