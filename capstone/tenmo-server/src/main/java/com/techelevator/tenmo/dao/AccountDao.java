package com.techelevator.tenmo.dao;

import com.techelevator.tenmo.model.Account;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import java.math.BigDecimal;

public interface AccountDao {

    BigDecimal getBalanceByUserId(int id);


    Account mapRowToAccount(SqlRowSet results);

    BigDecimal addBalance(BigDecimal amountToAdd, int id);

    BigDecimal subtractBalance(BigDecimal amountToSubtract, int id);
}
