package com.zhkj.shopmall.shoppingbackstage.shopping_backstage_service.mapper.shopping_backstage_Commodity;

import com.zhkj.shopmall.shoppingbackstage.shopping_backstage_api.vo.Commodity_Vo;
import com.zhkj.shopmall.shoppingbackstage.shopping_backstage_dao.entity.CommoditySpecificationRelationEntity;
import com.zhkj.shopmall.shoppingbackstage.shopping_backstage_dao.entity.SpecificationsdetailedEntity;
import com.zhkj.shopmall.shoppingbackstage.shopping_backstage_dao.entity.SpecificationstopicEntity;
import com.zhkj.shopmall.shoppingbackstage.shopping_backstage_dao.entity.TypeEntity;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.multipart.MultipartFile;

public interface SaveCommodityService {

    /**
     * 添加商品完整信息
     * @param commodity_vo
     * @return
     */
    int saveCommodityAll(MultipartFile imgFile, MultipartFile[] File, Commodity_Vo commodity_vo);

    /**
     * i添加商品规格
     * @param simmallFile
     * @param commodity_vo
     * @return
     */
    int saveCommodityPrice(MultipartFile simmallFile, Commodity_Vo commodity_vo);

    /**
     * 添加商品类型表
     * @param typeEntity
     * @return
     */
    int savetype(TypeEntity typeEntity);

    int SavecommoditySpecification(@Param("relationEntity") CommoditySpecificationRelationEntity relationEntity);


    /**
     * 添加商品规格
     * @param topic
     * @return
     */
    int savetopic(SpecificationstopicEntity topic);

    /**
     * 商品详细规格添加
     * @param sedtailed
     * @return
     */
    int savesedtailed(SpecificationsdetailedEntity sedtailed);


}
