package com.techelevator.tenmo.dao;

import org.springframework.jdbc.support.rowset.SqlRowSet;

import java.util.ArrayList;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;

public class JdbcTransferDao implements TransferDao {
    private final JdbcTemplate jdbcTemplate;

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


}
