package com.mark.cryptoportfolio.controller;

import com.mark.cryptoportfolio.model.CryptoPortfolio;
import com.mark.cryptoportfolio.service.CryptoPortfolioService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/portfolio")
@RequiredArgsConstructor
public class CryptoPortfolioController {

    private final CryptoPortfolioService cryptoPortfolioService;

    @GetMapping("/create")
    public ResponseEntity<String> createNewEntry(@RequestParam("symbol") String symbol) {
        return ResponseEntity.ok(cryptoPortfolioService.createNewEntry(symbol));
    }

    @DeleteMapping("/delete")
    public ResponseEntity<String> deleteFromCryptoPortfolio(@RequestParam("id") int id) throws Exception {
        return ResponseEntity.ok(cryptoPortfolioService.deleteFromCryptoPortfolio(id));
    }

    @PutMapping("/update")
    public ResponseEntity<String> updateCryptoPortfolio(@RequestParam("id") int id) throws Exception {
        return ResponseEntity.ok(cryptoPortfolioService.updateCryptoPortfolio(id));
    }


}
