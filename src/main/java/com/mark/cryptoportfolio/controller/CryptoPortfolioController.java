package com.mark.cryptoportfolio.controller;

import com.mark.cryptoportfolio.model.CryptoPortfolio;
import com.mark.cryptoportfolio.service.CryptoPortfolioService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @DeleteMapping("/delete")
    public ResponseEntity<String> deleteFromCryptoPortfolio(@RequestParam("id") int id) throws Exception {
        return ResponseEntity.ok(cryptoPortfolioService.deleteFromCryptoPortfolio(id));
    }

    @PutMapping("/update")
    public ResponseEntity<String> updateCryptoPortfolio(@RequestParam("id") int id) throws Exception {
        return ResponseEntity.ok(cryptoPortfolioService.updateCryptoPortfolio(id));
    }


    @GetMapping("/get")
    public ResponseEntity<String> getCryptoPortfolioById (@RequestParam("id") int id) throws Exception {
        return ResponseEntity.ok(cryptoPortfolioService.getCryptoPortfolioById(id));
    }

    @GetMapping("/get-all")
    public ResponseEntity<List<CryptoPortfolio>> getAllCryptoPortfolio (){
        return ResponseEntity.ok(cryptoPortfolioService.getAllCryptoPortfolio());
    }

    @PostMapping("/create")
    public ResponseEntity<CryptoPortfolio> createCryptoPortfolio(@RequestBody CryptoPortfolio cryptoPortfolio){
        return ResponseEntity.ok(cryptoPortfolioService.createCryptoPortfolio(cryptoPortfolio));
    }
}
