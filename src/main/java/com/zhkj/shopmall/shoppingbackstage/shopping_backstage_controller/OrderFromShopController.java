package com.zhkj.shopmall.shoppingbackstage.shopping_backstage_controller;


import com.zhkj.shopmall.shoppingbackstage.shopping_backstage_dao.entity.OrderfromshopEntity;
import com.zhkj.shopmall.shoppingbackstage.shopping_backstage_service.mapper.shopping_backstage_OrderFromShop.OrderFromShopMapperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin
@RestController
public class OrderFromShopController {
    @Autowired
    OrderFromShopMapperService orderFromShopMapperService;
    @GetMapping("/getOrderFromShopInfo")
    public List<OrderfromshopEntity> getOrderFromShopInfo(OrderfromshopEntity orderfromshopEntity){
       return orderFromShopMapperService.selectOrderFromShopByOrderNumber(orderfromshopEntity);
    }
}
