package com.ferraro.concurrencyexchange;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PageController {

    @GetMapping("/page")
    public String getPage(){
        return "page";
    }
}
