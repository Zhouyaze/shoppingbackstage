package com.zhkj.shopmall.shoppingbackstage.shopping_backstage_service.mapper.shopping_backstage_OrderFrom;


import com.zhkj.shopmall.shoppingbackstage.shopping_backstage_dao.entity.OrderfromEntity;
import com.zhkj.shopmall.shoppingbackstage.shopping_backstage_tools.PageBean;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

public interface OrderMapperService {
    /**
     * 获取全部订单数量
     * @param orderfromEntity
     * @return
     */
    int getOrderFromCount(OrderfromEntity orderfromEntity);

    /**
     * 根据条件查询订单信息
     * @return
     */
    PageBean<OrderfromEntity> getOrderFromSimInfoByCond(OrderfromEntity orderfromEntity,String userName, int currentPage, int pageSize);


    /**
     * 删除订单信息
     * @param orderfromEntity
     * @return
     */
    int orderFromDelete(OrderfromEntity orderfromEntity);
    /**
     * 修改订单信息
     * @param orderfromEntity
     * @return
     */
    String orderFromUpdate(OrderfromEntity orderfromEntity);
    /**
     * 查询所有订单
     * */
     List<OrderfromEntity>selectAll();
     /**
      * 生成报表
      * */
     boolean exportExcel(HttpServletResponse response);
}
