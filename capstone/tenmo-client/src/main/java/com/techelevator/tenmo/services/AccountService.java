package com.techelevator.tenmo.services;

import com.techelevator.tenmo.model.AuthenticatedUser;
import com.techelevator.tenmo.model.User;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
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

    public void setCurrentUser(AuthenticatedUser currentUser) {
        this.currentUser = currentUser;
    }

    private AuthenticatedUser currentUser;

    public BigDecimal getBalance(int id) {
        ResponseEntity<BigDecimal> response =
                restTemplate.exchange(BASE_URL + "/account", HttpMethod.GET, makeAuthEntity(), BigDecimal.class);
//        return restTemplate.getForObject(BASE_URL + "/account", BigDecimal.class);
        return response.getBody();
    }

    public static List<User> getUsers() {
        ResponseEntity<List<User>> responseEntity = restTemplate.exchange(BASE_URL + "/tenmo_user/",
                HttpMethod.GET, null,
                new ParameterizedTypeReference<List<User>>() {
                }
        );
        List<User> users = responseEntity.getBody();
//        for (User user : users) {
//            if (user.getId() == currentUser.getUser().getId()) {
//            } else
//                System.out.println(user.getId() + " || " + user.getUsername());
//        }
        return users;
    }

    private HttpEntity<Void> makeAuthEntity() {
        HttpHeaders headers = new HttpHeaders();
        headers.setBearerAuth(currentUser.getToken());
        return new HttpEntity<>(headers);
    }
}

