package com.techelevator.tenmo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;



@SpringBootApplication
public class TenmoApplication {


    public static void main(String[] args) {
        SpringApplication.run(TenmoApplication.class, args);
    }

}
