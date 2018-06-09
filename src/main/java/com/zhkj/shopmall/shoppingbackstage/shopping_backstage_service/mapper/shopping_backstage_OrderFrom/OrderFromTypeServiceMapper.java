package com.zhkj.shopmall.shoppingbackstage.shopping_backstage_service.mapper.shopping_backstage_OrderFrom;


import com.zhkj.shopmall.shoppingbackstage.shopping_backstage_dao.entity.OrderfromtypeEntity;

import java.util.List;

public interface OrderFromTypeServiceMapper {
    /**
     * 获得付款状态全部类型
     * @return
     */
    List<OrderfromtypeEntity> getOrderFromType();
}
