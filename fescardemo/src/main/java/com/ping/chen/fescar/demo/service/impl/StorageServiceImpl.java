package com.ping.chen.fescar.demo.service.impl;

import com.alibaba.fescar.core.context.RootContext;
import com.ping.chen.dubbo.provider.fescar.StorageService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 * @Author chenping
 * @Description
 * @Date 2019/4/4
 **/
public class StorageServiceImpl implements StorageService {
    private static final Logger LOGGER = LoggerFactory.getLogger(StorageService.class);

    private JdbcTemplate jdbcTemplate;

    @Override
    public void deduct(String commodityCode, int count) {
        LOGGER.info("Storage Service Begin ... xid: " + RootContext.getXID());
        LOGGER.info("Deducting inventory SQL: update storage_tbl set count = count - {} where commodity_code = {}",
                count, commodityCode);

        jdbcTemplate.update("update storage_tbl set count = count - ? where commodity_code = ?",
                new Object[] {count, commodityCode});
        LOGGER.info("Storage Service End ... ");

    }

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
}
