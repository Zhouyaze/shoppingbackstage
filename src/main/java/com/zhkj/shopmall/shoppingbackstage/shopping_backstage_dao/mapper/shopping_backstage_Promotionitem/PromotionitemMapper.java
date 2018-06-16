package com.zhkj.shopmall.shoppingbackstage.shopping_backstage_dao.mapper.shopping_backstage_Promotionitem;

import com.zhkj.shopmall.shoppingbackstage.shopping_backstage_dao.entity.PromotionitemEntity;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PromotionitemMapper {
    /**添加一条信息*/
    int saveMsg(PromotionitemEntity promotionitemEntity);
    /**查询*/
    List<PromotionitemEntity> getMsg(PromotionitemEntity promotionitemEntity);
    /**修改*/
    int updateMsg(PromotionitemEntity promotionitemEntity);
    /**删除*/
    int delMsg(int id);

}