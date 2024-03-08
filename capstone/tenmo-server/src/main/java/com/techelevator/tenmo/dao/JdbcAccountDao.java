package com.techelevator.tenmo.dao;

import com.techelevator.tenmo.model.Account;
import org.springframework.dao.DataAccessException;
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


    private Account getAccountFromId(int userId) {
        Account account = null;
        String sql = "SELECT * FROM accounts WHERE account_id = ?";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, userId);
        if (results.next()) {
            account = mapRowToAccount(results);
        }
        return account;
    }

    private Account mapRowToAccount(SqlRowSet result) {
        Account account = new Account();
        account.setBalance(result.getBigDecimal("balance"));
        account.setAccountId(result.getInt("account_id"));
        account.setUserId(result.getInt("user_id"));
        return account;
    }
    public BigDecimal addBalance(BigDecimal amountToAdd, int id) {
        Account account = getAccountFromId(id);
        BigDecimal newBalance = account.getBalance().add(amountToAdd);
        System.out.println(newBalance);
        String sqlString = "UPDATE accounts SET balance = ? WHERE user_id = ?";
        try {
            jdbcTemplate.update(sqlString, newBalance, id);
        } catch (DataAccessException e) {
            System.out.println("Cannot Access");
        }
        return account.getBalance();
    }
    public BigDecimal subtractBalance(BigDecimal amountToSubtract, int id) {
        Account account = getAccountFromId(id);
        BigDecimal newBalance = account.getBalance().subtract(amountToSubtract);
        String sqlString = "UPDATE accounts SET balance = ? WHERE user_id = ?";
        try {
            jdbcTemplate.update(sqlString, newBalance, id);
        } catch (DataAccessException e) {
            System.out.println("Cannot Access");
        }
        return account.getBalance();
    }




}
