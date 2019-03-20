package com.ping.chen.dubbo.provider.config;

import com.alibaba.dubbo.config.ApplicationConfig;
import com.alibaba.dubbo.config.ProtocolConfig;
import com.alibaba.dubbo.config.ProviderConfig;
import com.alibaba.dubbo.config.RegistryConfig;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyProviderConfig {

    @Bean
    public ProviderConfig providerConfig(){
        ProviderConfig providerConfig = new ProviderConfig();

        return providerConfig;
    }

    @Bean
    public ApplicationConfig applicationConfig(){
        ApplicationConfig applicationConfig = new ApplicationConfig();
        applicationConfig.setName("demo-provider");
        return applicationConfig;
    }

    @Bean
    public RegistryConfig registryConfig(@Value("${dubbo.registry.address}")String address){
        RegistryConfig registryConfig = new RegistryConfig();
        registryConfig.setAddress(address);
        registryConfig.setClient("curator");
        return registryConfig;
    }

    @Bean
    public ProtocolConfig protocolConfig(@Value("${dubbo.protocol.port}")Integer port, @Value("${dubbo.protocol.name}") String name){
        ProtocolConfig protocolConfig = new ProtocolConfig();
        protocolConfig.setName(name);//协议名称
        protocolConfig.setPort(port);//端口
        protocolConfig.setAccepts(5000);//设置最大连接数
        return protocolConfig;
    }
}
