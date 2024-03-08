package com.techelevator.tenmo.dao;

import com.techelevator.tenmo.model.Account;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class JdbcAccountDao implements AccountDao {

    private final JdbcTemplate jdbcTemplate;

    public JdbcAccountDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


    @Override
    public BigDecimal getBalanceByUserId(int id) {
        BigDecimal balance = null;
        String sql = "SELECT balance FROM account WHERE user_id = ?";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, id);
        if (results.next()) {
            balance = results.getBigDecimal("balance");
        }
        return balance;
    }
    private Account findAccountById(int id) {
        Account account = null;
        
    }

    public Account getAccountById(int id) {
        Account account = null;
        String sql = "SELECT * FROM account WHERE account_id = ?";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, id);
        if(results.next()) {
            account
        }
    }
    public BigDecimal addToBalance(BigDecimal amountToAdd, int id) {
        Account account =
    }



}
