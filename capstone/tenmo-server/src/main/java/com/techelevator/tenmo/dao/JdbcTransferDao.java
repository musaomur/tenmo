package com.techelevator.tenmo.dao;

import com.techelevator.tenmo.model.Transfer;
import com.techelevator.tenmo.model.User;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
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


    public void transferFunds() {

    }

    @Override
    public List<Transfer> getAllByUserId(int userId) {
        List<Transfer> transfers = new ArrayList<>();
        String sql = "SELECT t.transfer_id, t.transfer_type_id, t.transfer_status_id, t.account_from, t.account_to, t.amount " +
                "FROM transfer AS t " +
                "JOIN account AS a1 ON a1.account_id = t.account_from " +
                "JOIN account AS a2 ON a2.account_id = t.account_to " +
                "WHERE a1.user_id = ? OR a2.user_id = ?";
7

        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, userId, userId);
        while (results.next()) {
            transfers.add(map(results));
        }
        return transfers;
    }

    @Override
    public Transfer getById(int id) {
        List<Transfer> transfers = new ArrayList<>();
        String sql = "SELECT transfer_id, transfer_type_id, transfer_status_id, account_from, account_to, amount " +
                "FROM transfer " +
                "WHERE transfer_id = ?";

        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, id);
        if (results.next()) {
            return map(results);
        }
        return null;
    }
//    @Override
//    public String transferFunds(int account_from, int account_to, BigDecimal amount){
//        if(account_from == account_to){
//            return "You can not send money yourself";
//        }
//        if((amount.compareTo(amount)) && (amount.compareTo(BigDecimal))){
//
//        }
//
//        BigDecimal updatedBalance = new BigDecimal(0);
//        //BigDecimal amount = Transfer.
//        String sqlSend = "SELECT balance - amount FROM account WHERE user_id = " + ;
//        SqlRowSet result = jdbcTemplate.queryForRowSet(sqlSend);
//        //String sqlRetrieved = "SELECT balance + ? FROM account WHERE user_id = ?";
//        updatedBalance = result.getBigDecimal();
//        //return updatedBalance;
//    }

    private Transfer map(SqlRowSet rs) {
        Transfer transfer = new Transfer();
        transfer.setTransfer_id(rs.getInt("transfer_id"));
        transfer.setTransfer_type_id(rs.getInt("transfer_type_id"));
        transfer.setTransfer_status_id(rs.getInt("transfer_status_id"));
        transfer.setAccount_from(rs.getInt("account_from"));
        transfer.setAccount_to(rs.getInt("account_to"));
        transfer.setAmount(rs.getBigDecimal("amount"));
        return transfer;
    }
}
