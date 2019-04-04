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
public class DubboAccountServiceStarter {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext accountContext = new ClassPathXmlApplicationContext(new String[]{"spring/dubbo-account-service.xml"});
        JdbcTemplate accountJdbcTemplate = (JdbcTemplate) accountContext.getBean("jdbcTemplate");
        accountJdbcTemplate.update("delete from account_tbl where user_id = 'U100001'");
        accountJdbcTemplate.update("insert into account_tbl(user_id, money) values ('U100001', 999)");

        new ApplicationKeeper(accountContext).keep();
    }
}
