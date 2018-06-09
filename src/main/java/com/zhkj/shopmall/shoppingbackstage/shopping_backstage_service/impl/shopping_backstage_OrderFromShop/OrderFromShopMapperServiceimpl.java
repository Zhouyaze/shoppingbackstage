package com.zhkj.shopmall.shoppingbackstage.shopping_backstage_service.impl.shopping_backstage_OrderFromShop;



import com.zhkj.shopmall.shoppingbackstage.shopping_backstage_dao.entity.OrderfromshopEntity;
import com.zhkj.shopmall.shoppingbackstage.shopping_backstage_dao.mapper.shopping_backstage_OrderFromShop.OrderFromShopMapper;
import com.zhkj.shopmall.shoppingbackstage.shopping_backstage_service.mapper.shopping_backstage_OrderFromShop.OrderFromShopMapperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderFromShopMapperServiceimpl implements OrderFromShopMapperService {
    @Autowired
    private OrderFromShopMapper orderFromShopMapper;

    @Override
    public List<OrderfromshopEntity> selectOrderFromShopByOrderNumber(OrderfromshopEntity orderfromshopEntity) {
        if (orderfromshopEntity.getOrderFromId()%2==0){
            return orderFromShopMapper.selectOrderFromShopByOrderNumber0(orderfromshopEntity);
        }else{
            return orderFromShopMapper.selectOrderFromShopByOrderNumber1(orderfromshopEntity);
        }
    }
}
