package com.lyz.generate;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @description:
 * @author: lyz
 * @date: 2024/2/3 10:08
 */
@SpringBootApplication
@MapperScan({"com.lyz.generate.mapper"})
public class GenerateApplication {

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        SpringApplication.run(GenerateApplication.class, args);
        System.out.println("*******************************#########################*******************************");
        System.out.println("GenerateApplication start success use " + (System.currentTimeMillis() - start) / 1000);
    }

}
