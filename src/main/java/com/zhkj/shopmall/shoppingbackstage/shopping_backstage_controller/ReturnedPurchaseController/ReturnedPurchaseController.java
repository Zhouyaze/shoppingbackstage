package com.zhkj.shopmall.shoppingbackstage.shopping_backstage_controller.ReturnedPurchaseController;

import com.zhkj.shopmall.shoppingbackstage.shopping_backstage_dao.entity.ReturnedPurchaseEntity;
import com.zhkj.shopmall.shoppingbackstage.shopping_backstage_service.mapper.shopping_backage_ReturnedService.ReturnedPurchaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ReturnedPurchaseController {

    @Autowired
    ReturnedPurchaseService returnedPurchaseService;
    @RequestMapping("saveReturned")
    public int saveReturn(ReturnedPurchaseEntity returnedPurchaseEntity){

        return returnedPurchaseService.saveReturned(returnedPurchaseEntity);
    }
}
