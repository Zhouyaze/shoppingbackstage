package com.zhkj.shopmall.shoppingbackstage.shopping_backstage_service.impl.shopping_backstage_OrderFrom;

import com.zhkj.shopmall.shoppingbackstage.shopping_backstage_dao.entity.OrderfromtypeEntity;
import com.zhkj.shopmall.shoppingbackstage.shopping_backstage_dao.mapper.shopping_backstage_OrderFrom.OrderFromTypeMapper;
import com.zhkj.shopmall.shoppingbackstage.shopping_backstage_service.mapper.shopping_backstage_OrderFrom.OrderFromTypeServiceMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class OrderFromTypeServiceMapperImpl implements OrderFromTypeServiceMapper {
    @Autowired
    OrderFromTypeMapper orderFromTypeMapper;
    /**
     * 获取全部付款状态类型
     * @return
     * */
    @Override
    public List<OrderfromtypeEntity> getOrderFromType() {
        return orderFromTypeMapper.getOrderFromType();
    }
}
