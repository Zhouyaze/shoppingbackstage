package com.zhkj.shopmall.shoppingbackstage.shopping_backstage_dao.mapper.shopping_backstage_ReturnedPurchase;

import com.zhkj.shopmall.shoppingbackstage.shopping_backstage_dao.entity.ReturnedPurchaseEntity;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ReturnedPurchaseMapper {

    /**
     * 添加退货商品信息
     * @param returnedPurchaseEntity
     * @return
     */
    int saveReturned(@Param("returned") ReturnedPurchaseEntity returnedPurchaseEntity);


    int insertReturned(@Param("returned") ReturnedPurchaseEntity returnedPurchaseEntity);


    int update(@Param("returned") ReturnedPurchaseEntity returnedPurchaseEntity);
    /**
     * 查询退货商品   发送到进销存
     * @return
     */
    ReturnedPurchaseEntity querReturned(@Param("returned") ReturnedPurchaseEntity returnedPurchaseEntity);




}
