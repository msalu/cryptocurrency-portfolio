package com.mark.cryptoportfolio.connector;

import com.mark.cryptoportfolio.model.BitfinexApi;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import org.springframework.stereotype.Component;


@Component
public class BitfinexConnector {

    public String getBitfinexApi(String symbols) throws UnirestException {
        HttpResponse<String> response = Unirest.get("https://api.bitfinex.com/v1/pubticker/" + symbols)
                .header("bitfinex-api", "api.botfinex.com/v1/pubticker")
                .asString();
        return response.getBody();

    }



        /*ObjectMapper objectMapper = new ObjectMapper();


        String jsonArray = response.getBody();
        try {
            BitfinexApi bitfinexObj = objectMapper.readValue(jsonArray, BitfinexApi.class);
            System.out.println("Last price: " + bitfinexObj.getLast_price());
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }*/



     /*RestTemplate restTemplate = new RestTemplate();

    public BitfinexApi getBitfinexData(String symbols) {
        String url = "https://api-pub.bitfinex.com/v2/tickers/";
        ResponseEntity<BitfinexApi> responseEntity = restTemplate.getForEntity(url + symbols, BitfinexApi.class);
        return responseEntity.getBody();
    }*/


//    RestTemplate rt = new RestTemplate();
//    HttpHeaders headers = new HttpHeaders();
//        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
//        headers.add("user-agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/54.0.2840.99 Safari/537.36");
//    HttpEntity<String> entity = new HttpEntity<String>("parameters", headers);
//    String url = "https://jsonplaceholder.typicode.com/posts/1";
//    ResponseEntity<String> res = rt.exchange(url, HttpMethod.GET, entity, String.class);
//        System.out.println(res);

}
