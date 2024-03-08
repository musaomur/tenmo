package com.techelevator.tenmo.services;
import com.techelevator.tenmo.model.AuthenticatedUser;
import com.techelevator.tenmo.model.Transfer;
import com.techelevator.tenmo.model.User;
import com.techelevator.tenmo.model.UserCredentials;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;



import java.math.BigDecimal;
import java.util.List;
import java.util.Scanner;
public class TransferService {
    private static String BASE_URL = "http://localhost:8080";
    private static final RestTemplate restTemplate = new RestTemplate();
    private static AuthenticatedUser currentUser;

    public TransferService() { }

    public void sendBucks() {
        User[] users = null;
        Transfer transfer = new Transfer();
        try {
            Scanner scanner = new Scanner(System.in);
        }

    }

}


