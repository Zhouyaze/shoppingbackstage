package com.zhkj.shopmall.shoppingbackstage;


import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.context.annotation.ComponentScan;

import org.springframework.kafka.annotation.EnableKafka;




@EnableKafka
@ComponentScan("com.zhkj.shopmall.shoppingbackstage")
@MapperScan("com.zhkj.shopmall.shoppingbackstage.shopping_backstage_dao.mapper")
@SpringBootApplication
public class ShoppingbackstageApplication {

    public static void main(String[] args) {

        SpringApplication.run(ShoppingbackstageApplication.class, args);
    }

}
