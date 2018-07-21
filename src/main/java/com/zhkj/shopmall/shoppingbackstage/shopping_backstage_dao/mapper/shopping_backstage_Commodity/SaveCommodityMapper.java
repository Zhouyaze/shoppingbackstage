package com.zhkj.shopmall.shoppingbackstage.shopping_backstage_dao.mapper.shopping_backstage_Commodity;

import com.zhkj.shopmall.shoppingbackstage.shopping_backstage_dao.entity.*;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface SaveCommodityMapper {
    /**
     * 添加商品类型表
     * @param typeEntity
     * @return
     */
    int savecommoditytype(@Param("typeEntity") TypeEntity typeEntity);


    /**
     * 添加商品规格
     * 比如 颜色  尺码
     * @param topic
     * @return
     */
    int savespecifications(@Param("topic") SpecificationstopicEntity topic);

    /**
     * 添加商品详细规格
     * @param sedtailed
     * @return

     */
    int savespecificationsdetailed(@Param("sedtaile") SpecificationsdetailedEntity sedtailed);

    /**
     * 添加商品
     * @param commodityEntity
     * @return
     */
    int SaveCommodity(@Param("commodityEntity") CommodityEntity commodityEntity);

    /**
     * 添加商品规格详细
     * @param priceEntity
     * @return
     */
    int Savecommodity_specification_inventory_price(@Param("priceEntity") CommoditySpecificationInventoryPriceEntity priceEntity);

    /**
     * 商品规格关系表
     * @param relationEntity
     * @return
     */
    int Savecommodity_specification_relation(@Param("relationEntity") CommoditySpecificationRelationEntity relationEntity);

    /**
     * 商品图片表
     * @param picture
     * @return
     */
    int Savecommodityintroducepicture(@Param("picture") CommodityintroducepictureEntity picture);








}
