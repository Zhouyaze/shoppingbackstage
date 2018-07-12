package com.zhkj.shopmall.shoppingbackstage.shopping_backstage_service.mapper.shopping_backage_ReturnedService;

import com.zhkj.shopmall.shoppingbackstage.shopping_backstage_dao.entity.ReturnedPurchaseEntity;

public interface ReturnedPurchaseService {

    /**
     * 添加退货商品信息
     * @param returnedPurchaseEntity
     * @return
     */
    int saveReturned(ReturnedPurchaseEntity returnedPurchaseEntity);

}
