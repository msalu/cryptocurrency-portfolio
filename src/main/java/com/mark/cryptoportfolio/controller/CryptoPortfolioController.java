package com.mark.cryptoportfolio.controller;


import com.mark.cryptoportfolio.model.CryptoPortfolio;
import com.mark.cryptoportfolio.service.CryptoPortfolioService;
import com.mashape.unirest.http.exceptions.UnirestException;
import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/v1/portfolio")
public class CryptoPortfolioController {

    private final CryptoPortfolioService cryptoPortfolioService;

    @Autowired
    public CryptoPortfolioController(CryptoPortfolioService cryptoPortfolioService) {
        this.cryptoPortfolioService = cryptoPortfolioService;
    }

    @PostMapping("/create")
    public ResponseEntity<CryptoPortfolio> createCryptoPortfolio(@RequestBody CryptoPortfolio cryptoPortfolio) {
        return ResponseEntity.ok(cryptoPortfolioService.createCryptoPortfolio(cryptoPortfolio));
    }

    @GetMapping("/get-all")
    public ResponseEntity<List<CryptoPortfolio>> getAllCryptoPortfolio() {
        return ResponseEntity.ok(cryptoPortfolioService.getAllCryptoPortfolio());
    }

    @GetMapping("/get")
    public ResponseEntity<Optional<CryptoPortfolio>> getCryptoPortfolioById(@RequestParam("id") int id) throws Exception {
        return ResponseEntity.ok(cryptoPortfolioService.getCryptoPortfolioById(id));
    }

    @PutMapping("/update")
    public ResponseEntity<CryptoPortfolio> updateCryptoPortfolio(@RequestParam("id") int id,
                                                                 @RequestBody CryptoPortfolio cryptoPortfolio) throws Exception {
        return ResponseEntity.ok(cryptoPortfolioService.updateCryptoPortfolio(id, cryptoPortfolio));
    }

    @DeleteMapping("/delete")
    public ResponseEntity<HttpStatus> deleteFromCryptoPortfolio(@RequestParam("id") int id) {
        return ResponseEntity.ok(cryptoPortfolioService.deleteFromCryptoPortfolio(id));
    }

    @GetMapping("/bitfinex")
    public ResponseEntity<String> getCurrencyMarketPrice(@RequestParam("symbols") String symbols) throws UnirestException, JSONException {
        return ResponseEntity.ok(cryptoPortfolioService.getCurrencyMarketPrice(symbols));
    }


}
