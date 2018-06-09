package com.zhkj.shopmall.shoppingbackstage.shopping_backstage_dao.mapper.shopping_backstage_Commodity;

import com.zhkj.shopmall.shoppingbackstage.shopping_backstage_dao.entity.*;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SelectCommodidyMapper {
    /**
     * 查询商品规格
     * @return
     */
    List<SpecificationstopicEntity> selectspecificationstopic();

    /**
     * 查询商品规格详情
     * @return
     */
    List<SpecificationsdetailedEntity>selectspecificationsdetailed();

    /**
     * 查询type类型变一级分类
     * @param
     * @return
     */
    List<TypeEntity> selectleves();

    /**
     * 添加商品规格类型
     * @return
     */
    List<CommoditySpecificationRelationEntity> selsctspecification();

    /**
     * 帮助查询商品主Id
     * @param name
     * @return
     */
    int seletCommodityId(@Param("name") String name);


    /**
     * 查询商品所有详情
     * @return
     */
    List<CommodityEntity> selectCommodity(@Param("commodity") CommodityEntity commodityName);


    /**
     * 根据商品id 查询规格表
     * @param id
     * @return
     */
    List<CommoditySpecificationInventoryPriceEntity> selectAllspecification(@Param("Id") Integer id);

}
