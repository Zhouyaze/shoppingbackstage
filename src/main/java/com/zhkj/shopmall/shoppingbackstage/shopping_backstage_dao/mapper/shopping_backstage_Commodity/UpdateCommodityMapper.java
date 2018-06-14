package com.zhkj.shopmall.shoppingbackstage.shopping_backstage_dao.mapper.shopping_backstage_Commodity;

import com.zhkj.shopmall.shoppingbackstage.shopping_backstage_dao.entity.CommodityEntity;
import com.zhkj.shopmall.shoppingbackstage.shopping_backstage_dao.entity.CommoditySpecificationInventoryPriceEntity;
import com.zhkj.shopmall.shoppingbackstage.shopping_backstage_dao.entity.CommodityintroducepictureEntity;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UpdateCommodityMapper {


    int UpdateCommodity(@Param("CommodityEntity")CommodityEntity commodityEntity);
    int UpdateCommodityPrice(@Param("specification") CommoditySpecificationInventoryPriceEntity priceEntity);


    int UpdateCommodityPicture(@Param("pictureEntity") CommodityintroducepictureEntity pictureEntity);

}
