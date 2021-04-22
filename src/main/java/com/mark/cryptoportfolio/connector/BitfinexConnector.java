package com.mark.cryptoportfolio.connector;

import com.mark.cryptoportfolio.model.BitfinexApi;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;


@Component
public class BitfinexConnector {

    RestTemplate restTemplate = new RestTemplate();

    public BitfinexApi getBitfinexData() {
        String url = "https://api-pub.bitfinex.com/v2/ticker/tBTCUSD";
        ResponseEntity<BitfinexApi> responseEntity = restTemplate.getForEntity(url, BitfinexApi.class);
        return responseEntity.getBody();
    }


//    RestTemplate rt = new RestTemplate();
//    HttpHeaders headers = new HttpHeaders();
//        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
//        headers.add("user-agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/54.0.2840.99 Safari/537.36");
//    HttpEntity<String> entity = new HttpEntity<String>("parameters", headers);
//    String url = "https://jsonplaceholder.typicode.com/posts/1";
//    ResponseEntity<String> res = rt.exchange(url, HttpMethod.GET, entity, String.class);
//        System.out.println(res);

}
