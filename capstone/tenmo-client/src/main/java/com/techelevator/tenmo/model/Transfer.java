package com.techelevator.tenmo.model;

import java.math.BigDecimal;

public class Transfer {
    private int transferId;
    private int transferTypeId;
    private int transferStatusId;
    private int accountFrom;
    private int accountTo;
    private BigDecimal amount;
    private BigDecimal newBalance;
    private int userTo;
    private int userFrom;


    public Transfer() { }
    public Transfer(int transferId, int transferTypeId, int transferStatusId,
                    int accountFrom, int accountTo, BigDecimal amount, BigDecimal newBalance, int userTo, int userFrom) {
        this.transferId = transferId;
        this.transferTypeId = transferTypeId;
        this.transferStatusId = transferStatusId;
        this.accountFrom = accountFrom;
        this.accountTo = accountTo;
        this.amount = amount;
        this.newBalance = newBalance;
        this.userFrom = userFrom;
        this.userTo = userTo;
    }

    public int getTransferId() {
        return transferId;
    }

    public int getTransferTypeId() {
        return transferTypeId;
    }

    public int getUserTo() {
        return userTo;
    }

    public int getUserFrom() {
        return userFrom;
    }

    public void setUserTo(int userTo) {
        this.userTo = userTo;
    }

    public void setUserFrom(int userFrom) {
        this.userFrom = userFrom;
    }

    public int getTransferStatusId() {
        return transferStatusId;
    }

    public int getAccountFrom() {
        return accountFrom;
    }

    public int getAccountTo() {
        return accountTo;
    }

    public BigDecimal getAmount() {
        return amount;
    }
    public BigDecimal getNewBalance() {
        return newBalance;
    }


    public void setTransferId(int transferId) {
        this.transferId = transferId;
    }

    public void setTransferTypeId(int transferTypeId) {
        this.transferTypeId = transferTypeId;
    }

    public void setTransferStatusId(int transferStatusId) {
        this.transferStatusId = transferStatusId;
    }

    public void setAccountFrom(int accountFrom) {
        this.accountFrom = accountFrom;
    }

    public void setAccountTo(int accountTo) {
        this.accountTo = accountTo;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public void setNewBalance(BigDecimal newBalance) {
        this.newBalance = newBalance;
    }
}
