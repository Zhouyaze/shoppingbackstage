package com.zhkj.shopmall.shoppingbackstage.shopping_backstage_service.mapper.shopping_backstage_OrderFromShop;


import com.zhkj.shopmall.shoppingbackstage.shopping_backstage_dao.entity.OrderfromshopEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface OrderFromShopMapperService {
    /**
     * 根据订单编号查询订单商品详情
     * 订单商品与商品表联合查询
     * @param orderfromshopEntity
     * @return
     */
    List<OrderfromshopEntity> selectOrderFromShopByOrderNumber(OrderfromshopEntity orderfromshopEntity);
}
