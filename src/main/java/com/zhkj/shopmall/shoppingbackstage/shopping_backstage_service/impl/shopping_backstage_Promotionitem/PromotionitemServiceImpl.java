package com.zhkj.shopmall.shoppingbackstage.shopping_backstage_service.impl.shopping_backstage_Promotionitem;

import com.zhkj.shopmall.shoppingbackstage.shopping_backstage_dao.entity.PromotionitemEntity;
import com.zhkj.shopmall.shoppingbackstage.shopping_backstage_dao.mapper.shopping_backstage_Promotionitem.PromotionitemMapper;
import com.zhkj.shopmall.shoppingbackstage.shopping_backstage_service.mapper.shopping_backstage_Promotionitem.PromotionitemService;
import com.zhkj.shopmall.shoppingbackstage.shopping_backstage_tools.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.List;

@Service
public class PromotionitemServiceImpl implements PromotionitemService {

    PageBean<PromotionitemEntity> pageBean=new PageBean<>();

    @Autowired
    private PromotionitemMapper promotionitemMapper;

    /**
     * 添加促销商品
     *
     * @param promotionitemEntity
     * @return
     */
    @Override
    public int saveMsg(PromotionitemEntity promotionitemEntity) {
        Date startTime=(promotionitemEntity.getStartTime());
        Date endTime=promotionitemEntity.getEndTime();
        return promotionitemMapper.saveMsg(promotionitemEntity);

    }

    @Override
    public PageBean<PromotionitemEntity> getMsg(PromotionitemEntity promotionitemEntity,int currentPage) {
        pageBean.setPageSize(5);
        pageBean.setTotalNum(promotionitemMapper.countMsg(promotionitemEntity));
        pageBean.countPage(pageBean.getTotalNum(),currentPage,pageBean.getPageSize());
        pageBean.setItems(promotionitemMapper.getMsg(promotionitemEntity,pageBean.getStartIndex(),pageBean.getPageSize()));
        return pageBean;
    }

    @Override
    public List<PromotionitemEntity> getMsgByid(PromotionitemEntity promotionitemEntity) {
        return promotionitemMapper.getMsgByid(promotionitemEntity);
    }

    @Override
    public int updateMsg(PromotionitemEntity promotionitemEntity) {
        return promotionitemMapper.updateMsg(promotionitemEntity);
    }

    @Override
    public int delMsg(int id) {
        return promotionitemMapper.delMsg(id);
    }
}