package org.example;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * author: sanshao
 * date: 2025/6/3
 * IotCoapApplication desc:
 */

@SpringBootApplication
@MapperScan("org.example")
public class IotCoapApplication {

    public static void main(String[] args) {
        SpringApplication.run(IotCoapApplication.class, args);
    }

}