package com.zhkj.shopmall.shoppingbackstage.shopping_backstage_service.mapper.shopping_backstage_auditGoods;

import com.zhkj.shopmall.shoppingbackstage.shopping_backstage_dao.entity.AuditgoodsEntity;
import com.zhkj.shopmall.shoppingbackstage.shopping_backstage_tools.PageBean;

public interface AuditGoodsService {

    PageBean<AuditgoodsEntity> getAuditGoodsMsg(int currentPage, int pageSize);

    int saveAuditGoodsMsg(AuditgoodsEntity auditgoodsEntity);

    int updateAuditGoodsMsg(AuditgoodsEntity auditgoodsEntity);

    int delAuditGoodsMsg(AuditgoodsEntity auditgoodsEntity);
}
