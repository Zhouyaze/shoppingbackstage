package com.zhkj.shopmall.shoppingbackstage.shopping_backstage_service.impl.shopping_backstage_auditGoods;

import com.zhkj.shopmall.shoppingbackstage.shopping_backstage_dao.entity.AuditgoodsEntity;
import com.zhkj.shopmall.shoppingbackstage.shopping_backstage_dao.mapper.shopping_backstage_auditGoods.AuditGoodsMapper;
import com.zhkj.shopmall.shoppingbackstage.shopping_backstage_service.mapper.shopping_backstage_auditGoods.AuditGoodsService;
import com.zhkj.shopmall.shoppingbackstage.shopping_backstage_tools.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuditGoodsServiceImpl implements AuditGoodsService {
    @Autowired
    private AuditGoodsMapper auditGoodsMapper;

    @Override
    public PageBean<AuditgoodsEntity> getAuditGoodsMsg(int currentPage, int pageSize) {
        PageBean<AuditgoodsEntity> pageBean=new PageBean<>();
        int totalNum=auditGoodsMapper.getCount();
        pageBean.countPage(totalNum,currentPage,pageSize);
        pageBean.setItems(auditGoodsMapper.getAuditGoodsMsg(pageBean.getStartIndex(),pageBean.getPageSize()));
        return pageBean;
    }


    @Override
    public int saveAuditGoodsMsg(AuditgoodsEntity auditgoodsEntity) {
        return auditGoodsMapper.saveAuditGoodsMsg(auditgoodsEntity);
    }

    @Override
    public int updateAuditGoodsMsg(AuditgoodsEntity auditgoodsEntity) {
        return auditGoodsMapper.updateAuditGoodsMsg(auditgoodsEntity);
    }

    @Override
    public int delAuditGoodsMsg(AuditgoodsEntity auditgoodsEntity) {
        return auditGoodsMapper.delAuditGoodsMsg(auditgoodsEntity);
    }
}
