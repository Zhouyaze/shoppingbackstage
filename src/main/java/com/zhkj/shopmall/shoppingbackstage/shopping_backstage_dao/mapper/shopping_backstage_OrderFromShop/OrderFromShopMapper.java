package com.zhkj.shopmall.shoppingbackstage.shopping_backstage_dao.mapper.shopping_backstage_OrderFromShop;


import com.zhkj.shopmall.shoppingbackstage.shopping_backstage_dao.entity.OrderfromshopEntity;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface OrderFromShopMapper {
    /**
     * 根据订单编号查询订单商品详情
     * 订单商品与商品表联合查询
     * 查询订单商品1表
     * @param orderfromshopEntity
     * @return
     */
    List<OrderfromshopEntity> selectOrderFromShopByOrderNumber1(OrderfromshopEntity orderfromshopEntity);
    /**
     * 根据订单编号查询订单商品详情
     * 订单商品与商品表联合查询
     * 查询订单商品2表
     * @param orderfromshopEntity
     * @return
     */
    List<OrderfromshopEntity> selectOrderFromShopByOrderNumber0(OrderfromshopEntity orderfromshopEntity);
    List<OrderfromshopEntity> select0();
    List<OrderfromshopEntity> select1();
}
