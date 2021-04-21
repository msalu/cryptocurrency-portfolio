package com.mark.cryptoportfolio.connector;

import com.mark.cryptoportfolio.model.BitfinexApi;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class BitfinexConnector {

    RestTemplate restTemplate = new RestTemplate();

    public BitfinexApi getDataFromBitfinex(String symbol){
        String url = "https://api.bitfinex.com/v1/pubticker/" + symbol;
        ResponseEntity<BitfinexApi> responseEntity = restTemplate.getForEntity(url, BitfinexApi.class);
        return responseEntity.getBody();
    }
}
