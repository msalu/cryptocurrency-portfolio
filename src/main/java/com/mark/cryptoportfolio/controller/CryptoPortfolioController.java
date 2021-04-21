package com.mark.cryptoportfolio.controller;

import com.mark.cryptoportfolio.model.CryptoPortfolio;
import com.mark.cryptoportfolio.service.CryptoPortfolioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/v1/portfolio")
public class CryptoPortfolioController {

    private CryptoPortfolioService cryptoPortfolioService;

    @Autowired
    public CryptoPortfolioController(CryptoPortfolioService cryptoPortfolioService) {
        this.cryptoPortfolioService = cryptoPortfolioService;
    }

//    @GetMapping("/create")
//    public ResponseEntity<String> createNewEntry(@RequestParam("symbol") String symbol) {
//        return ResponseEntity.ok(cryptoPortfolioService.createNewEntry(symbol));
//    }

    @PostMapping("/create")
    public ResponseEntity<CryptoPortfolio> createCryptoPortfolio(@RequestBody CryptoPortfolio cryptoPortfolio){
        return ResponseEntity.ok(cryptoPortfolioService.createCryptoPortfolio(cryptoPortfolio));
    }

    @GetMapping("/get-all")
    public ResponseEntity<List<CryptoPortfolio>> getAllCryptoPortfolio (){
        return ResponseEntity.ok(cryptoPortfolioService.getAllCryptoPortfolio());
    }

    @GetMapping("/get")
    public ResponseEntity<Optional<CryptoPortfolio>> getCryptoPortfolioById (@RequestParam("id") int id) throws Exception {
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

}
