package com.techelevator.tenmo.dao;

import com.techelevator.tenmo.model.Transfer;
import org.springframework.http.HttpStatus;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import com.techelevator.tenmo.model.Account;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;

@Component
public class JdbcTransferDao implements TransferDao {
    private final JdbcTemplate jdbcTemplate;
    //private static AuthenticatedUser currentUser;
    private final AccountDao accountDao;





    public JdbcTransferDao(JdbcTemplate jdbcTemplate, AccountDao accountDao) {
        this.jdbcTemplate = jdbcTemplate;
        this.accountDao = accountDao;
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

    public Account getAccountFromId(int userId) {
        Account account = null;
        String sql = "SELECT * FROM accounts WHERE account_id = ?";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, userId);
        if (results.next()) {
            account = accountDao.mapRowToAccount(results);
        }
        return account;
    }
    @Override
    public void transferFunds(Transfer transfer) {
         Account accountFrom = getAccountFromId(transfer.getAccountFrom());
        Account accountTo = getAccountFromId(transfer.getAccountTo());
        BigDecimal balanceFrom = accountDao.getBalanceByUserId(transfer.getAccountFrom());
        BigDecimal balanceTo = accountDao.getBalanceByUserId(transfer.getAccountTo());
        BigDecimal transferAmount = transfer.getAmount();
        if (accountFrom == accountTo) {
            throw new ResponseStatusException(HttpStatus.EXPECTATION_FAILED, "YOUR TRANSFER CANNOT BE COMPLETED");
        }
        if (transferAmount.compareTo(balanceFrom) > 0 || transferAmount.compareTo(BigDecimal.valueOf(0)) <= 0 ) {
            throw new ResponseStatusException(HttpStatus.EXPECTATION_FAILED,"YOUR TRANSFER CANNOT BE COMPLETED") ;
        } else {
            accountDao.addBalance(transferAmount, accountTo.getAccountId());
            accountDao.subtractBalance(transferAmount, accountFrom.getAccountId());
            System.out.println();
        }

    }

    @Override
    public List<Transfer> getAllByUserId(int userId) {
        List<Transfer> transfers = new ArrayList<>();
        String sql = "SELECT t.transfer_id, t.transfer_type_id, t.transfer_status_id, t.account_from, t.account_to, t.amount " +
                "FROM transfer AS t " +
                "JOIN account AS a1 ON a1.account_id = t.account_from " +
                "JOIN account AS a2 ON a2.account_id = t.account_to " +
                "WHERE a1.user_id = ? OR a2.user_id = ?";

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


    private Transfer map(SqlRowSet rs) {
        Transfer transfer = new Transfer();
        transfer.setTransferId(rs.getInt("transfer_id"));
        transfer.setTransferTypeId(rs.getInt("transfer_type_id"));
        transfer.setTransferStatusId(rs.getInt("transfer_status_id"));
        transfer.setAccountFrom(rs.getInt("account_from"));
        transfer.setAccountTo(rs.getInt("account_to"));
        transfer.setAmount(rs.getBigDecimal("amount"));
        return transfer;
    }



}
