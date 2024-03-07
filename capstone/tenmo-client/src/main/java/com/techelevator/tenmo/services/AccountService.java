package com.techelevator.tenmo.services;

import com.techelevator.tenmo.model.AuthenticatedUser;
import com.techelevator.tenmo.model.User;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.util.List;
import java.util.prefs.BackingStoreException;

public class AccountService {

    private static String BASE_URL = "http://localhost:8080";
    private static final RestTemplate restTemplate = new RestTemplate();
    private static AuthenticatedUser currentUser = null;


    public AccountService(String BASE_URL, AuthenticatedUser currentUser) {
        this.BASE_URL = BASE_URL;
        this.currentUser = currentUser;
    }

    public static BigDecimal getBalance(int id) {
        return restTemplate.getForObject(BASE_URL + "/account/" + id, BigDecimal.class);
    }

    public static List<User> getUsers() {
        ResponseEntity<List<User>> responseEntity = restTemplate.exchange(BASE_URL + "/tenmo_user/",
                HttpMethod.GET, null,
                new ParameterizedTypeReference<List<User>>() {
                }
        );
        List<User> users = responseEntity.getBody();
        for (User user : users) {
            if (user.getId() == currentUser.getUser().getId()) {
            } else
                System.out.println(user.getId() + " " + user.getUsername());
        }
        return users;
    }
}

