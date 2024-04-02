package com.ferraro.concurrencyexchange;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/rest/api/v0")
public class APIController {
    @Autowired
    private ExchangeService service;
    @GetMapping("/result/{baseCurrency}/{convertTo}")
    public ResponseEntity<Double> getResult(@PathVariable("baseCurrency")Currency baseCurrency, @PathVariable("convertTo") Currency convertTo,
    @RequestParam(value = "value", required = true) Double value){
        System.out.println(baseCurrency+" "+convertTo);
        return ResponseEntity.ok(service.getResult(value, baseCurrency, convertTo));
    }
}
