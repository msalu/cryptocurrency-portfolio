package com.mark.cryptoportfolio.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Timestamp;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "cryptoportfolio")
public class CryptoPortfolio {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "symbol")
    private String cryptocurrencyName;

    @Column(name = "amount")
    private float amountPurchased;

    @Column(name = "date")
    private LocalDateTime datetimeOfEntry;

    @Column(name = "wallet")
    private String walletLocation;

    @Column(name = "market_value_purchase")
    private float marketValuePurchase;

    @Column(name = "current_market_value")
    private float currentMarketValue;
}
