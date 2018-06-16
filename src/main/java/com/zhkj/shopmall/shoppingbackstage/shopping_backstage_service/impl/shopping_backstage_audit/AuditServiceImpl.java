package com.zhkj.shopmall.shoppingbackstage.shopping_backstage_service.impl.shopping_backstage_audit;

import com.zhkj.shopmall.shoppingbackstage.shopping_backstage_dao.entity.AuditEntity;
import com.zhkj.shopmall.shoppingbackstage.shopping_backstage_dao.mapper.shopping_backstage_audit.AuditMapper;
import com.zhkj.shopmall.shoppingbackstage.shopping_backstage_service.mapper.shopping_backstage_audit.AuditService;
import com.zhkj.shopmall.shoppingbackstage.shopping_backstage_tools.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuditServiceImpl implements AuditService {


    @Autowired
    private AuditMapper auditMapper;

    @Override
    public PageBean<AuditEntity> getMsg(AuditEntity auditEntity, int currentPage, int pageSize) {
        PageBean<AuditEntity> pageBean=new PageBean<>();
        int totalNum=auditMapper.getAuditCount(auditEntity);
        pageBean.countPage(totalNum,currentPage,pageSize);
        pageBean.setItems(auditMapper.getMsg(auditEntity,pageBean.getStartIndex(),pageBean.getPageSize()));
        return pageBean;
    }

    @Override
    public int saveMsg(AuditEntity auditEntity) {
        return auditMapper.saveMsg(auditEntity);
    }

    @Override
    public int updateMsg(AuditEntity auditEntity) {
        return auditMapper.updateMsg(auditEntity);
    }

    @Override
    public int delMsg(AuditEntity auditEntity) {
        return auditMapper.delMsg(auditEntity);
    }
}
