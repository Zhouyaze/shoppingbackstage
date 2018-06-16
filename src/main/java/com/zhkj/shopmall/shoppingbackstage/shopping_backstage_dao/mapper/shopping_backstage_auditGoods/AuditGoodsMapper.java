package com.zhkj.shopmall.shoppingbackstage.shopping_backstage_dao.mapper.shopping_backstage_auditGoods;

import com.zhkj.shopmall.shoppingbackstage.shopping_backstage_dao.entity.AuditgoodsEntity;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AuditGoodsMapper {

    List<AuditgoodsEntity> getAuditGoodsMsg(@Param("currentPage") int currentPage, @Param("pageSize") int pageSize);

    int getCount();

    int saveAuditGoodsMsg(AuditgoodsEntity auditgoodsEntity);

    int updateAuditGoodsMsg(AuditgoodsEntity auditgoodsEntity);

    int delAuditGoodsMsg(AuditgoodsEntity auditgoodsEntity);
}
