package com.bright;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @Author: wangliang
 * @Date: 2021/11/13 14:14
 */
@SpringBootApplication
@MapperScan("com.bright.dao")
public class WarApplication {
    public static void main(String[] args) {
        SpringApplication.run(WarApplication.class, args);
    }
}
