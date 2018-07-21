package com.zhkj.shopmall.shoppingbackstage.shopping_backstage_controller;

import com.zhkj.shopmall.shoppingbackstage.shopping_backstage_dao.entity.PromotionitemEntity;
import com.zhkj.shopmall.shoppingbackstage.shopping_backstage_service.mapper.shopping_backstage_Promotionitem.PromotionitemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PromotionitemController {

    /**
     * 添加促销商品信息
     */
    @Autowired
    private PromotionitemService promotionitemService;
    @RequestMapping("/savePromotionitemMsg")
    public int saveMsg(PromotionitemEntity promotionitemEntity) {
        return promotionitemService.saveMsg(promotionitemEntity);
    }

    /**
     * 查询所有促销商品
     *
     * @param promotionitemEntity
     * @return
     */
    @RequestMapping("/getProMsg")
    public List<PromotionitemEntity> getMsg(PromotionitemEntity promotionitemEntity) {
        return promotionitemService.getMsg(promotionitemEntity);
    }

    @RequestMapping("/updatePromotionitemMsg")
    public int updateMsg(PromotionitemEntity promotionitemEntity) {
        return promotionitemService.updateMsg(promotionitemEntity);
    }

    @RequestMapping("/delPromotionitemMsg")
    public int delMsg(int id) {
        return promotionitemService.delMsg(id);
    }


}
