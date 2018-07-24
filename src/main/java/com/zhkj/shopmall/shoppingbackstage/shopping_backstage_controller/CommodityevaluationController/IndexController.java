package com.zhkj.shopmall.shoppingbackstage.shopping_backstage_controller.CommodityevaluationController;

import com.zhkj.shopmall.shoppingbackstage.shopping_backstage_dao.entity.CommodityevaluationEntity;
import com.zhkj.shopmall.shoppingbackstage.shopping_backstage_service.impl.shopping_backstage_Commodityevaluation.CommodityevaluationIMPL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {
    @Autowired
    CommodityevaluationIMPL commodityevaluationIMPL;
    @RequestMapping("/addEvaluate")
    public String add(@ModelAttribute CommodityevaluationEntity commodityevaluationEntity){
        int index=0;
        index=commodityevaluationIMPL.add(commodityevaluationEntity);
       return index>0?"添加成功":"添加失败";
    }
    @RequestMapping("/deleteEvaluate")
    public String delete(Integer id){
        int index=0;
        index=commodityevaluationIMPL.delete(id);
        return index>0?"删除成功":"删除失败";
    }
}
