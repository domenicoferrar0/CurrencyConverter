package com.ferraro.concurrencyexchange;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;
@Service
public class ExchangeService {

    private String baseCurrency = "";
    private String convertTo = "";

    private RestTemplate template = new RestTemplate();
    private ObjectMapper mapper = new ObjectMapper();

    private String API_KEY = "fca_live_WadNSRXS4OGm1Pr6UNkdXW1Sn9EHoKmuzZodHCJi";
    private String baseUrl = "https://api.freecurrencyapi.com/v1/latest?apikey=" + API_KEY;


    public Double getResult(Double givenValue, Currency baseCurrency, Currency convertTo){
       String requestUrl = baseUrl+"&base_currency="+baseCurrency+"&currencies="+convertTo;
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
