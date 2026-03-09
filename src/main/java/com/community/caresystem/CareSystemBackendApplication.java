package com.community.caresystem;

import org.mybatis.spring.annotation.MapperScan; // 必须导入这个
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.community.caresystem.mapper") // 【注意】这里必须指向你 Mapper 接口所在的包名
public class CareSystemBackendApplication {
    public static void main(String[] args) {
        SpringApplication.run(CareSystemBackendApplication.class, args);
    }
}