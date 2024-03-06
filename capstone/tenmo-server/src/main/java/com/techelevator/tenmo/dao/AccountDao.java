package com.techelevator.tenmo.dao;

import com.techelevator.tenmo.model.Account;

public interface AccountDao {
    Account getBalance();
    Account getBalanceByUserId(int id);


}
