package com.techelevator.tenmo.controller;

import com.techelevator.tenmo.dao.AccountDao;
import com.techelevator.tenmo.model.Account;
import org.springframework.http.HttpStatus;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;

import com.techelevator.tenmo.security.jwt.TokenProvider;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.math.BigDecimal;
@RestController
public class AccountController {
    private final AccountDao accountDao;


    public AccountController(AccountDao accountDao) {
        this.accountDao = accountDao;
    }

    @RequestMapping(path = "/account/{id}", method = RequestMethod.GET)
    public BigDecimal get(@PathVariable int id) {
        BigDecimal balance = accountDao.getBalanceByUserId(id);
        return balance;
    }

}

