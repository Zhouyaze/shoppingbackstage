package com.zhkj.shopmall.shoppingbackstage.shopping_backstage_service.mapper.shopping_backstage_Commodity;

import org.apache.ibatis.annotations.Param;

public interface DeleteCommodityService {
    /**
     * 删除所有商品
     * @param id
     * @return
     */
    int DeleteCommodity(Integer id);

    /**
     * 删除商品规格表
     * @param id 参数 【规格表主键id】
     * @return
     */
    int DeleteCommoditySpecification(@Param("Id") Integer id);
}
