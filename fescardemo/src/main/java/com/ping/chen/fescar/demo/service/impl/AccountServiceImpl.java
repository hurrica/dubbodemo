package com.ping.chen.fescar.demo.service.impl;

import com.alibaba.fescar.core.context.RootContext;
import com.ping.chen.dubbo.provider.fescar.AccountService;
import org.apache.dubbo.config.annotation.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;


/**
 * @Author chenping
 * @Description
 * @Date 2019/4/4
 **/
public class AccountServiceImpl implements AccountService {

    private static final Logger LOGGER = LoggerFactory.getLogger(AccountService.class);

    private JdbcTemplate jdbcTemplate;

    @Override
    public void debit(String userId, int money) {
        LOGGER.info("Account Service ... xid: " + RootContext.getXID());
        LOGGER.info("Deducting balance SQL: update account_tbl set money = money - {} where user_id = {}",money,userId);

        jdbcTemplate.update("update account_tbl set money = money - ? where user_id = ?", new Object[] {money, userId});
        LOGGER.info("Account Service End ... ");
    }

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
}
