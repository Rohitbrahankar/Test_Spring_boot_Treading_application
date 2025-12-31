package com.example.demo.Controller;


import com.example.demo.Entity.TradeRequest;
import com.example.demo.services.TradingServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/trade")
public class TreadingController {

    @Autowired
    private TradingServices tradingService;


    @PostMapping("/buy")
    public ResponseEntity<String> buyStock(@RequestBody TradeRequest request) {
        tradingService.buyStock(request);
        return ResponseEntity.ok("Stock bought successfully");
    }


    @PostMapping("/sell")
    public ResponseEntity<String> sellStock(@RequestBody TradeRequest request) {
        tradingService.sellStock(request);
        return ResponseEntity.ok("Stock sold successfully");
    }
}
