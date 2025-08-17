package com.mall.wechat.bootstrap;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * 微信服务启动类
 */
@SpringBootApplication(scanBasePackages = "com.mall.wechat")
@EnableDiscoveryClient
@MapperScan("com.mall.wechat.adapter.out.persistence.mapper")
public class WechatServiceApplication {
    
    public static void main(String[] args) {
        SpringApplication.run(WechatServiceApplication.class, args);
    }
}