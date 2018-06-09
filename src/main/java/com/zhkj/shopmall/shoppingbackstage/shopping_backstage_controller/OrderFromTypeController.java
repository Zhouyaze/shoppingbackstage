package com.zhkj.shopmall.shoppingbackstage.shopping_backstage_controller;

import com.zhkj.shopmall.shoppingbackstage.shopping_backstage_dao.entity.OrderfromtypeEntity;
import com.zhkj.shopmall.shoppingbackstage.shopping_backstage_service.mapper.shopping_backstage_OrderFrom.OrderFromTypeServiceMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin
public class OrderFromTypeController {
    @Autowired
    OrderFromTypeServiceMapper orderFromTypeServiceMapper;

    @GetMapping("/getOrderFromType")
    public List<OrderfromtypeEntity> getOrderFromType(){
        return orderFromTypeServiceMapper.getOrderFromType();
    }
}
