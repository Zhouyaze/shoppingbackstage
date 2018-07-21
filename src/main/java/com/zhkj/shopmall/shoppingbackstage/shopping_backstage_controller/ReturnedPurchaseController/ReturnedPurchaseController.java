package com.zhkj.shopmall.shoppingbackstage.shopping_backstage_controller.ReturnedPurchaseController;

import com.zhkj.shopmall.shoppingbackstage.shopping_backstage_api.vo.ReturnedPurchaseVO;
import com.zhkj.shopmall.shoppingbackstage.shopping_backstage_dao.entity.ReturnedPurchaseEntity;
import com.zhkj.shopmall.shoppingbackstage.shopping_backstage_service.mapper.shopping_backage_ReturnedService.ReturnedPurchaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ReturnedPurchaseController {

    /**
     * 前台传过退货信息   并添加数据到库
     */
    @Autowired
    ReturnedPurchaseService returnedPurchaseService;
    @RequestMapping("saveReturned")
    public int saveReturn(ReturnedPurchaseVO returnedPurchaseVO){
        return returnedPurchaseService.saveReturned(returnedPurchaseVO);
    }


    @RequestMapping("sendJosn")
    public String sendJson(ReturnedPurchaseEntity returnedPurchaseEntity){
        return returnedPurchaseService.querReturned(returnedPurchaseEntity);
    }
}
