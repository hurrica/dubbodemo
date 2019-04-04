package com.ping.chen.fescar.demo.starter;

import com.ping.chen.fescar.demo.ApplicationKeeper;
import org.apache.dubbo.config.spring.context.annotation.DubboComponentScan;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 * @Author chenping
 * @Description
 * @Date 2019/4/4
 **/
@DubboComponentScan("com.ping.chen.fescar.demo.service")
public class DubboStorageServiceStarter {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext storageContext = new ClassPathXmlApplicationContext(
                new String[]{"spring/dubbo-storage-service.xml"});
        JdbcTemplate storageJdbcTemplate = (JdbcTemplate) storageContext.getBean("jdbcTemplate");
        storageJdbcTemplate.update("delete from storage_tbl where commodity_code = 'C00321'");
        storageJdbcTemplate.update("insert into storage_tbl(commodity_code, count) values ('C00321', 100)");
        new ApplicationKeeper(storageContext).keep();
    }
}
