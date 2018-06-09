package com.zhkj.shopmall.shoppingbackstage.shopping_backstage_service.mapper.shopping_backstage_Specificationsrelation;


import com.zhkj.shopmall.shoppingbackstage.shopping_backstage_dao.entity.SpecificationsrelationEntity;

import java.util.List;

public interface SpecificationsrelationMapperService {
    /**
     * 根据商品id查询商品具体属性
     * @return
     */
    List<SpecificationsrelationEntity> getspectificRelationById(SpecificationsrelationEntity specificationsrelationEntity);
}
