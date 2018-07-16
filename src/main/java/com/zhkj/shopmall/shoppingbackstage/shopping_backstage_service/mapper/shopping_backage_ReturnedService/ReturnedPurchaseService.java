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
     * 传送退货商品到进销存
     * @param returnedPurchaseEntity
     * @return
     */
    int sendKafka(ReturnedPurchaseEntity returnedPurchaseEntity);

    /**
     * 查询退货商品   发送到进销存
     * @return
     */
    ReturnedPurchaseEntity querReturned();
}
