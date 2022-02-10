package uk.stockfinder.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.method.RequestMappingInfo;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;
import uk.stockfinder.entity.Stock;
import uk.stockfinder.factory.ReaderFactoryImpl;
import uk.stockfinder.service.StocksService;
import uk.stockfinder.service.StocksServiceImpl;

import java.util.Collections;
import java.util.List;
import java.util.logging.Logger;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/stocks")
public class StocksController {

    protected Logger logger = Logger.getLogger(StocksController.class.getName());

    @Autowired
    private RequestMappingHandlerMapping requestMappingHandlerMapping;

    private final StocksService stocksService = new StocksServiceImpl(new ReaderFactoryImpl());

    @GetMapping("")
    public List<Stock> getStocks() throws Exception {
        logger.info("Stocks get all invoked");
        return stocksService.getAllStocks();
    }

    @GetMapping("/name/{name}")
    public @ResponseBody
    List<Stock> getStockByName(@PathVariable("name") String name) throws Exception {
        if (name.isEmpty()) {
            return Collections.emptyList();
        }
        logger.info("Stocks find by name: " + name + " invoked");
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
