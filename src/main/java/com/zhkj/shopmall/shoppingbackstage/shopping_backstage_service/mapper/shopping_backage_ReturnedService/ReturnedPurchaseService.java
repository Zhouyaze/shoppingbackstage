package com.zhkj.shopmall.shoppingbackstage.shopping_backstage_service.mapper.shopping_backage_ReturnedService;

import com.zhkj.shopmall.shoppingbackstage.shopping_backstage_api.vo.ReturnedPurchaseVO;
import com.zhkj.shopmall.shoppingbackstage.shopping_backstage_dao.entity.ReturnedPurchaseEntity;

public interface ReturnedPurchaseService {

    /**
     * 添加退货商品信息
     * @param returnedPurchaseVO
     * @return
     */
    int saveReturned(ReturnedPurchaseVO returnedPurchaseVO);


    /**
     * 查询退货商品   发送到进销存
     * @return
     */
    String querReturned(ReturnedPurchaseEntity returnedPurchaseEntity);


}
