package com.techelevator.tenmo.services;

import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;

public class AccountService {

    private static String BASE_URL = "http://localhost:8080";
    private static final RestTemplate restTemplate = new RestTemplate();

    public AccountService(String BASE_URL) {
        this.BASE_URL = BASE_URL;
    }

    public static BigDecimal getBalance(int id) {
        return restTemplate.getForObject (BASE_URL + "/account/" + id, BigDecimal.class);
    }
}

