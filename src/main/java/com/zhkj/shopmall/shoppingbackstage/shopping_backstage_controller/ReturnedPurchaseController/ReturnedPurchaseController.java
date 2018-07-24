package com.zhkj.shopmall.shoppingbackstage.shopping_backstage_controller.ReturnedPurchaseController;

import com.alibaba.fastjson.JSON;
import com.zhkj.shopmall.shoppingbackstage.shopping_backstage_api.vo.ReturnedPurchaseVO;
import com.zhkj.shopmall.shoppingbackstage.shopping_backstage_service.mapper.shopping_backage_ReturnedService.ReturnedPurchaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ReturnedPurchaseController {


//    @RequestMapping(value = "/sendMessage",method = RequestMethod.GET)
//    public Result sendMessage(String json){
//        ReturnedPurchaseVO returnedPurchaseVO = JSON.parseObject(json,ReturnedPurchaseVO.class);
//
//        return Result;
//    }

    /**
     * 前台传过退货   进货信息   并添加数据到库
     */
    @Autowired
    ReturnedPurchaseService returnedPurchaseService;

    @RequestMapping("saveReturned")
    public String saveReturn(){
        String json="{\"messageType\":\"2\",\"manifest\":\"1234567890\",\"returnUserName\":\"崔文杰\",\"returnUserAddress\":\"河南省洛阳市涧西区几安南街33号3单元2号楼202\",\"commodityName\":\"苹果\",\"count\":\"9\",\"specification1\":\"褐色\",\"specification2\":\"xxxl\",\"specification3\":\"\",\"specification4\":\"\"}";
        ReturnedPurchaseVO returnedPurchaseVO = JSON.parseObject(json,ReturnedPurchaseVO.class);

        return returnedPurchaseService.saveReturned(returnedPurchaseVO);
    }


    @RequestMapping("sendJosn")
    public String sendJson(){
        String json="{\"messageType\":\"3\",\"operatingStatus\":\"4\",\"manifest\":\"123456\",\"returnUserName\":\"崔文杰\",\"returnUserAddress\":\"河南省洛阳市涧西区几安南街33号3单元2号楼202\",\"commodityName\":\"苹果\",\"count\":\"9\",\"specification1\":\"褐色\",\"specification2\":\"xxxl\",\"specification3\":\"\",\"specification4\":\"\"}";
        ReturnedPurchaseVO returnedPurchaseVO = JSON.parseObject(json,ReturnedPurchaseVO.class);
        return returnedPurchaseService.querReturned(returnedPurchaseVO);
    }
}
