package com.techelevator.tenmo.controller;

import com.techelevator.tenmo.dao.AccountDao;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import com.techelevator.tenmo.model.User;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

public class TransferController {
    private final AccountDao accountDao;
    private final JdbcTemplate jdbcTemplate;

    public TransferController(AccountDao accountDao, JdbcTemplate jdbcTemplate) {
        this.accountDao = accountDao;
        this.jdbcTemplate = jdbcTemplate;
    }

    public BigDecimal get(@PathVariable int id) {
        BigDecimal balance = accountDao.getBalanceByUserId(id);
        return balance;
    }
}
