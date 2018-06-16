package com.zhkj.shopmall.shoppingbackstage.shopping_backstage_controller;

import com.zhkj.shopmall.shoppingbackstage.shopping_backstage_dao.entity.AuditEntity;
import com.zhkj.shopmall.shoppingbackstage.shopping_backstage_service.mapper.shopping_backstage_audit.AuditService;
import com.zhkj.shopmall.shoppingbackstage.shopping_backstage_tools.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuditController {


    @Autowired
    private AuditService auditService;

    @RequestMapping("/getAuditMsg")
    public PageBean<AuditEntity> getMsg(AuditEntity auditEntity, int currentPage, int pageSize) {
        return auditService.getMsg(auditEntity,currentPage,pageSize);
    }

    @RequestMapping("/saveAuditMsg")
    public int saveMsg(AuditEntity auditEntity) {
        return auditService.saveMsg(auditEntity);
    }


    @RequestMapping("/updateAuditMsg")
    public int updateMsg(AuditEntity auditEntity) {
        return auditService.updateMsg(auditEntity);
    }


    @RequestMapping("/delAuditMsg")
    public int delMsg(AuditEntity auditEntity) {
        return auditService.delMsg(auditEntity);
    }

}
