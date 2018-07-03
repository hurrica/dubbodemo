package com.ping.chen.dubbo.provider.config;

import com.alibaba.dubbo.config.ApplicationConfig;
import com.alibaba.dubbo.config.ProtocolConfig;
import com.alibaba.dubbo.config.RegistryConfig;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ProviderConfig {

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
        protocolConfig.setName(name);
        protocolConfig.setPort(port);
        return protocolConfig;
    }
}
