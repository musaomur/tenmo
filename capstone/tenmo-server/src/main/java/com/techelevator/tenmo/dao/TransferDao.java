package com.techelevator.tenmo.dao;

import com.techelevator.tenmo.model.Transfer;

import java.util.List;

public interface TransferDao {
    List<String> getUserList();

    //void transferFunds();

    String transferFunds(Transfer transfer);

    List<Transfer> getAllByUserId(int userId);

    Transfer getById(int id);
    //void transferFunds();




}
