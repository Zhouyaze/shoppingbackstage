package com.zhkj.shopmall.shoppingbackstage.shopping_backstage_controller.advertisementcontroller;
//import com.auth0.jwt.JWT;
//import com.auth0.jwt.JWTVerifier;
//import com.auth0.jwt.algorithms.Algorithm;
//import com.auth0.jwt.interfaces.Claim;
//import com.auth0.jwt.interfaces.DecodedJWT;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
@EnableKafka
public class MainTest {

    @Autowired
    private KafkaTemplate kafkaTemplate;
    public void send(){
        kafkaTemplate.send("test","dazhubg");
    }

    @KafkaListener(topics = "test1")
    public void get(String content){
        System.out.println(content);
    }
}
