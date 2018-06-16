package com.zhkj.shopmall.shoppingbackstage.shopping_backstage_service.mapper.shopping_backstage_audit;

import com.zhkj.shopmall.shoppingbackstage.shopping_backstage_dao.entity.AuditEntity;
import com.zhkj.shopmall.shoppingbackstage.shopping_backstage_tools.PageBean;

public interface AuditService {

    PageBean<AuditEntity> getMsg(AuditEntity auditEntity, int currentPage, int pageSize);

    int saveMsg(AuditEntity auditEntity);

    int updateMsg(AuditEntity auditEntity);

    int delMsg(AuditEntity auditEntity);

}
