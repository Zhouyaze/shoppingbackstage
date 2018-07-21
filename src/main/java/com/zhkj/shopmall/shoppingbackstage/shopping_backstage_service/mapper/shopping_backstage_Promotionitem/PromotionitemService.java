package com.zhkj.shopmall.shoppingbackstage.shopping_backstage_service.mapper.shopping_backstage_Promotionitem;

import com.zhkj.shopmall.shoppingbackstage.shopping_backstage_dao.entity.PromotionitemEntity;

import java.util.List;

public interface PromotionitemService {


    /**添加一条信息*/
    int saveMsg(PromotionitemEntity promotionitemEntity);
    /**查询*/
    List<PromotionitemEntity> getMsg(PromotionitemEntity promotionitemEntity);
    /**修改*/
    int updateMsg(PromotionitemEntity promotionitemEntity);
    /**删除*/
    int delMsg(int id);

}
