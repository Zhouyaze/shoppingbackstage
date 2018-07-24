package com.zhkj.shopmall.shoppingbackstage.shopping_backstage_dao.mapper.shopping_backstage_OrderFrom;

import com.zhkj.shopmall.shoppingbackstage.shopping_backstage_dao.entity.OrderfromEntity;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderFromMapper {
    /**
     * 获取全部订单数量
     * @param orderfromEntity
     * @return
     */
    int getOrderFromCount(@Param("orderfromEntity")OrderfromEntity orderfromEntity);

    /**
     * 查询订单大概信息
     * 可以根据 订单编号 付款状态  收款人查询
     * @return
     */
    List<OrderfromEntity> getOrderFromSimInfoByCond(@Param("orderfromEntity") OrderfromEntity orderfromEntity,@Param("userName") String userName,@Param("currentPage") int currentPage, @Param("pageSize") int pageSize);
    /**
     * 删除订单并删除管理的订单商品信息
     * @param orderfromEntity
     * @return
     */
    int orderFromDelete0(OrderfromEntity orderfromEntity);
    /**
     * 删除订单并删除管理的订单商品信息
     * @param orderfromEntity
     * @return
     */
    int orderFromDelete1(OrderfromEntity orderfromEntity);
    /**
     * 修改订单信息
     * @param orderfromEntity
     * @return
     */
    int orderFromUpdate(OrderfromEntity orderfromEntity);

    List<OrderfromEntity>selectOrder();



    int updateOrderFrom( String orderNumber);

}
