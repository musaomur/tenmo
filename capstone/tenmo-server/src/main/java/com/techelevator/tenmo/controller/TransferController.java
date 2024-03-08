package com.techelevator.tenmo.controller;

import com.techelevator.tenmo.dao.AccountDao;
import com.techelevator.tenmo.dao.TransferDao;
import com.techelevator.tenmo.dao.UserDao;
import com.techelevator.tenmo.model.Account;
import com.techelevator.tenmo.model.Transfer;

import java.security.Principal;
import java.util.List;

import com.techelevator.tenmo.model.User;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@PreAuthorize("isAuthenticated()")
@RequestMapping("transfers")
public class TransferController {
    private final AccountDao accountDao;
    private final TransferDao transferDao;
    private final UserDao userDao;

    public TransferController(AccountDao accountDao, TransferDao transferDao, UserDao userDao) {
        this.accountDao = accountDao;
        this.transferDao = transferDao;
        this.userDao = userDao;
    }

    public BigDecimal get(@PathVariable int id) {
        BigDecimal balance = accountDao.getBalanceByUserId(id);
        return balance;
    }

    @GetMapping
    public List<Transfer> getAllTransfers(Principal principal) {
        String userName = principal.getName();
        User user = userDao.getUserByUsername(userName);
        List<Transfer> transfers = transferDao.getAllByUserId(user.getId());
        return transfers;
    }

    @GetMapping("{id}")
    public Transfer getTransfer(@PathVariable int id) {
        Transfer transfer = transferDao.getById(id);
        return transfer;
    }
    @PostMapping()
    public Transfer doTransfer(@RequestBody Transfer transfer) {
        transferDao.transferFunds();

        Transfer newTransfer =
    }
}
