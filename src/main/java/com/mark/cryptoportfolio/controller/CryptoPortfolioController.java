package com.mark.cryptoportfolio.controller;

import com.mark.cryptoportfolio.model.CryptoPortfolio;
import com.mark.cryptoportfolio.service.CryptoPortfolioService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/v1")
@RequiredArgsConstructor
public class CryptoPortfolioController {

    private final CryptoPortfolioService cryptoPortfolioService;

    @PutMapping("/pubticker")
    public ResponseEntity<String> createNewEntry(@RequestParam("symbol") String symbol)
                                                               /* @RequestParam("amount") float amount,
                                                                @RequestParam("wallet") String wallet)*/{
        return ResponseEntity.ok(cryptoPortfolioService.createNewEntry(symbol));
    }

}
