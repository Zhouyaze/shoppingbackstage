package com.zhkj.shopmall.shoppingbackstage.shopping_backstage_service.impl.shopping_backstage_Promotionitem;

import com.zhkj.shopmall.shoppingbackstage.shopping_backstage_dao.entity.PromotionitemEntity;
import com.zhkj.shopmall.shoppingbackstage.shopping_backstage_dao.mapper.shopping_backstage_Promotionitem.PromotionitemMapper;
import com.zhkj.shopmall.shoppingbackstage.shopping_backstage_service.mapper.shopping_backstage_Promotionitem.PromotionitemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PromotionitemServiceImpl implements PromotionitemService {

    @Autowired
    private PromotionitemMapper promotionitemMapper;

    @Override
    public int saveMsg(PromotionitemEntity promotionitemEntity) {
        return promotionitemMapper.saveMsg(promotionitemEntity);
    }

    @Override
    public List<PromotionitemEntity> getMsg(PromotionitemEntity promotionitemEntity) {
        return promotionitemMapper.getMsg(promotionitemEntity);
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
