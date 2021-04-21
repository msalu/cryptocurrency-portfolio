package com.mark.cryptoportfolio.service;

import com.mark.cryptoportfolio.connector.BitfinexConnector;
import com.mark.cryptoportfolio.model.CryptoPortfolio;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CryptoPortfolioService {

    BitfinexConnector bitfinexConnector;

    public String createNewEntry(String symbol) {
       return bitfinexConnector.getDataFromBitfinex(symbol).getLast_price();

    }
}
