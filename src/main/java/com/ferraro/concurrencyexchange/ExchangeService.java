package com.ferraro.concurrencyexchange;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;
@Service
public class ExchangeService {

    private RestTemplate template = new RestTemplate();
    private ObjectMapper mapper = new ObjectMapper();

    @Value("${app.api.key}")
    private String API_KEY;
    private String baseUrl = "https://api.freecurrencyapi.com/v1/latest?apikey=";


    public Double getResult(Double givenValue, Currency baseCurrency, Currency convertTo){
        System.out.println(API_KEY);
       String requestUrl = baseUrl+API_KEY+"&base_currency="+baseCurrency+"&currencies="+convertTo;
        JsonNode node;
        try {
            System.out.println(baseUrl);
            String response = template.getForObject(requestUrl, String.class);
            System.out.println(response);
            node = mapper.readTree(response);
        }
        catch(JsonProcessingException | RestClientException e){
            e.printStackTrace();
            throw new IllegalStateException();
        }
        System.out.println("NODE "+node.get("data").get(convertTo.toString()));

        Double exchangeRate = node.get("data").get(convertTo.toString()).asDouble();
        System.out.println(exchangeRate);
        return givenValue * exchangeRate;
    }


}
