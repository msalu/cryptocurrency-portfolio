package com.mark.cryptoportfolio.model;

import lombok.Data;

@Data
public class BitfinexApi {

    private String mid;
    private String bid;
    private String ask;
    private String last_price;
    private String low;
    private String high;
    private String volume;
    private String timestamp;

}
