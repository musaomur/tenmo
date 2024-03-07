package com.techelevator.tenmo.controller;

import com.techelevator.tenmo.dao.AccountDao;
import com.techelevator.tenmo.dao.UserDao;
import com.techelevator.tenmo.model.User;

import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@RestController
public class AccountController {
    private final AccountDao accountDao;
    private UserDao userDao;


    public AccountController(AccountDao accountDao, UserDao userDao) {
        this.accountDao = accountDao;
        this.userDao = userDao;
    }

    @RequestMapping(path = "/account/{id}", method = RequestMethod.GET)
    public BigDecimal get(@PathVariable int id) {
        BigDecimal balance = accountDao.getBalanceByUserId(id);
        return balance;
    }

    @RequestMapping(path = "/tenmo_user", method = RequestMethod.GET)
    public List<User> userList() {
        List<User> users = userDao.getUsers();
        return users;
    }

}

