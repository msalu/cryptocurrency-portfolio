package com.mark.cryptoportfolio.connector;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import org.json.JSONException;
import org.json.JSONObject;

import org.springframework.stereotype.Component;


@Component
public class BitfinexConnector {

    public String getBitfinexApi(String symbols) throws UnirestException, JSONException {
        HttpResponse<String> response = Unirest.get("https://api.bitfinex.com/v1/pubticker/" + symbols)
                .header("bitfinex-api", "api.bitfinex.com/v1/pubticker")
                .asString();
        String jsonString = response.getBody();
        JSONObject jsonObj = null;
        try {
            jsonObj = new JSONObject(jsonString);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jsonObj.getString("last_price");
    }


}
