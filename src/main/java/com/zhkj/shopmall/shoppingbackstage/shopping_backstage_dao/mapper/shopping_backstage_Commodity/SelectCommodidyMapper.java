package com.zhkj.shopmall.shoppingbackstage.shopping_backstage_dao.mapper.shopping_backstage_Commodity;

import com.zhkj.shopmall.shoppingbackstage.shopping_backstage_dao.entity.*;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SelectCommodidyMapper {

    /**
     * 查询商品  颜色{子类}尺码{子类}
     * @param commodityEntity
     * @return
     */
    List<CommodityEntity> selectspecifications(@Param("commodity")CommodityEntity commodityEntity);



    /**
     * 查询商品数量
     * @return
     */
    int getCount(@Param("commodity") CommodityEntity commodityName);


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
     * 查询 type id
     * @return
     */
    int selectTypeId(String typeNamelevels);

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
    List<CommodityEntity> selectCommodity(@Param("commodity") CommodityEntity commodityName,@Param("currentPage")Integer currentPage,@Param("pageSize")Integer pageSize);


    /**
     * 根据商品id 查询规格表
     * @param id
     * @return
     */
    List<CommoditySpecificationInventoryPriceEntity> selectAllspecification(@Param("Id") Integer id);


    /**
     * 查询商品最后一个  商品id
     * @return
     */
    int SelectCommodityId();

    List<CommodityDTO>selectShop();


    /**
     * 根据商品 id 规格 规格查询  商品数量
     * @param
     * @return
     */
    int selectCount(@Param("price") CommoditySpecificationInventoryPriceEntity commoditySpecificationInventoryPriceEntity);


}
