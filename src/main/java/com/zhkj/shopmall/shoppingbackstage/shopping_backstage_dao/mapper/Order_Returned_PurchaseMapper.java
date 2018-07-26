package com.zhkj.shopmall.shoppingbackstage.shopping_backstage_dao.mapper;

import com.zhkj.shopmall.shoppingbackstage.shopping_backstage_dao.entity.CommoditySpecificationInventoryPriceEntity;
import com.zhkj.shopmall.shoppingbackstage.shopping_backstage_dao.entity.HarvestaddressEntity;
import com.zhkj.shopmall.shoppingbackstage.shopping_backstage_dao.entity.ReturnedPurchaseEntity;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * 订单交互Mapper
 */
@Repository
public interface Order_Returned_PurchaseMapper {
    /**
     * 根据id查询地址实体类
     * @param id
     * @return
     */
     HarvestaddressEntity selectHarvestaddressById(int id);

    /**
     * 根据商品库存id查询商品库存实体类
     * @param id
     * @return
     */
     CommoditySpecificationInventoryPriceEntity selectCommoditySpecifiation(int id);

    /**
     * 根据商品id查询商品名称
     * @param id
     * @return
     */
     String selectCommodityById(int id);

    /**
     * 添加一条消息
     */
    int insertReturnedPuchase(@Param("ReturnedPurchaseEntity") ReturnedPurchaseEntity returnedPurchaseEntity);
}
