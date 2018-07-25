package com.zhkj.shopmall.shoppingbackstage.shopping_backstage_controller.ReturnedPurchaseController;

import com.alibaba.fastjson.JSON;
import com.zhkj.shopmall.shoppingbackstage.shopping_backstage_api.vo.ReturnedPurchaseVO;
import com.zhkj.shopmall.shoppingbackstage.shopping_backstage_dao.entity.ReturnedPurchaseEntity;
import com.zhkj.shopmall.shoppingbackstage.shopping_backstage_service.mapper.shopping_backage_ReturnedService.ReturnedPurchaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ReturnedPurchaseController {

    @Autowired
    ReturnedPurchaseService returnedPurchaseService;

    /**
     * 前台查询 退货 发货 展示
     * @param returnedPurchaseEntity
     * @return
     */
    @RequestMapping("selectType")
    public List<ReturnedPurchaseEntity> select(ReturnedPurchaseEntity returnedPurchaseEntity){
          return returnedPurchaseService.selectNews(returnedPurchaseEntity);
    }

    /**
     * 前台 退货  下订单数据
     * @return 文杰
     */
    @RequestMapping("saveReturned")
    public String saveReturn(){
        String json="{\"messageType\":\"2\",\"manifest\":\"1234567890\",\"returnUserName\":\"狗浩宇\",\"returnUserAddress\":\"河南省洛阳市涧西区几安南街33号3单元2号楼202\",\"commodityName\":\"苹果\",\"count\":\"9\",\"specification1\":\"褐色\",\"specification2\":\"xxxl\",\"specification3\":\"\",\"specification4\":\"\"}";
        ReturnedPurchaseVO returnedPurchaseVO = JSON.parseObject(json,ReturnedPurchaseVO.class);
        return returnedPurchaseService.saveNews(returnedPurchaseVO);
    }


    /**
     * 前台查询 发送 进销存  逐条发送
     * @param returnedPurchaseEntity
     * @return 国超
     */
    @RequestMapping("sendJosn")
    public ReturnedPurchaseEntity sendJson1(ReturnedPurchaseEntity returnedPurchaseEntity){

        return returnedPurchaseService.sendNews(returnedPurchaseEntity);
    }

    @RequestMapping("sendJosn1")
    public String sendJson(){
        String json="{\"messageType\":\"2\",\"operatingStatus\":\"4\",\"manifest\":\"123456\",\"returnUserName\":\"崔文杰\",\"returnUserAddress\":\"河南省洛阳市涧西区几安南街33号3单元2号楼202\",\"commodityName\":\"苹果\",\"count\":\"9\",\"specification1\":\"褐色\",\"specification2\":\"xxxl\",\"specification3\":\"\",\"specification4\":\"\"}";
        ReturnedPurchaseVO returnedPurchaseVO = JSON.parseObject(json,ReturnedPurchaseVO.class);
        return returnedPurchaseService.querReturned(returnedPurchaseVO);
    }

}
