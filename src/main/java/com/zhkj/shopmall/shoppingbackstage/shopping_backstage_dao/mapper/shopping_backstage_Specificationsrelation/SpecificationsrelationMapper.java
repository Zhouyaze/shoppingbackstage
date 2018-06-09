package com.zhkj.shopmall.shoppingbackstage.shopping_backstage_dao.mapper.shopping_backstage_Specificationsrelation;

import com.zhkj.shopmall.shoppingbackstage.shopping_backstage_dao.entity.SpecificationsrelationEntity;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SpecificationsrelationMapper {


    /**
     * 根据商品id查询商品具体属性
     * @return
     */
    List<SpecificationsrelationEntity> getspectificRelationById(SpecificationsrelationEntity specificationsrelationEntity);
}
