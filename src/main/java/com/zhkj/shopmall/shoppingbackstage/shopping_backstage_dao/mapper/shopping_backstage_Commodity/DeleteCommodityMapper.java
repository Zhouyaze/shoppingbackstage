package com.zhkj.shopmall.shoppingbackstage.shopping_backstage_dao.mapper.shopping_backstage_Commodity;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface DeleteCommodityMapper {

    int DeleteCommodity(@Param("Id") Integer id);
    int DeleteCommodityPrice(@Param("Id") Integer id);
    int DeleteCommodityPicture(@Param("Id") Integer id);

    /**
     * 删除商品规格表
     * @param id 参数 【规格表主键id】
     * @return
     */
    int DeleteCommoditySpecification(@Param("Id") Integer id);
}
