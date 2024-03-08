package com.techelevator.tenmo.controller;

import com.techelevator.tenmo.dao.AccountDao;
import com.techelevator.tenmo.dao.UserDao;
import com.techelevator.tenmo.model.Transfer;
import com.techelevator.tenmo.model.User;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.security.Principal;
import java.util.List;

@RestController
@PreAuthorize("isAuthenticated()")
public class AccountController {
    private final AccountDao accountDao;
    private UserDao userDao;


    public AccountController(AccountDao accountDao, UserDao userDao) {
        this.accountDao = accountDao;
        this.userDao = userDao;
    }

    @RequestMapping(path = "/account", method = RequestMethod.GET)
    public BigDecimal get(Principal principal) {
        String userName = principal.getName();
        User user = userDao.getUserByUsername(userName);

        BigDecimal balance = accountDao.getBalanceByUserId(user.getId());
        return balance;
    }

    @PreAuthorize("permitAll()")
    @RequestMapping(path = "/tenmo_user", method = RequestMethod.GET)
    public List<User> userList() {
        List<User> users = userDao.getUsers();
        return users;
    }


}

