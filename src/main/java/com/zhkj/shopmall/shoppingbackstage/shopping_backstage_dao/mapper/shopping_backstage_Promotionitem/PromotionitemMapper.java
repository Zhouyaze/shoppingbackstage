package com.zhkj.shopmall.shoppingbackstage.shopping_backstage_dao.mapper.shopping_backstage_Promotionitem;

import com.zhkj.shopmall.shoppingbackstage.shopping_backstage_dao.entity.PromotionitemEntity;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PromotionitemMapper {

    /**
     * 获得总条数
     * @param promotionitemEntity
     * @return
     */
    int countMsg(PromotionitemEntity promotionitemEntity);
    /**添加一条信息*/
    int saveMsg(@Param("promotionitem") PromotionitemEntity promotionitemEntity);
    /**查询*/
    List<PromotionitemEntity> getMsg(PromotionitemEntity promotionitemEntity,@Param("currentPage")int currentPage,@Param("pageSize")int pageSize);
    /**修改*/
    int updateMsg(PromotionitemEntity promotionitemEntity);
    /**删除*/
    int delMsg(int id);

}
