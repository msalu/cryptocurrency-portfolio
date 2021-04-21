package com.mark.cryptoportfolio.service;

import com.mark.cryptoportfolio.connector.BitfinexConnector;
import com.mark.cryptoportfolio.model.CryptoPortfolio;
import com.mark.cryptoportfolio.repository.CryptoPortfolioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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

    public CryptoPortfolio createCryptoPortfolio(CryptoPortfolio cryptoPortfolio) {
        return cryptoPortfolioRepository.save(cryptoPortfolio);
    }

    public List<CryptoPortfolio> getAllCryptoPortfolio() {
        return cryptoPortfolioRepository.findAll();

    }

    public Optional<CryptoPortfolio> getCryptoPortfolioById(int id) throws Exception {
        Optional<CryptoPortfolio> portfolioData = cryptoPortfolioRepository.findById(id);
        if(portfolioData.isPresent()){
            return portfolioData;
        } else {
            throw new Exception("Entry not found");
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

    public HttpStatus deleteFromCryptoPortfolio(int id) {
        try{
            cryptoPortfolioRepository.deleteById(id);
            return HttpStatus.OK;
        } catch (Exception e){
            return HttpStatus.INTERNAL_SERVER_ERROR;
        }
    }

}
