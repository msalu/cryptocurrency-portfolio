package com.mark.cryptoportfolio.repository;

import com.mark.cryptoportfolio.model.CryptoPortfolio;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CryptoPortfolioRepository extends JpaRepository<CryptoPortfolio, Integer> {

}
