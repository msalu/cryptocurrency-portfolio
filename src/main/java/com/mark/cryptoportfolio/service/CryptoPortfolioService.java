package com.mark.cryptoportfolio.service;

import com.mark.cryptoportfolio.connector.BitfinexConnector;
import com.mark.cryptoportfolio.model.CryptoPortfolio;
import com.mark.cryptoportfolio.repository.CryptoPortfolioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CryptoPortfolioService {

    CryptoPortfolio cryptoPortfolio;
    BitfinexConnector bitfinexConnector;
    CryptoPortfolioRepository cryptoPortfolioRepository;

    public String createNewEntry(String symbol) {
       return bitfinexConnector.getDataFromBitfinex(symbol).getLast_price();

    }

    public String deleteFromCryptoPortfolio(int id) throws Exception {
        try{
            cryptoPortfolioRepository.deleteById(id);
            return "Entry deleted from portfolio";
        } catch (Exception e){
            throw new Exception("Internal Server Error");
        }

    }

    public String updateCryptoPortfolio(int id) throws Exception {
        Optional<CryptoPortfolio> oldPortfolio = cryptoPortfolioRepository.findById(id);
        if(oldPortfolio.isPresent()){
            CryptoPortfolio oldPortfolioItem = oldPortfolio.get();
            oldPortfolioItem.setCryptocurrencyName(cryptoPortfolio.getCryptocurrencyName());
            oldPortfolioItem.setAmountPurchased(cryptoPortfolio.getAmountPurchased());
            oldPortfolioItem.setDatetimeOfEntry(cryptoPortfolio.getDatetimeOfEntry());
            oldPortfolioItem.setWalletLocation(cryptoPortfolio.getWalletLocation());
            oldPortfolioItem.setMarketValuePurchase(cryptoPortfolio.getMarketValuePurchase());
            oldPortfolioItem.setCurrentMarketValue(cryptoPortfolio.getCurrentMarketValue());
            CryptoPortfolio response = cryptoPortfolioRepository.save(cryptoPortfolio);
            return "Entry updated";
        } else{
            throw new Exception("Entry not found");
        }
    }
}
