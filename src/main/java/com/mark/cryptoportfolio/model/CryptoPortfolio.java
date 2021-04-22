package com.mark.cryptoportfolio.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;
import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table
@Component
public class CryptoPortfolio {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @JsonProperty("symbols")
    private String cryptocurrencyName;

    @JsonProperty("amount")
    private float amountPurchased;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm")
    @JsonProperty("date")
    LocalDateTime localDateTime = LocalDateTime.now();

    @JsonProperty("wallet")
    private String walletLocation;

    @JsonProperty("market_value_purchase")
    private float marketValuePurchase;

    @JsonProperty("current_market_value")
    private float currentMarketValue;
}