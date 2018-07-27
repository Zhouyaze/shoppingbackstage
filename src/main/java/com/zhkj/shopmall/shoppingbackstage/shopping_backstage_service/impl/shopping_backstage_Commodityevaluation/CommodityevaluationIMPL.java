package com.zhkj.shopmall.shoppingbackstage.shopping_backstage_service.impl.shopping_backstage_Commodityevaluation;

import com.zhkj.shopmall.shoppingbackstage.shopping_backstage_dao.entity.CommodityevaluationEntity;
import com.zhkj.shopmall.shoppingbackstage.shopping_backstage_dao.mapper.shopping_backstage_commodityevaluation.CommodityevaluationDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommodityevaluationIMPL {
    int index=0;
    @Autowired
    CommodityevaluationDao commodityevaluationDao;
    public int add(CommodityevaluationEntity commodityevaluationEntity){
        if(commodityevaluationEntity!=null){
            index=commodityevaluationDao.addEvaluate(commodityevaluationEntity);
        }
        return index;
    }
    public int delete(Integer id){
       index= commodityevaluationDao.deleteEvaluate(id);
       return index;
    }
}
