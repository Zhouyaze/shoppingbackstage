package com.zhkj.shopmall.shoppingbackstage.shopping_backstage_dao.mapper.shopping_backstage_commodityevaluation;

import com.zhkj.shopmall.shoppingbackstage.shopping_backstage_dao.entity.CommodityevaluationEntity;
import org.springframework.stereotype.Repository;

@Repository
public interface CommodityevaluationDao {
    int addEvaluate(CommodityevaluationEntity commodityevaluationEntity);
    int deleteEvaluate(Integer id);
}
