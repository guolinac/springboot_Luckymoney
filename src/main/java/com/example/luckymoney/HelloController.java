package com.example.luckymoney;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
public class HelloController {
    @Value("${minMoney}")
    private BigDecimal minMoney;

    @Value("${description}")
    private String description;

    @GetMapping("/hello")
    public String say() {
        return "minMoney:" + minMoney + "，说明:" + description;
    }
}
