package com.zhkj.shopmall.shoppingbackstage.shopping_backstage_dao.mapper.shopping_backstage_audit;

import com.zhkj.shopmall.shoppingbackstage.shopping_backstage_dao.entity.AuditEntity;
import com.zhkj.shopmall.shoppingbackstage.shopping_backstage_dao.entity.AuditTypeEntity;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AuditMapper {

    List<AuditTypeEntity> getAuditType();

    List<AuditEntity> getMsg(@Param("auditEntity") AuditEntity auditEntity, @Param("currentPage") int currentPage, @Param("pageSize") int pageSize);

    int getAuditCount(AuditEntity auditEntity);

    int saveMsg(AuditEntity auditEntity);

    int updateMsg(AuditEntity auditEntity);

    int delMsg(AuditEntity auditEntity);




}
