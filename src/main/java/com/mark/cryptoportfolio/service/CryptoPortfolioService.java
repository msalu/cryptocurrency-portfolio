package com.mark.cryptoportfolio.service;

import com.mark.cryptoportfolio.connector.BitfinexConnector;
import com.mark.cryptoportfolio.model.CryptoPortfolio;
import com.mark.cryptoportfolio.repository.CryptoPortfolioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CryptoPortfolioService {

    private CryptoPortfolio cryptoPortfolio;
    private BitfinexConnector bitfinexConnector;
    private CryptoPortfolioRepository cryptoPortfolioRepository;

    @Autowired
    public CryptoPortfolioService(BitfinexConnector bitfinexConnector,
                                  CryptoPortfolioRepository cryptoPortfolioRepository) {
        this.bitfinexConnector = bitfinexConnector;
        this.cryptoPortfolioRepository = cryptoPortfolioRepository;
    }



//    public String createNewEntry(String symbol) {
//       return bitfinexConnector.getDataFromBitfinex(symbol).getLast_price();
//
//    }

    public String deleteFromCryptoPortfolio(int id) throws Exception {
        try{
            cryptoPortfolioRepository.deleteById(id);
            return "Entry deleted from portfolio";
        } catch (Exception e){
            throw new Exception("Internal Server Error");
        }

    }

    public CryptoPortfolio updateCryptoPortfolio(int id, CryptoPortfolio cryptoPortfolio) throws Exception {
        Optional<CryptoPortfolio> oldPortfolio = cryptoPortfolioRepository.findById(id);
        if(oldPortfolio.isPresent()){
            CryptoPortfolio oldPortfolioItem = oldPortfolio.get();
            oldPortfolioItem.setCryptocurrencyName(cryptoPortfolio.getCryptocurrencyName());
            oldPortfolioItem.setAmountPurchased(cryptoPortfolio.getAmountPurchased());
            oldPortfolioItem.setDatetimeOfEntry(cryptoPortfolio.getDatetimeOfEntry());
            oldPortfolioItem.setWalletLocation(cryptoPortfolio.getWalletLocation());
            oldPortfolioItem.setMarketValuePurchase(cryptoPortfolio.getMarketValuePurchase());
            oldPortfolioItem.setCurrentMarketValue(cryptoPortfolio.getCurrentMarketValue());
            return cryptoPortfolioRepository.save(oldPortfolioItem);
        } else {
            throw new Exception("Entry not found");
        }
    }

    public Optional<CryptoPortfolio> getCryptoPortfolioById(int id) throws Exception {
        Optional<CryptoPortfolio> portfolioData = cryptoPortfolioRepository.findById(id);
        if(portfolioData.isPresent()){
            return portfolioData;
        } else {
            throw new Exception("Entry not found");
        }
    }

    public List<CryptoPortfolio> getAllCryptoPortfolio() {
        return cryptoPortfolioRepository.findAll();

    }

    public CryptoPortfolio createCryptoPortfolio(CryptoPortfolio cryptoPortfolio) {
        return cryptoPortfolioRepository.save(cryptoPortfolio);
    }
}
