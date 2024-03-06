package com.techelevator.tenmo.model;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Account {

    private BigDecimal balance;
    private int accountId;
    private int userId;

    public Account() { }

    public Account(BigDecimal balance, int accountId, int userId) {
        this.balance = balance;
        this.accountId = accountId;
        this.userId = userId;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public int getAccountId() {
        return accountId;
    }

    public int getUserId() {
        return userId;
    }
}
