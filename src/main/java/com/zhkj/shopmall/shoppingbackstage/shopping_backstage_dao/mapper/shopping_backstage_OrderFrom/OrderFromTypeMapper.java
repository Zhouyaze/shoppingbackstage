package com.zhkj.shopmall.shoppingbackstage.shopping_backstage_dao.mapper.shopping_backstage_OrderFrom;

import com.zhkj.shopmall.shoppingbackstage.shopping_backstage_dao.entity.OrderfromtypeEntity;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface OrderFromTypeMapper {
    /**
     * xml映射
     * @return
     */
    List<OrderfromtypeEntity> getOrderFromType();
}
