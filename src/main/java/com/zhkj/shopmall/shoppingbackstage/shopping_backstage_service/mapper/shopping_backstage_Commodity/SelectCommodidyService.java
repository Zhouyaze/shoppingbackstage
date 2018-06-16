package com.zhkj.shopmall.shoppingbackstage.shopping_backstage_service.mapper.shopping_backstage_Commodity;

import com.zhkj.shopmall.shoppingbackstage.shopping_backstage_dao.entity.*;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SelectCommodidyService {
    /**
     * 查询商品规格
     * @return
     */
    List<SpecificationstopicEntity> selecttopic();

    /**
     * 查询商品规格详情
     * @return
     */
    List<SpecificationsdetailedEntity>selectsdetailed();
    /**
     * 查询type类型变一级分类
     * @param
     * @return
     */
    List<TypeEntity> selecttypeleves();

    /**
     * 根据 typeNamae查询 typeID
     * @return
     */
    int selectTypeName(String typeNamelevels);

    /**
     * 添加商品规格类型
     * @return
     */
    List<CommoditySpecificationRelationEntity> selsctspecificationlevels();

    /**
     * 帮助查询商品 主键 id
     * @param name
     * @return
     */
    int seletCommodityId(@Param("name") String name);


    /**
     *查询全部
     * @return
     */
    List<CommodityEntity> selectCommodity(CommodityEntity commodityEntity);


    /**
     * 根据商品id 查询规格表
     * @param id
     * @return
     */
    List<CommoditySpecificationInventoryPriceEntity> selectAllspecification(Integer id);

    /**
     * 查询商品  id 最后一个
     * @return
     */
    int  SelectCommodityId();

}
