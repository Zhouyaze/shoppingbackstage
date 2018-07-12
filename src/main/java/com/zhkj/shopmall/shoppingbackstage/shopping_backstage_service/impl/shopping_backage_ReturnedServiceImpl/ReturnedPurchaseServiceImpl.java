package com.zhkj.shopmall.shoppingbackstage.shopping_backstage_service.impl.shopping_backage_ReturnedServiceImpl;

import com.zhkj.shopmall.shoppingbackstage.shopping_backstage_dao.entity.ReturnedPurchaseEntity;
import com.zhkj.shopmall.shoppingbackstage.shopping_backstage_dao.mapper.shopping_backstage_ReturnedPurchase.ReturnedPurchaseMapper;
import com.zhkj.shopmall.shoppingbackstage.shopping_backstage_service.mapper.shopping_backage_ReturnedService.ReturnedPurchaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReturnedPurchaseServiceImpl implements ReturnedPurchaseService {

    @Autowired
    ReturnedPurchaseMapper returnedPurchaseMapper;

    /**
     * 添加退货商品信息
     * @param returnedPurchaseEntity
     * @return
     */
    @Override
    public int saveReturned(ReturnedPurchaseEntity returnedPurchaseEntity) {

        return returnedPurchaseMapper.saveReturned(returnedPurchaseEntity);
    }
}
