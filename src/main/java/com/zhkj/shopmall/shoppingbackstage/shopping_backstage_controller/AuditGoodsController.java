package com.zhkj.shopmall.shoppingbackstage.shopping_backstage_controller;

import com.zhkj.shopmall.shoppingbackstage.shopping_backstage_dao.entity.AuditgoodsEntity;
import com.zhkj.shopmall.shoppingbackstage.shopping_backstage_service.mapper.shopping_backstage_auditGoods.AuditGoodsService;
import com.zhkj.shopmall.shoppingbackstage.shopping_backstage_tools.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuditGoodsController {

    @Autowired
    private AuditGoodsService auditGoodsService;

    @RequestMapping("/getAuditGoodsMsg")
    public PageBean<AuditgoodsEntity> getAuditGoodsMsg(int currentPage, int pageSize) {
        int a=currentPage;
        int b=pageSize;
        return auditGoodsService.getAuditGoodsMsg(currentPage,pageSize);
    }

    @RequestMapping("/saveAuditGoodsMsg")
    public int saveAuditGoodsMsg(AuditgoodsEntity auditgoodsEntity) {
        return auditGoodsService.saveAuditGoodsMsg(auditgoodsEntity);
    }

    @RequestMapping("/updateAuditGoodsMsg")
    public int updateAuditGoodsMsg(AuditgoodsEntity auditgoodsEntity) {
        return auditGoodsService.updateAuditGoodsMsg(auditgoodsEntity);
    }

    @RequestMapping("/delAuditGoodsMsg")
    public int delAuditGoodsMsg(AuditgoodsEntity auditgoodsEntity) {
        return auditGoodsService.delAuditGoodsMsg(auditgoodsEntity);
    }

}
