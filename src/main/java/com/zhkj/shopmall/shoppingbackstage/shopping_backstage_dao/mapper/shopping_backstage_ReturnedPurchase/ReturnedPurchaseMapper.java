package com.zhkj.shopmall.shoppingbackstage.shopping_backstage_dao.mapper.shopping_backstage_ReturnedPurchase;

import com.zhkj.shopmall.shoppingbackstage.shopping_backstage_dao.entity.ReturnedPurchaseEntity;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

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
    int querReturned(@Param("returned") ReturnedPurchaseEntity returnedPurchaseEntity);


    /**
     * 查询退货商品   发送到进销存
     * @return
     */
    ReturnedPurchaseEntity querReturn(@Param("returned") ReturnedPurchaseEntity returnedPurchaseEntity);

    /**
     * 根据 条件查询（发货  退货）
     * @param returnedPurchaseEntity
     * @return
     */
    List<ReturnedPurchaseEntity> selectType(@Param("type") ReturnedPurchaseEntity returnedPurchaseEntity);


}
