package com.techelevator.tenmo.dao;

import com.techelevator.tenmo.model.Transfer;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;

public class JdbcTransferDao implements TransferDao {
    private final JdbcTemplate jdbcTemplate;
    //private static AuthenticatedUser currentUser;


    public JdbcTransferDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<String> getUserList() {
        List<String> userList = new ArrayList<>();
        String sql = "SELECT username, user_id FROM tenmo_user";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
        while (results.next()) {
            userList.add(results.getString("username" + " user_id"));
        }
        return userList;
    }
    @Override
    public String transferFunds(int account_from, int account_to, BigDecimal amount){
        if(account_from == account_to){
            return "You can not send money yourself";
        }
        if((amount.compareTo(amount)) && (amount.compareTo(BigDecimal))){

        }

        BigDecimal updatedBalance = new BigDecimal(0);
        //BigDecimal amount = Transfer.
        String sqlSend = "SELECT balance - amount FROM account WHERE user_id = " + ;
        SqlRowSet result = jdbcTemplate.queryForRowSet(sqlSend);
        //String sqlRetrieved = "SELECT balance + ? FROM account WHERE user_id = ?";
        updatedBalance = result.getBigDecimal();
        //return updatedBalance;
    }

}
