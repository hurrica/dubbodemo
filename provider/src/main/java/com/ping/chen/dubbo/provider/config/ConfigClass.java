package com.ping.chen.dubbo.provider.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

/**
 * @Author chenping
 * @Description config
 * @Date 2019/4/3
 **/
@Configuration
@ImportResource(locations = {"classpath:provider.xml"})
public class ConfigClass {
}
